package vivmallcn.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import vivmallcn.domain.Guide;
import vivmallcn.layout.support.web.MessageHelper;
import vivmallcn.service.IGuide;

@Controller
public class GuideController {

	@Autowired
	private IGuide guideService;
	

	@RequestMapping(value = { "admin/guide" }, method = RequestMethod.GET)
	public ModelAndView index(Locale locale) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("headTitle", "Guide");
		mav.addObject("guide",guideService.findOne("intro-001") );
		// System.out.println(aboutService.findByLang(locale.toString()).toString());

		mav.setViewName("admin/guide/guide");
		return mav;
	}

	@PostMapping("admin/guide/save")
	public String save(@Valid @ModelAttribute Guide guide,
			BindingResult result, RedirectAttributes ra,Model model) {
		//System.out.println(about.toString() +"1111");
		if (result.hasErrors()) {
			
			//System.out.println(result.getErrorCount());
			//System.out.println(result.getAllErrors());
			MessageHelper.addErrorAttribute(model, "save.fail");
			return "admin/guide/guide";
		} else
		{	
			
		 Guide aboutPersisted=guideService.findOne(guide.getId());
		 guide.setCreateDate(aboutPersisted.getCreateDate());
		 guide.setCreator(aboutPersisted.getCreator());
		 guide.setPersisted(true);
			guideService.save(guide);
		MessageHelper.addSuccessAttribute(ra, "save.success");
		return "redirect:/admin/guide";
		}
	}
}
