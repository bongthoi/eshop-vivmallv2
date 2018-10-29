package vivmallcn.serviceImpl;

import java.net.URLEncoder;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vivmallcn.domain.Orders;
import vivmallcn.domain.PaymentMethod;
import vivmallcn.layout.support.web.MD5Helper;
import vivmallcn.layout.support.web.URLUtils;
import vivmallcn.service.INganluong;
@Service
public class INganluongImpl implements INganluong {

	
/*	@Autowired
	private PaymentMethodRepository  paymentMethodRepository;
	
	@Autowired
	private	DeliveryMethodRepository	deliveryMethodRepository;*/
	@Autowired
	private	URLUtils	URLUtils;
	
	@Override
	public String API_Services(
								String merchant_site_code, 
								String return_url,
								String receiver, 
								String transaction_info, 
								String order_code,
								String price, 
								String currency, 
								float quantity, 
								float tax,
								float discount, 
								float fee_cal, 
								Double fee_shipping,
								String order_description, 
								String buyer_info, 
								String affiliate_code,
								String cancel_url,
								PaymentMethod paymentmethod) {
		// TODO Auto-generated method stub
		String secure_code_temp = merchant_site_code+ " " + return_url.toLowerCase() + " " + receiver;
		secure_code_temp += " " + transaction_info + " " + order_code + " " + price;
		secure_code_temp += " " + currency + " " + quantity + " " + tax;
		secure_code_temp += " " + discount + " " + fee_cal + " " + fee_shipping;
		secure_code_temp += " " + order_description + " " + buyer_info + " " + affiliate_code;
		secure_code_temp += " " + paymentmethod.getSecure_pass();
		
		secure_code_temp = secure_code_temp.trim();
		String md5_secure_code = MD5Helper.getMD5(secure_code_temp);
		
		String param = "merchant_site_code=" + merchant_site_code;
		param += "&return_url=" + URLEncoder.encode(return_url.toLowerCase());
		param += "&receiver=" + URLEncoder.encode(receiver);
		param += "&transaction_info=" + URLEncoder.encode(transaction_info);
		param += "&order_code=" + URLEncoder.encode(order_code);
		param += "&price=" + URLEncoder.encode(price.toString());
		param += "&currency=" + URLEncoder.encode(currency);
		param += "&quantity=" + URLEncoder.encode(String.valueOf(quantity));
		param += "&tax=" + URLEncoder.encode(String.valueOf(tax));
		param += "&discount=" + URLEncoder.encode(String.valueOf(discount));
		param += "&fee_cal=" + URLEncoder.encode(String.valueOf(fee_cal));
		param += "&fee_shipping=" + URLEncoder.encode(String.valueOf(fee_shipping));
		param += "&order_description=" + URLEncoder.encode(order_description);
		param += "&buyer_info=" + URLEncoder.encode(buyer_info);
		param += "&affiliate_code=" + URLEncoder.encode(affiliate_code);
		param += "&secure_code=" + URLEncoder.encode(md5_secure_code);
		param += "&cancel_url=" + URLEncoder.encode(cancel_url);
		
		String full_url=paymentmethod.getUrl()+param;
		
		return full_url.trim();
	}

	@Override
	public String Pay(Orders order,Locale locale,HttpServletRequest request) {
		// TODO Auto-generated method stub
		String transaction_info = "Thong+tin+giao+dich";
		String currency="vnd";
		float tax=0;
		float discount=0; 
		float fee_cal=0; 
		String buyer_info = order.getName() + "*|*" + order.getEmail() + "*|*" + order.getPhone() + "*|*" + order.getAddress();
		String affiliate_code = "";
		if(locale.toString().equalsIgnoreCase("vi")){
			currency="vnd";
		}else{
			currency="usd";
		}
		//PaymentMethod	payment_method=paymentMethodRepository.findOne(order.getPaymentMethod().getId());
		//DeliveryMethod	delivery_method=deliveryMethodRepository.findOne(order.getDeliveryMethod().getId());
		String returnUrl = URLUtils.getDomainName() + "/" + order.getPaymentMethod().getReturn_url();//payment_method.getReturn_url();
		String cancelUrl = URLUtils.getDomainName() + "/" + order.getPaymentMethod().getReturn_cancel();//payment_method.getReturn_cancel();
		return API_Services(
				order.getPaymentMethod().getMerchant_site_code(),//payment_method.getMerchant_site_code(),
				returnUrl,
				order.getPaymentMethod().getReceiver(),//payment_method.getReceiver(),
				transaction_info,
				order.getId(),
				order.getTotalAmount().toString(),
				currency,
				order.getTotalQuantity(),
				tax,
				discount,
				fee_cal,
				order.getDeliveryMethod().getFee(),//delivery_method.getFee(),
				order.getNote(),
				buyer_info,
				affiliate_code,
				cancelUrl,
				order.getPaymentMethod()//payment_method
				);
	}
	
	
}
