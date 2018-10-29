package vivmallcn.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vivmallcn.domain.Orders;
import vivmallcn.service.INganluong;

@Controller
public class testctrl {

	@Autowired
	private INganluong	iNganluong;
	
	@RequestMapping(value={"/admin/test"})
	public String index(Model model){
		model.addAttribute("headTitle", "test");
		return "admin/test/text";
	}
	@RequestMapping(value={"/user/test"})
	public String index2(Model model){
		model.addAttribute("headTitle", "test user");
		return "admin/test/text";
	}
	
	
	
}
