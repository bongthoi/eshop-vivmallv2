package vivmallcn.layout.support.web;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vivmallcn.domain.Product;
import vivmallcn.service.IProduct;



// Nạp giỏ hàng vào session
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
@Service("cart")
@Transactional
public class ShoppingCart {
	@Autowired
	private IProduct productService;
	
	Map<String, Product> map = new HashMap<String, Product>();
	
	public Collection<Product> getItems() {
		return map.values();
	}
	
	public void add(String id,Integer quantity) {
		if(quantity==null){
			quantity=1;
		}
		Product p = map.get(id);
		if(p != null){
			p.setQuantity(p.getQuantity() + quantity);
		}
		else{
			p = productService.findByid(id);
			p.setQuantity(quantity);
			map.put(id, p);
		}
	}
	public void remove(String id) {
		map.remove(id);
	}
	public void update(String string, Integer newQuantity) {
		Product p = map.get(string);
		p.setQuantity(newQuantity);
	}
	public void clear() {
		map.clear();
	}
	public Integer getCount() {
		Integer count = 0;
		for(Product p: map.values()){
			count += p.getQuantity();
		}
		return count;
	}
	public Double getAmount() {
		double amount =0;
		for(Product p: map.values()){
			amount += (p.getQuantity() * Double.parseDouble(""+ p.getSellPrice()));
		}
		
		return amount;
	}
}
