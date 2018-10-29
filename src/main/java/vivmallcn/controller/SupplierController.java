package vivmallcn.controller;

import java.security.Principal;

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

import vivmallcn.domain.Supplier;
import vivmallcn.layout.support.web.MessageHelper;
import vivmallcn.layout.support.web.PageWrapper;
import vivmallcn.service.IBusinessType;
import vivmallcn.service.ISupplier;

@Controller
public class SupplierController {
	@Autowired
	private ISupplier supplierService;
	
	@Autowired
	private IBusinessType businessTypeService;

	private void AddAtributeIntoForm(Model model){
		model.addAttribute("businesstypes", businessTypeService.findAll());
	}
	
	@RequestMapping(value = "/admin/supplier")
	private String index(Model model,	@RequestParam(value="page",required=false,defaultValue="1") int p) {
		
		if(p==0){
			p=1;
		}
		UriComponentsBuilder  uri=UriComponentsBuilder.fromPath("admin/supplier");
		PageRequest pageRequest=new  PageRequest(p-1, PageWrapper.MAX_PAGE_ITEM_DISPLAY, Direction.DESC,"id");
		Page<Supplier> s=supplierService.findAll(pageRequest);
		PageWrapper<Supplier> page = new PageWrapper<Supplier>(s, uri.build().toString());
		model.addAttribute("headTitle", "Supplier");
		model.addAttribute("suppliers", page.getContent());
		 model.addAttribute("page", page);
		return "admin/supplier/list";
	}


	@GetMapping("/admin/supplier/add")
	public String add(Model model,boolean isBidingResult){
		model.addAttribute("headTitle", "supplier Add new Item");
		model.addAttribute("h1", "Add item");
     	this.AddAtributeIntoForm(model);
		if(!isBidingResult){
			model.addAttribute("supplier", new Supplier());
		}
		return "admin/supplier/form";
	}
	
	@GetMapping(value = "/admin/supplier/{id}/edit")
	public String edit(Model model,boolean isBidingResult,@PathVariable(value="id") String id){
		model.addAttribute("headTitle", "Supplier Edit Item");
		model.addAttribute("h1", "Edit item");
		this.AddAtributeIntoForm(model);
		if(!isBidingResult){
			model.addAttribute("supplier",supplierService.findByid(id));
		}
		return "admin/supplier/form";
	}
	
	@PostMapping("/admin/supplier/save")
	public String Save(@Valid Supplier supplier,BindingResult result, RedirectAttributes ra,Principal suppliersession,Model model){
		
		  if(supplier.isNew()){
			  if (result.hasErrors()) {
			  	  return add(model,true);
			  	}
			  if(supplierService.isExists(supplier.getId())){
				  result.reject("global.error.supplier.id.exists", "#id is exists!");
				  //System.out.println("#!3");
				  return add(model,true);
			  }
			 
		  }else{
			  if (result.hasErrors()) {
			  	  return edit(model,true,supplier.getId());
			  	}
		  }
		  try{
		
			  supplierService.save(supplier);
			  MessageHelper.addSuccessAttribute(ra, "save.success");
		  }catch(Exception ex){
			  MessageHelper.addErrorAttribute(ra, "save.fail");
	  		throw(ex);
		  }
		  return "redirect:/admin/supplier";
		
	}

	@PostMapping(value="/admin/supplier/active")
	public String active(@RequestParam(value="arr_id") String[] arr_id,RedirectAttributes ra){
		try{
			  	
			supplierService.active(arr_id);
	    	    MessageHelper.addSuccessAttribute(ra, "active.success");
	    	  
  	   }catch(Exception ex){
  		   
  		    MessageHelper.addErrorAttribute(ra, "active.fail");
  			throw(ex);
	    	   
  	   }
		 return "redirect:/admin/supplier";
	}
	@PostMapping(value="/admin/supplier/disabled")
	public String disabled(@RequestParam(value="arr_id") String[] arr_id,RedirectAttributes ra){
		try{
			  	
			  supplierService.disabled(arr_id);
	    	    MessageHelper.addSuccessAttribute(ra, "disabled.success");
	    	  
  	   }catch(Exception ex){
  		   
  		    MessageHelper.addErrorAttribute(ra, "disabled.fail");
  			throw(ex);
	    	   
  	   }
		 return "redirect:/admin/supplier";
	}
	
	@PostMapping(value="/admin/supplier/delete")
	public String delete(@RequestParam(value="arr_id") String[] arr_id,RedirectAttributes ra){
		try{
			  	
			supplierService.delete(arr_id);
	    	    MessageHelper.addSuccessAttribute(ra, "delete.success");
	    	  
  	   }catch(Exception ex){
  		   
  		    MessageHelper.addErrorAttribute(ra, "delete.fail");
  			throw(ex);
	    	   
  	   }
		 return "redirect:/admin/supplier";
	}
}