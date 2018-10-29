package vivmallcn.controller;


import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vivmallcn.domain.Contact;
import vivmallcn.layout.support.web.MailSender;
import vivmallcn.layout.support.web.MessageHelper;
import vivmallcn.layout.support.web.ReCAPTCHAUtils;
import vivmallcn.service.IContact;



@Controller
public class FE_ContactCtrl {

	@Autowired
	private ReCAPTCHAUtils reCAPTCHAUtils;
	
	@Autowired
	MailSender mailSender;
	
	@Autowired
	private IContact icontactImp;
	
	@GetMapping("contact/create")
    public String create(Model model) {
		model.addAttribute("sitekey",reCAPTCHAUtils.getSITE_KEY());
		model.addAttribute("contact", new Contact());
		model.addAttribute("headTitle", "contact.title");
        return "shop/contact/form";
    }
	
	 @PostMapping("contact/save")
	    public String save(Model model,@Valid Contact contact, BindingResult result, RedirectAttributes ra,@RequestParam("g-recaptcha-response") String gRecaptchaResponse) {
		 if (result.hasErrors() || !reCAPTCHAUtils.verify(gRecaptchaResponse)) {
			 	MessageHelper.addErrorAttribute(ra, "contact.messages.send.fail");
			 	model.addAttribute("headTitle", "contact.title");
			 	return "redirect:/contact/create";
	        }
		 try{
			//contact.setSubject("New Contact");
			contact.setCreateDate(new Date());
			mailSender.send(contact.getEmail(),contact.getSubject(), contact.getContent());
			icontactImp.save(contact);
			 
	    	 MessageHelper.addSuccessAttribute(ra, "contact.messages.send.success");
 	   }catch(Exception ex){
 		    MessageHelper.addErrorAttribute(ra, "contact.messages.send.fail");
 			throw(ex);
	    	   
 	   }
			model.addAttribute("headTitle","contact.title");
	        return "redirect:/contact/create";
	    }
}
