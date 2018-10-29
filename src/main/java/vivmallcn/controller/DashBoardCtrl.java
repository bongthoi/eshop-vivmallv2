package vivmallcn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vivmallcn.service.IContact;
import vivmallcn.service.IOrders;
import vivmallcn.service.IUser;


@Controller
public class DashBoardCtrl {

	@Autowired
	private	IOrders iOrders;
	
	@Autowired
	private IUser	iUser;
	
	@Autowired
	private	IContact	iContact;
	
	
	@RequestMapping(value={"admin/DashBoard","admin","admin/"})
	public ModelAndView DashBoard(){
		ModelAndView mav=new ModelAndView();
		
		
		mav.addObject("neworders_count",iOrders.getNewOrderSize());
		mav.addObject("newusers_count",iUser.getNewUserSize());
		mav.addObject("newcontacts_count",iContact.getNewOrderSize());
		mav.addObject("headTitle", "DashBoard");
		mav.setViewName("admin/home/DashBoard");
		return mav;
	}
	 @GetMapping("/403")
	    public String accessDenied() {
	        return "403";
	    }
	 @GetMapping("/role")
	    public String getrole() {
	        return "role";
	    }
}
