package vivmallcn.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import vivmallcn.domain.Orders;
import vivmallcn.layout.support.web.PageWrapper;
import vivmallcn.service.IDeliveryMethod;
import vivmallcn.service.IOrders;
import vivmallcn.service.IPaymentMethod;
import vivmallcn.service.IProduct;

@Controller
public class  US_OrdersCtrl {
	@Autowired
	private IOrders ordersService;
	
	@Autowired
	private IProduct productService;
	
	@Autowired
	private IDeliveryMethod deliveryMethodService;
	
	@Autowired
	private IPaymentMethod paymentMethodService;

	private void AddAtributeIntoForm(Model model){
		model.addAttribute("deliveryMethods", deliveryMethodService.findAll());
		model.addAttribute("paymentMethods", paymentMethodService.findAll());
	}
	
	@RequestMapping(value={"_user/orders"})
	public String index(Model model,@RequestParam(value="page",required=false,defaultValue="1") int p,Principal principal){
		if(p==0){
			p=1;
		}
		UriComponentsBuilder  uri=UriComponentsBuilder.fromPath("user/orders");
		PageRequest pageRequest=new  PageRequest(p-1, PageWrapper.MAX_PAGE_ITEM_DISPLAY, Direction.DESC,"CreateDate");
		Page<Orders> s=ordersService.findByUserID(principal.getName(),pageRequest);
		PageWrapper< Orders> page = new PageWrapper<Orders>(s, uri.build().toString());
		model.addAttribute("headTitle", "layout.header.user.title");
		model.addAttribute("orderses", page.getContent());
		 model.addAttribute("page", page);
		return "user/orders/list";
	}
	
	@GetMapping("_user/orders/info/{id}")
	public String info(Model model,boolean isBidingResult,@PathVariable(value="id") String id){
		model.addAttribute("headTitle", "layout.orders.info.info");
		model.addAttribute("h1", "layout.orders.info.infoitem");
		this.AddAtributeIntoForm(model);
		model.addAttribute("orders",ordersService.findByidOnInfoPage(id));
		return "user/orders/info";
	}
	
}
