package vivmallcn.controller;

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

import vivmallcn.domain.News_category;
import vivmallcn.layout.support.web.MessageHelper;
import vivmallcn.layout.support.web.PageWrapper;
import vivmallcn.service.INews_categories;

@Controller
public class NewsCategoriesCtrl {

	@Autowired
	INews_categories	iNews_categories;
	
	@RequestMapping(value={"admin/newscategories"})
	public String getNewsCategories(Model model,	@RequestParam(value="page",required=false,defaultValue="1") int p){
		if(p==0){
			p=1;
		}
		UriComponentsBuilder  uri=UriComponentsBuilder.fromPath("admin/newscategories");
		PageRequest pageRequest=new  PageRequest(p-1, PageWrapper.MAX_PAGE_ITEM_DISPLAY, Direction.ASC,"ordered");
		Page<News_category> s=iNews_categories.findAll(pageRequest);
		PageWrapper<News_category> page = new PageWrapper<News_category>(s, uri.build().toString());
		model.addAttribute("headTitle", "news categories");
		model.addAttribute("newscategories", page.getContent());
		model.addAttribute("page", page);
		 
		return "admin/newscategories/list";
	}
	
	
	@RequestMapping(value={"admin/newscategories/add"})
	public String getForm(Model model,boolean isBidingResult){
		model.addAttribute("headTitle", "news category Add new Item");
		model.addAttribute("h1", "Add item");
		if(!isBidingResult){
			model.addAttribute("newscategory", new News_category());
		}
		 
		return "admin/newscategories/form";
	}
	
	@GetMapping("admin/newscategories/edit/{id}")
	public String edit(Model model,boolean isBidingResult,@PathVariable(value="id") Integer integer){
		model.addAttribute("headTitle", "category Edit Item");
		model.addAttribute("h1", "Edit item");
		if(!isBidingResult){
			model.addAttribute("newscategory",iNews_categories.findByid(integer));
		}
		return "admin/newscategories/form";
	}
	
	@PostMapping("admin/newscategories/save")
	public String Save(@Valid News_category newscategory,BindingResult result, RedirectAttributes ra,Model model){
		
		  if(newscategory.isNew()){
			  if (result.hasErrors()) {
			  	  return getForm(model,true);
			  	}
		  }else{
			  if (result.hasErrors()) {
			  	  return edit(model,true,newscategory.getId());
			  	}
		  }
		 try{
			 
		  iNews_categories.save(newscategory);
		  MessageHelper.addSuccessAttribute(ra, "save.success");
			  
		  }catch(Exception ex){
			  MessageHelper.addErrorAttribute(ra, "save.fail");
	  		throw(ex);
		  }
		  return "redirect:/admin/newscategories";
		
	}
	
	@PostMapping(value="admin/newscategories/active")
	public String active(@RequestParam(value="arr_id") String[] arr_id,RedirectAttributes ra){
		try{
			  	
			iNews_categories.active(arr_id);
	    	MessageHelper.addSuccessAttribute(ra, "active.success");
	    	  
  	   }catch(Exception ex){
  		   
  		    MessageHelper.addErrorAttribute(ra, "active.fail");
  			throw(ex);
	    	   
  	   }
		 return "redirect:/admin/newscategories";
	}
	
	@PostMapping(value="admin/newscategories/disabled")
	public String disabled(@RequestParam(value="arr_id") String[] arr_id,RedirectAttributes ra){
		try{
			  	
			iNews_categories.disabled(arr_id);
	    	MessageHelper.addSuccessAttribute(ra, "disabled.success");
	    	  
  	   }catch(Exception ex){
  		   
  		    MessageHelper.addErrorAttribute(ra, "disabled.fail");
  			throw(ex);
	    	   
  	   }
		 return "redirect:/admin/newscategories";
	}
	@PostMapping(value="admin/newscategories/delete")
	public String delete(@RequestParam(value="arr_id") String[] arr_id,RedirectAttributes ra){
		try{
			  	
			iNews_categories.delete(arr_id);
	    	MessageHelper.addSuccessAttribute(ra, "delete.success");
	    	  
  	   }catch(Exception ex){
  		   
  		    MessageHelper.addErrorAttribute(ra, "delete.fail");
  			throw(ex);
	    	   
  	   }
		 return "redirect:/admin/newscategories";
	}
}
