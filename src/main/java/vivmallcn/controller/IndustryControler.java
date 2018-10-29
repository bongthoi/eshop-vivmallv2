package vivmallcn.controller;

import java.security.Principal;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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

import vivmallcn.domain.Industry;
import vivmallcn.layout.support.web.MessageHelper;
import vivmallcn.layout.support.web.PageWrapper;
import vivmallcn.service.Iindustry;

@Controller
public class IndustryControler {
	@Autowired
	private ApplicationContext appContext;
	@Autowired
	private Iindustry industryService;
	
	@RequestMapping(value={"admin/industry"})
	public String index(Model model,	@RequestParam(value="page",required=false,defaultValue="1") int p){
		if(p==0){
			p=1;
		}
		UriComponentsBuilder  uri=UriComponentsBuilder.fromPath("admin/industry");
		PageRequest pageRequest=new  PageRequest(p-1, PageWrapper.MAX_PAGE_ITEM_DISPLAY, Direction.ASC,"IndustryOrder");
		Page<Industry> s=industryService.findAll(pageRequest);
		PageWrapper<Industry> page = new PageWrapper<Industry>(s, uri.build().toString());
		
		model.addAttribute("headTitle", "Industry");
		model.addAttribute("industrys", page.getContent());
		 model.addAttribute("page", page);
		return "admin/industry/list";
	}
	
	
	@GetMapping("admin/industry/add")
	public String add(Model model,boolean isBidingResult){
		model.addAttribute("headTitle", "industry Add new Item");
		model.addAttribute("h1", "Add item");
		if(!isBidingResult){
			model.addAttribute("industry", new Industry());
		}
		return "admin/industry/form";
	}
	
	@GetMapping("admin/industry/edit/{id}")
	public String edit(Model model,boolean isBidingResult,@PathVariable(value="id") Integer integer){
		model.addAttribute("headTitle", "industry Edit Item");
		model.addAttribute("h1", "Edit item");
		if(!isBidingResult){
			model.addAttribute("industry",industryService.findByid(integer));
		}
		return "admin/industry/form";
	}
	
	@PostMapping("admin/industry/save")
	public String Save(@Valid Industry industry,BindingResult result, RedirectAttributes ra,Locale locale,Principal industrysession,Model model){
		
		
		  if(industry.isNew()){
			  if (result.hasErrors()) {
			  	  return add(model,true);
			  	}
			  if(industryService.isExists(industry.getId())){
				  result.reject("global.error.industry.id.exists", "#id is exists!");
				  //System.out.println("#!3");
				  return add(model,true);
			  }
			  //System.out.println("!@3");
		  }else{
			  
			  if (result.hasErrors()) {
			  	  return edit(model,true,industry.getId());
			  	}
		  }
		  try{
			  
			  industryService.save(industry);
			  MessageHelper.addSuccessAttribute(ra, "save.success");
		  }catch(Exception ex){
			  MessageHelper.addErrorAttribute(ra, "save.fail");
	  		throw(ex);
		  }
		  return "redirect:/admin/industry";
		
	}

	@PostMapping(value="admin/industry/active")
	public String active(@RequestParam(value="arr_id") String[] arr_id,RedirectAttributes ra){
		try{
			  	
			industryService.active(arr_id);
	    	    MessageHelper.addSuccessAttribute(ra, "active.success");
	    	  
  	   }catch(Exception ex){
  		   
  		    MessageHelper.addErrorAttribute(ra, "active.fail");
  			throw(ex);
	    	   
  	   }
		 return "redirect:/admin/industry";
	}
	@PostMapping(value="admin/industry/disabled")
	public String disabled(@RequestParam(value="arr_id") String[] arr_id,RedirectAttributes ra){
		try{
			  	
			  industryService.disabled(arr_id);
	    	    MessageHelper.addSuccessAttribute(ra, "disabled.success");
	    	  
  	   }catch(Exception ex){
  		   
  		    MessageHelper.addErrorAttribute(ra, "disabled.fail");
  			throw(ex);
	    	   
  	   }
		 return "redirect:/admin/industry";
	}
	
	@PostMapping(value="admin/industry/delete")
	public String delete(@RequestParam(value="arr_id") String[] arr_id,RedirectAttributes ra){
		try{
			  	
			industryService.delete(arr_id);
	    	    MessageHelper.addSuccessAttribute(ra, "delete.success");
	    	  
  	   }catch(Exception ex){
  		   
  		    MessageHelper.addErrorAttribute(ra, "delete.fail");
  			throw(ex);
	    	   
  	   }
		 return "redirect:/admin/industry";
	}
	
	
}
