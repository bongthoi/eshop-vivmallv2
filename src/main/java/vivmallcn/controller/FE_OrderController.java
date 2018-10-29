package vivmallcn.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import vivmallcn.domain.Mail;
import vivmallcn.domain.Orders;
import vivmallcn.domain.OrdersDetail;
import vivmallcn.domain.Product;
import vivmallcn.domain.User;
import vivmallcn.layout.support.web.CustomDecimalFormatter;
import vivmallcn.layout.support.web.ShoppingCart;
import vivmallcn.layout.support.web.URLUtils;
import vivmallcn.service.EmailService;
import vivmallcn.service.IDeliveryMethod;
import vivmallcn.service.INganluong;
import vivmallcn.service.IOrders;
import vivmallcn.service.IPaymentMethod;
import vivmallcn.service.IPaypal;
import vivmallcn.service.IUser;

@Controller
@RequestMapping("/")
public class FE_OrderController {

	@Value("${paypal.paymentintent}")
    private String PaypalPaymentIntent;
	
	@Value("${paypal.paymentmethod}")
    private String PaypalPaymentMethod;
	
	public static final String PAYPAL_SUCCESS_URL = "pay/success";
	public static final String PAYPAL_CANCEL_URL = "pay/cancel";
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Value("${spring.mail.username}")
    private String AdMail;
	
	@Autowired
	private IPaypal paypalService;
	
	@Autowired
	ShoppingCart cart;
	
	@Autowired
	private IDeliveryMethod deliveryMethodService;
	
	@Autowired
	private IPaymentMethod paymentMethodService;
	
	@Autowired
	private IOrders ordersService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private IUser userService;
	
	@Autowired
	private	INganluong	iNganluong;
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private	URLUtils	URLUtils;
	
	private Orders  Global_Order=new Orders();
	
	@RequestMapping(value={"order/checkout"})
	public String checkout(Model model,Principal principal){
		if(cart.getItems().isEmpty()){
			model.addAttribute("headTitle", "checkout.title");
			return "shop/cart/view";
		}	
		this.AddAtributeIntoForm(model);
		Orders order=new Orders();
		User user=userService.findOne(principal.getName());
		
		order.setName(user.getFirstName());
		order.setEmail(user.getUsername());
		order.setPhone(user.getPhone());
		order.setAddress(user.getAddress());
		
		order.setDeliveryMethod(deliveryMethodService.findByActive().get(0));
		order.setPaymentMethod(paymentMethodService.findByActive().get(0));
		
		order.setTotalQuantity(cart.getCount());
		order.setTotalAmount(BigDecimal.valueOf(cart.getAmount()));
		
		model.addAttribute("orders",order);
		model.addAttribute("headTitle", "checkout.title");
		return "shop/order/checkout";
	}
	@GetMapping(value="product/get/shipping/{deliveryid}")
	 @ResponseBody
	 public String getShippingFee(@PathVariable("deliveryid") Integer deliveryid){
		
	   return CustomDecimalFormatter.convertToDecimal(deliveryMethodService.findOne(deliveryid).getFee());
	 }
	/*@RequestMapping(value={"order/checkout/{deliveryid}"})
	public String checkoutwithDelivery(Model model,@PathVariable("deliveryid") Integer deliveryid,Principal principal){
		if(cart.getItems().isEmpty()){
			model.addAttribute("headTitle", "checkout.title");
			return "shop/cart/view";
		}
		this.AddAtributeIntoForm(model);
		Orders order=new Orders();
		User user=userService.findOne(principal.getName());
		
		order.setName(user.getFirstName());
		order.setEmail(user.getUsername());
		order.setPhone(user.getPhone());
		order.setAddress(user.getAddress());
		if(deliveryid!=null){
			order.setDeliveryMethod(deliveryMethodService.findOne(deliveryid));
		}else{
			order.setDeliveryMethod(deliveryMethodService.findByActive().get(0));
		}
		order.setPaymentMethod(paymentMethodService.findByActive().get(0));
		
		
		model.addAttribute("orders",order);
		
		model.addAttribute("headTitle", "checkout.title");
		return "shop/order/checkout";
	}*/
	@RequestMapping(value={"order/payment"})
	public String purchase(Model model,@Valid @ModelAttribute  Orders orders,BindingResult result,RedirectAttributes ra,Locale	locale,HttpServletRequest request,Principal	principal){
		if (result.hasErrors()) {
				model.addAttribute("headTitle", "checkout.title");
		  	//return "shop/order/checkout";
		  	return "redirect:/order/checkout";
		  	}
		try{
			 List<OrdersDetail> details = new ArrayList<>();
			 Global_Order=orders;
			 
			 Global_Order.setCreateDate(new Date());
			 Global_Order.setId(ordersService.GenarateId());
			 Global_Order.setIsCheck(0);
			 Global_Order.setPaymentMethod(paymentMethodService.findByid(Global_Order.getPaymentMethod().getId()));
			 Global_Order.setDeliveryMethod(deliveryMethodService.findOne(Global_Order.getDeliveryMethod().getId()));
			  for (Product p : cart.getItems()) {
				 
				  OrdersDetail detail = new OrdersDetail();
				  
				  
				  detail.setProductId(p.getId());
				  detail.setProductName(p.getProductName());
				  detail.setUnit(p.getUnit());
				  detail.setQuantity(p.getQuantity());
				  detail.setPrice(p.getSellPrice());
				  detail.setPrice1(p.getSellPrice1());;
				  detail.setOrdersId(Global_Order.getId());
				  
				  details.add(detail);
				 
			  }
			  
			  Global_Order.setOrdersDetails(details);
			  Global_Order.setTotalQuantity(cart.getCount());
			  Global_Order.setTotalAmount(BigDecimal.valueOf(cart.getAmount()));

			  switch(Global_Order.getPaymentMethod().getId())
			  {
			  
			  case 1:
				  return "redirect:/checkout_success?error_text=";
			  case 2:
				  return "redirect:/paypal";
			  case 3:
				  return "redirect:" + iNganluong.Pay(Global_Order, locale,request);
			  default:
				  model.addAttribute("headTitle", "checkout.title");
				  return "redirect:/checkout_cancel";
			  }
			 // MessageHelper.addSuccessAttribute(ra, "save.success");
		  }catch(Exception ex){
			  System.out.print(ex.getMessage());
			  model.addAttribute("headTitle", "checkout.title");
			  return "redirect:/checkout_cancel";
		  }
		
		//return "shop/order/payment";
	}
	
	@RequestMapping(value = "paypal",method = {RequestMethod.GET, RequestMethod.POST})
	public String pay(@ModelAttribute  Orders orders,HttpServletRequest request,Locale locale){
		String cancelUrl = URLUtils.getDomainName() + "/" + PAYPAL_CANCEL_URL;
		String successUrl = URLUtils.getDomainName() + "/" + PAYPAL_SUCCESS_URL;
		String currency="vnd";
		if(locale.getLanguage().equalsIgnoreCase("vi")){
			currency="vnd";
		}else{
			currency="usd";
		}
		try {
			Payment payment = paypalService.createPayment(
					cart.getAmount(), 
					currency, 
					PaypalPaymentMethod, 
					PaypalPaymentIntent,
					"Vivmall description", 
					cancelUrl, 
					successUrl);
			
			for(Links links : payment.getLinks()){
				if(links.getRel().equals("approval_url")){
					return "redirect:" + links.getHref();
				}
			}
		} catch (PayPalRESTException e) {
			log.error(e.getMessage());
		}
		return "redirect:/";
	}

	@RequestMapping(method = RequestMethod.GET, value = PAYPAL_CANCEL_URL)
	public String cancelPay(Model model){
		return "redirect:/checkout_cancel";
	}

	@RequestMapping(method = RequestMethod.GET, value = PAYPAL_SUCCESS_URL)
	public String successPay(Model model,@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId,Principal	principal,Locale	locale) throws MessagingException, IOException{
		try {
			Payment payment = paypalService.executePayment(paymentId, payerId);
			if(payment.getState().equals("approved")){
				return "redirect:/checkout_success?error_text=";
			}
		} catch (PayPalRESTException e) {
			log.error(e.getMessage());
			return "redirect:/checkout_cancel";
		}
		return "redirect:/checkout_cancel";
	}
	
	private void AddAtributeIntoForm(Model model){
		model.addAttribute("deliveryMethods", deliveryMethodService.findByActive());
		model.addAttribute("paymentMethods", paymentMethodService.findByActive());
	}
	
	public Mail setupEmail(Orders orders,Principal	principal,Locale	locale){
		Mail mail = new Mail();
		mail.setFrom(AdMail);
        mail.setTo(orders.getEmail());
        mail.setSubject(messageSource.getMessage("email.order.subject", null, locale));
        Map<String, Object> email_model = new HashMap<String, Object>();
        email_model.put("orders", orders);
        email_model.put("user", userService.findOne(principal.getName()));
        mail.setModel(email_model);
		return	mail;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "checkout_cancel")
	public String nl_cancel(Model model,@RequestParam(value = "error_text", required = false, defaultValue = "") String error_text){
		model.addAttribute("error_text", error_text);
		model.addAttribute("headTitle", "checkout.title");
		return "shop/order/cancel";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "checkout_success")
	public String nl_success(Model model,@RequestParam(value = "error_text", required = false, defaultValue = "") String error_text,Principal	principal,Locale	locale) throws MessagingException, IOException{
		
		if(error_text.equalsIgnoreCase("")){
			ordersService.save(Global_Order);
	        emailService.sendSimpleMessage(setupEmail(Global_Order,principal,locale),"shop/email/confirm-email");
			cart.clear();
			
			model.addAttribute("headTitle", "checkout.title");
			return "shop/order/success";
			
		}else{
		
			model.addAttribute("error_text", error_text);
			model.addAttribute("headTitle", "checkout.title");
			
			return "shop/order/cancel";
		}
	}
}
