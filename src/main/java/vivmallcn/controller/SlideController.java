package vivmallcn.controller;

import java.security.Principal;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vivmallcn.domain.Slide;
import vivmallcn.layout.support.web.MessageHelper;
import vivmallcn.service.ISlide;

@Controller
public class SlideController {
	@Autowired
	private ISlide slideService;

	@RequestMapping(value = "admin/slide")
	private String index(Model model) {
		model.addAttribute("slides", slideService.findAll());
		return "admin/slide/list";
	}

	@GetMapping(value = "admin/slide/create")
	private String create(Model model) {
		model.addAttribute("slide", new Slide());
		return "admin/slide/form";
	}

	@PostMapping(value = "admin/slide/save")
	private String save(@Valid Slide slide, BindingResult result,
			RedirectAttributes redirect, Principal user, Model model) {
		if (result.hasErrors()) {
			// System.out.println(result.getErrorCount());
			// System.out.println(result.getAllErrors());
			MessageHelper.addErrorAttribute(model, "save.fail");
			return "admin/slide/form";
		}
		slide.setCreateDate(new Date());
		slide.setCreator(user.getName());
		slideService.save(slide);
		MessageHelper.addSuccessAttribute(redirect, "save.success");
		return "redirect:/admin/slide";
	}

	@GetMapping(value = "admin/slide/{id}/edit")
	private String edit(Model model, @PathVariable(value = "id") int id) {
		model.addAttribute("slide", slideService.findOne(id));
		return "admin/slide/form";
	}

	@GetMapping(value = "admin/slide/{id}/delete")
	private String delete(Model model, @PathVariable(value = "id") int id,
			RedirectAttributes redirect) {
		slideService.delete(id);
		MessageHelper.addSuccessAttribute(redirect, "delete.success");
		return "redirect:/admin/slide";
	}
}
