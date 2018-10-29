package vivmallcn.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vivmallcn.layout.support.web.URLUtils;
import vivmallcn.service.IAbout;

@Controller
public class FE_AboutCtrl {

	@Autowired
	private IAbout aboutService;
	
	@Autowired
	private	URLUtils	URLUtils;
	
	@RequestMapping(value = { "about" }, method = RequestMethod.GET)
	public ModelAndView index(Locale locale) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("about",aboutService.findOne("about-001") );
		
		mav.setViewName("shop/about/list");
		mav.addObject("headTitle", "about.title");
		return mav;
	}

	@GetMapping("nameserver")
	public String test(Model model,HttpServletResponse response,HttpServletRequest request) {
		 	
		
		model.addAttribute("nameserver",request.getServerName());
		model.addAttribute("requesturl", request.getRequestURL().toString());
		
	  return	"shop/about/nameserver";
	}
}
