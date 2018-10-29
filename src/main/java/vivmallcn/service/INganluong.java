package vivmallcn.service;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import vivmallcn.domain.Orders;
import vivmallcn.domain.PaymentMethod;

public interface INganluong {

	/*API NganLuong*/
	public	String API_Services(
			String	merchant_site_code,
			String	return_url,
			String	receiver, 
			String	transaction_info,
			String	order_code, 
			String	price, 
			String	currency, 
			float	quantity, 
			float	tax, 
			float	discount, 
			float	fee_cal,
			Double	fee_shipping, 
			String	order_description, 
			String	buyer_info, 
			String	affiliate_code,
			String	cancel_url,PaymentMethod paymentmethod);
	
	
	
	public	String Pay(Orders order, Locale locale,HttpServletRequest request); 
	
	
}


