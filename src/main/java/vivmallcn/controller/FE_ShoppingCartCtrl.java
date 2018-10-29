package vivmallcn.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import vivmallcn.domain.Product;
import vivmallcn.layout.support.web.ShoppingCart;

@Controller
@RequestMapping("cart")
@Transactional
public class FE_ShoppingCartCtrl {

	@Autowired
	ShoppingCart cart;
	
	@ResponseBody
	@RequestMapping("add/{id}/{number}")
	public String add(@PathVariable("id") String id,@PathVariable("number") Integer number) {
		cart.add(id,number);
		String s = "{\"count\":%d}";
		return String.format(s, cart.getCount());
	}
	
	
	@RequestMapping("{id}/remove")
	public String remove(Model model,@PathVariable("id") String id) {
		cart.remove(id);
		model.addAttribute("headTitle", "cart.title");
		return "shop/cart/view";
	}
	
	@RequestMapping("view")
	public String view(Model model) {
		model.addAttribute("headTitle", "cart.title");
		return "shop/cart/view";
	}
	
	@RequestMapping("clear")
	public String clear(Model model) {
		cart.clear();
		model.addAttribute("headTitle", "cart.title");
		return "shop/cart/view";
	}
	
	@RequestMapping("update")
	public String update(Model model,HttpServletRequest request) {
		for(Product p: cart.getItems()){
			String id = p.getId().toString();
			int newQty = Integer.parseInt(request.getParameter(id));
			cart.update(p.getId(), newQty);
		}
		model.addAttribute("headTitle", "cart.title");
		return "shop/cart/view";
	}
}
