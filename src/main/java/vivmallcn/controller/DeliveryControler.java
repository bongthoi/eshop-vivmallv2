package vivmallcn.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vivmallcn.domain.DeliveryMethod;
import vivmallcn.layout.support.web.MessageHelper;
import vivmallcn.service.IDeliveryMethod;

@Controller
public class DeliveryControler {
	
	@Autowired
	private IDeliveryMethod iDeliveryMethod;
	
	@RequestMapping(value={"admin/delivery"})
	public String index(Model model){
		
		model.addAttribute("deliveries", iDeliveryMethod.findAll());
		model.addAttribute("headTitle", "Delivery");
		
		return "admin/delivery/list";
	}
	
	
	@GetMapping("admin/delivery/add")
	public String add(Model model,boolean isBidingResult){
		
		if(!isBidingResult){
			model.addAttribute("delivery", new DeliveryMethod());
		}
		
		model.addAttribute("headTitle", "Delivery Add new Item");
		model.addAttribute("h1", "Add item");
		return "admin/delivery/form";
	}
	
	@GetMapping("admin/delivery/edit/{id}")
	public String edit(Model model,boolean isBidingResult,@PathVariable(value="id") Integer integer){
		if(!isBidingResult){
			model.addAttribute("delivery",iDeliveryMethod.findOne(integer));
		}
		
		model.addAttribute("headTitle", "Delivery Edit Item");
		model.addAttribute("h1", "Edit item");
		return "admin/delivery/form";
	}
	
	@PostMapping("admin/delivery/save")
	public String Save(@Valid DeliveryMethod delivery,BindingResult result, RedirectAttributes ra,Model model){
		
		
		  if(delivery.isNew()){
			  if (result.hasErrors()) {
			  	  return add(model,true);
			  	}
			  if(iDeliveryMethod.isExists(delivery.getId())){
				  result.reject("global.error.industry.id.exists", "#id is exists!");
				  //System.out.println("#!3");
				  return add(model,true);
			  }
			  //System.out.println("!@3");
		  }else{
			  if (result.hasErrors()) {
			  	  return edit(model,true,delivery.getId());
			  	}
		  }
		  try{
			  
			  iDeliveryMethod.save(delivery);
			  MessageHelper.addSuccessAttribute(ra, "save.success");
		  }catch(Exception ex){
			  MessageHelper.addErrorAttribute(ra, "save.fail");
	  		throw(ex);
		  }
		  return "redirect:/admin/delivery";
		
	}

	@PostMapping(value="admin/delivery/active")
	public String active(@RequestParam(value="arr_id") String[] arr_id,RedirectAttributes ra){
		try{
			iDeliveryMethod.active(arr_id);
	    	MessageHelper.addSuccessAttribute(ra, "active.success");
	    	  
  	   }catch(Exception ex){
  		   
  		    MessageHelper.addErrorAttribute(ra, "active.fail");
  			throw(ex);
	    	   
  	   }
		 return "redirect:/admin/delivery";
	}
	@PostMapping(value="admin/delivery/disabled")
	public String disabled(@RequestParam(value="arr_id") String[] arr_id,RedirectAttributes ra){
		try{
			  	
			iDeliveryMethod.disabled(arr_id);
	    	MessageHelper.addSuccessAttribute(ra, "disabled.success");
	    	  
  	   }catch(Exception ex){
  		   
  		    MessageHelper.addErrorAttribute(ra, "disabled.fail");
  			throw(ex);
	    	   
  	   }
		 return "redirect:/admin/delivery";
	}
	
	@PostMapping(value="admin/delivery/delete")
	public String delete(@RequestParam(value="arr_id") String[] arr_id,RedirectAttributes ra){
		try{
			  	
			iDeliveryMethod.delete(arr_id);
	    	MessageHelper.addSuccessAttribute(ra, "delete.success");
	    	  
  	   }catch(Exception ex){
  		   
  		    MessageHelper.addErrorAttribute(ra, "delete.fail");
  			throw(ex);
	    	   
  	   }
		 return "redirect:/admin/delivery";
	
	}
	
}