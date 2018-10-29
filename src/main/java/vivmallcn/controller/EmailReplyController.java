package vivmallcn.controller;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import org.springframework.web.util.UriComponentsBuilder;

import vivmallcn.layout.support.web.MailSender;
import vivmallcn.layout.support.web.MessageHelper;
import vivmallcn.layout.support.web.PageWrapper;
import vivmallcn.domain.Emailfeedback;
import vivmallcn.service.IContact;
import vivmallcn.service.IEmail;



@Controller
public class EmailReplyController {
	
	@Autowired
	private IContact iContactImpl;
	
	@Autowired
	private IEmail iEmailImpl;
	
	@Autowired
	MailSender mailSender;
	
	/*@RequestMapping(value="admin/emails")
	public String getUsers(Model model){
		
		model.addAttribute("emails", iEmailImpl.findAll());
		return "admin/email/list";
		
	}*/
	@RequestMapping(value="admin/emails")
	private String index(Model model,	@RequestParam(value="page",required=false,defaultValue="1") int p) {
		
		if(p==0){
			p=1;
		}
		UriComponentsBuilder  uri=UriComponentsBuilder.fromPath("admin/emails	");
		PageRequest pageRequest=new  PageRequest(p-1, PageWrapper.MAX_PAGE_ITEM_DISPLAY, Direction.DESC,"id");
		Page<Emailfeedback> s=iEmailImpl.findAll(pageRequest);
		PageWrapper<Emailfeedback> page = new PageWrapper<Emailfeedback>(s, uri.build().toString());
		model.addAttribute("emails",page.getContent());
		
		model.addAttribute("headTitle", "Emails");
		 model.addAttribute("page", page);

		return "admin/email/list";
	}
	
	
	@RequestMapping(value="admin/email/{contact_id}/reply")
	public String Edit(Model model,@PathVariable(value="contact_id") int contact_id){
		if(iContactImpl.exists(contact_id)){
			
			
			Emailfeedback emailfeedback=new Emailfeedback();
			emailfeedback.setTo_email(iContactImpl.findOne(contact_id).getEmail());
			emailfeedback.setContact_id(contact_id);
			
			model.addAttribute("emailfeedback", emailfeedback);
			model.addAttribute("headTitle", "Mail Form");
			model.addAttribute("h1", "Reply email");
			
			return "admin/email/form";
		}
		else{
			return "redirect:/admin/contacts"; 
		}
	}
	
	@RequestMapping("admin/email/send")
	public String savaUser( Emailfeedback emailfeedback,BindingResult result, RedirectAttributes redirect,RedirectAttributes ra,Principal principal){
		emailfeedback.setSenddate(new Date());
		if (result.hasErrors()) {
	        return "admin/email/form";    
	    }
		try{
			emailfeedback.setFrom_email(principal.getName());
			emailfeedback.setUserID(principal.getName());
			emailfeedback.setSenddate(new Date());
			
			mailSender.send(emailfeedback.getFrom_email(),emailfeedback.getTo_email(),emailfeedback.getSubject(),emailfeedback.getContent());
		
			iEmailImpl.save(emailfeedback);
			MessageHelper.addSuccessAttribute(ra, "save.success");
		}catch(Exception ex){
			MessageHelper.addErrorAttribute(ra, "save.fail");
	  		throw(ex);
		}
		return "redirect:/admin/emails";
	
		}
	}
