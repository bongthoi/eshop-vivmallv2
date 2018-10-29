package vivmallcn.controller;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vivmallcn.domain.Mail;
import vivmallcn.domain.User;
import vivmallcn.domain.frmChangePassword;
import vivmallcn.layout.support.web.MessageHelper;
import vivmallcn.layout.support.web.ReCAPTCHAUtils;
import vivmallcn.layout.support.web.URLUtils;
import vivmallcn.service.EmailService;
import vivmallcn.service.IRole;
import vivmallcn.service.IUser;



@Controller
public class FE_UserCtrl {

	@Autowired
	private	URLUtils	URLUtils;
	
	@Autowired
	private ReCAPTCHAUtils reCAPTCHAUtils;
	
	@Autowired
	private IUser userService;
	
	@Autowired
	private IRole roleService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Value("${spring.mail.username}")
    private String AdMail;
	
	@RequestMapping(value={"user/login/form"})
	public String loadFormLogin(Model model){
		
		model.addAttribute("headTitle", "user.login.title");
		return "shop/user/login";
	}
	
	
	@RequestMapping(value={"user/register"})
	public String loadRegisterForm(Model model,boolean isBidingResult){
		
		if(!isBidingResult){
			model.addAttribute("sitekey",reCAPTCHAUtils.getSITE_KEY());
			model.addAttribute("user", new User());
		}
		
		model.addAttribute("headTitle", "user.register.title");
		return "shop/user/register";
	}
	@PostMapping("user/save")
	public String Save(User user,Model model,BindingResult result, RedirectAttributes ra,@RequestParam("g-recaptcha-response") String gRecaptchaResponse,Locale locale){
		
		if (result.hasErrors() || !reCAPTCHAUtils.verify(gRecaptchaResponse)) {
				MessageHelper.addSuccessAttribute(ra, "register.form.message.fail");
	           // return "shop/user/register";
				 return "redirect:/user/register";
	        }
		
		  if(!user.isMatchPassword()){
			  result.reject("global.error.user.repassword.missmatch", "Retype password miss match!");
		  }
		
			  if(user.isNew()){
				  if(userService.isExists(user.getUsername())){
					  result.reject("global.error.user.username.exists", "UserName is exists!");
		
				  }
				  //System.out.println(result.getAllErrors().toString());
				  if (result.hasErrors()) {
				  	  return loadRegisterForm(model,true);
				  	}
			  }
			  
		  try{
			  //System.out.println(user.getRoles().toString());
			  Set<String> theRole = new HashSet<String>();
			  theRole.add(roleService.findOne("ROLE_USER").getId());
			  user.setRoles(theRole);
			  
			  
			  userService.save(user);
			  emailService.sendSimpleMessage(setupEmail(user,locale),"shop/user/confirm-email");
			  MessageHelper.addSuccessAttribute(ra, "register.form.message.success");
		  }catch(Exception ex){
			  MessageHelper.addErrorAttribute(ra, "register.form.message.fail");
			  return "redirect:/user/register";
		  }
		  return "redirect:/user/register";
		
	}
	
	@GetMapping("user/changepassword")
	public String changepassword(Model model,boolean isBidingResult,@RequestParam(value="username") String username){
		
		if(!isBidingResult){
			model.addAttribute("frmPass",new frmChangePassword(username));
		}
		model.addAttribute("headTitle", "changepassword.title");
		return "shop/user/changepassword";
	}
	
	@PostMapping("user/SubmitChangePassword")
	public String SubmitChangePassword(@Valid @ModelAttribute("frmPass") frmChangePassword frmPass,BindingResult result, RedirectAttributes ra ,Model model){
		  if(!frmPass.isMatchPassword()){
			  result.reject("global.error.user.repassword.missmatch", "global.error.user.repassword.missmatch");
		  }
		  if(!userService.isExists(frmPass.getUsername())){
			  result.reject("global.error.user.username.exists", "global.error.user.username.exists");

		  }
		  if (result.hasErrors()) {
				  	  return changepassword(model,true,frmPass.getUsername());
			}
		  try{
			  userService.ChangePassword(frmPass);
			  MessageHelper.addSuccessAttribute(ra, "save.success");
		  }catch(Exception ex){
			  MessageHelper.addErrorAttribute(ra, "save.fail");
	  		throw(ex);
		  }
		  
		  return "redirect:/user/changepassword?username="+frmPass.getUsername();
	}
	
	@GetMapping(value="user/activate")
	public String active(@RequestParam("id") String id,RedirectAttributes ra,Locale locale){
		try{
			  	
			userService.active(id);
			emailService.sendSimpleMessage(setupEmail(userService.findOne(id),locale),"shop/user/activated-email");
	    	MessageHelper.addSuccessAttribute(ra, "register.active.success");
	    	  
  	   }catch(Exception ex){
  		   
  		    MessageHelper.addErrorAttribute(ra, "register.active.fail");
  		  return "redirect:/user/login/form";
	    	   
  	   }
		 return "redirect:/user/login/form";
	}
	
	@RequestMapping(value={"403"})
	public String login(Model model,boolean isBidingResult){
		
		
		model.addAttribute("headTitle", "user.login.title");
		return "shop/user/accessdenied";
	}
	
	public Mail setupEmail(User user,Locale	locale){
		Mail mail = new Mail();
		mail.setFrom(AdMail);
        mail.setTo(user.getUsername());
        mail.setSubject(messageSource.getMessage("email.user.subject", null, locale));
        Map<String, Object> email_model = new HashMap<String, Object>();
        email_model.put("receiver", user);
        email_model.put("domain", URLUtils.getDomainName());
        mail.setModel(email_model);
		return	mail;
	}
	
	
	
}
