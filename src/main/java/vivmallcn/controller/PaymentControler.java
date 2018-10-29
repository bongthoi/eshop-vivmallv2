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

import vivmallcn.domain.PaymentMethod;
import vivmallcn.layout.support.web.MessageHelper;
import vivmallcn.service.IPaymentMethod;

@Controller
public class PaymentControler {
	
	@Autowired
	private IPaymentMethod iPaymentMethod;
	
	@RequestMapping(value={"admin/payment"})
	public String index(Model model){
		
		model.addAttribute("payments", iPaymentMethod.findAll());
		model.addAttribute("headTitle", "Payments");
		
		return "admin/payment/list";
	}
	
	
	@GetMapping("admin/payment/add")
	public String add(Model model,boolean isBidingResult){
		
		if(!isBidingResult){
			model.addAttribute("payment", new PaymentMethod());
		}
		
		model.addAttribute("headTitle", "Payment Add new Item");
		model.addAttribute("h1", "Add item");
		return "admin/payment/form";
	}
	
	@GetMapping("admin/payment/edit/{id}")
	public String edit(Model model,boolean isBidingResult,@PathVariable(value="id") Integer integer){
		if(!isBidingResult){
			model.addAttribute("payment",iPaymentMethod.findByid(integer));
		}
		
		model.addAttribute("headTitle", "payment Edit Item");
		model.addAttribute("h1", "Edit item");
		return "admin/payment/form";
	}
	
	@PostMapping("admin/payment/save")
	public String Save(@Valid PaymentMethod payment,BindingResult result, RedirectAttributes ra,Model model){
		
		
		  if(payment.isNew()){
			  if (result.hasErrors()) {
			  	  return add(model,true);
			  	}
			  if(iPaymentMethod.isExists(payment.getId())){
				  result.reject("global.error.industry.id.exists", "#id is exists!");
				  //System.out.println("#!3");
				  return add(model,true);
			  }
			  //System.out.println("!@3");
		  }else{
			  if (result.hasErrors()) {
			  	  return edit(model,true,payment.getId());
			  	}
		  }
		  try{
			  
			  iPaymentMethod.save(payment);
			  MessageHelper.addSuccessAttribute(ra, "save.success");
		  }catch(Exception ex){
			  MessageHelper.addErrorAttribute(ra, "save.fail");
	  		throw(ex);
		  }
		  return "redirect:/admin/payment";
		
	}

	@PostMapping(value="admin/payment/active")
	public String active(@RequestParam(value="arr_id") String[] arr_id,RedirectAttributes ra){
		try{
			iPaymentMethod.active(arr_id);
	    	MessageHelper.addSuccessAttribute(ra, "active.success");
	    	  
  	   }catch(Exception ex){
  		   
  		    MessageHelper.addErrorAttribute(ra, "active.fail");
  			throw(ex);
	    	   
  	   }
		 return "redirect:/admin/payment";
	}
	@PostMapping(value="admin/payment/disabled")
	public String disabled(@RequestParam(value="arr_id") String[] arr_id,RedirectAttributes ra){
		try{
			  	
			iPaymentMethod.disabled(arr_id);
	    	MessageHelper.addSuccessAttribute(ra, "disabled.success");
	    	  
  	   }catch(Exception ex){
  		   
  		    MessageHelper.addErrorAttribute(ra, "disabled.fail");
  			throw(ex);
	    	   
  	   }
		 return "redirect:/admin/payment";
	}
	
	@PostMapping(value="admin/payment/delete")
	public String delete(@RequestParam(value="arr_id") String[] arr_id,RedirectAttributes ra){
		try{
			  	
			iPaymentMethod.delete(arr_id);
	    	MessageHelper.addSuccessAttribute(ra, "delete.success");
	    	  
  	   }catch(Exception ex){
  		   
  		    MessageHelper.addErrorAttribute(ra, "delete.fail");
  			throw(ex);
	    	   
  	   }
		 return "redirect:/admin/payment";
	
	}
	
}