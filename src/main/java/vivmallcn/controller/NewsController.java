package vivmallcn.controller;

import java.security.Principal;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import vivmallcn.domain.News;
import vivmallcn.layout.support.web.MessageHelper;
import vivmallcn.layout.support.web.PageWrapper;
import vivmallcn.service.INews;
import vivmallcn.service.INews_categories;

@Controller
public class NewsController {

	@Autowired
	INews	iNews;
	
	@Autowired
	INews_categories	iNews_categories;
	
	private void AddAtributeIntoForm(Model model){
		model.addAttribute("newscategories", iNews_categories.findAll());
		
	}
	
	@RequestMapping(value={"admin/news"})
	public String index(Model model,@RequestParam(value="page",required=false,defaultValue="1") int p){
		if(p==0){
			p=1;
		}
		UriComponentsBuilder  uri=UriComponentsBuilder.fromPath("admin/news");
		PageRequest pageRequest=new  PageRequest(p-1, PageWrapper.MAX_PAGE_ITEM_DISPLAY, Direction.ASC,"id");
		Page<News> s=iNews.findAll(pageRequest);
		PageWrapper<News> page = new PageWrapper<News>(s, uri.build().toString());
		
		model.addAttribute("headTitle", "News");
		model.addAttribute("news", page.getContent());
		model.addAttribute("newscategories",iNews_categories.findAll());
		model.addAttribute("page", page);
		 
		return "admin/news/list";	
	}
	
	@GetMapping("admin/news/add")
	public String add(Model model,boolean isBidingResult){
		model.addAttribute("headTitle", "News");
		model.addAttribute("h1", "Add item");
		this.AddAtributeIntoForm(model);
		if(!isBidingResult){
			model.addAttribute("news", new News());
		}
		return "admin/news/form";
	}
	
	@GetMapping("admin/news/edit/{id}")
	public String edit(Model model,boolean isBidingResult,@PathVariable(value="id") Integer integer){
		model.addAttribute("headTitle", "News Edit Item");
		model.addAttribute("h1", "Edit item");
		this.AddAtributeIntoForm(model);
		if(!isBidingResult){
			model.addAttribute("news",iNews.findByid(integer));
		}
		return "admin/news/form";
	}
	
	@PostMapping("admin/news/save")
	public String Save(@Valid News news,BindingResult result, RedirectAttributes ra,Principal principal,Model model){
		
		  if(news.isNew()){
			  if (result.hasErrors()) {
			  	  return add(model,true);
			  	}
			  if(iNews.isExists(news.getId())){
				  result.reject("global.error.category.id.exists", "#id is exists!");
				  //System.out.println("#!3");
				  return add(model,true);
			  }
			  //System.out.println("!@3");
		  }else{
			  if (result.hasErrors()) {
			  	  return edit(model,true,news.getId());
			  	}
		  }
		  try{
			
			  news.setCreate_date(new Date());
			  news.setCreator(principal.getName());
			  iNews.save(news);
			  MessageHelper.addSuccessAttribute(ra, "save.success");
		  }catch(Exception ex){
			  MessageHelper.addErrorAttribute(ra, "save.fail");
	  		throw(ex);
		  }
		  return "redirect:/admin/news";
		
	}
	
	@PostMapping(value="admin/news/active")
	public String active(@RequestParam(value="arr_id") String[] arr_id,RedirectAttributes ra){
		try{
			iNews.active(arr_id);
	    	MessageHelper.addSuccessAttribute(ra, "active.success");
	    	  
  	   }catch(Exception ex){
  		   
  		    MessageHelper.addErrorAttribute(ra, "active.fail");
  			throw(ex);
	    	   
  	   }
		 return "redirect:/admin/news";
	}
	@PostMapping(value="admin/news/disabled")
	public String disabled(@RequestParam(value="arr_id") String[] arr_id,RedirectAttributes ra){
		try{
			  	
			iNews.disabled(arr_id);
	    	MessageHelper.addSuccessAttribute(ra, "disabled.success");
	    	  
  	   }catch(Exception ex){
  		   
  		    MessageHelper.addErrorAttribute(ra, "disabled.fail");
  			throw(ex);
	    	   
  	   }
		 return "redirect:/admin/news";
	}
	
	@PostMapping(value="admin/news/delete")
	public String delete(@RequestParam(value="arr_id") String[] arr_id,RedirectAttributes ra){
		try{
			  	
			iNews.delete(arr_id);
	    	MessageHelper.addSuccessAttribute(ra, "delete.success");
	    	  
  	   }catch(Exception ex){
  		   
  		    MessageHelper.addErrorAttribute(ra, "delete.fail");
  			throw(ex);
	    	   
  	   }
		 return "redirect:/admin/news";
	}
}
