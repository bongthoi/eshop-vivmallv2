package vivmallcn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import vivmallcn.domain.Product;
import vivmallcn.layout.support.web.PageWrapper;
import vivmallcn.service.ICategory;
import vivmallcn.service.IProduct;

@Controller
public class FE_ProductCtr {
	@Value("${PRODUCT_IN_RELATED}")
	private int PRODUCT_IN_RELATED;
	
	@Autowired
	private IProduct productService;
	
	@Autowired
	private ICategory categoryService;
	
	@RequestMapping(value={"product/search"})
	public String getList1(Model model,@RequestParam("search_key") String search_key,@RequestParam(value="page",required=false,defaultValue="1") int p){
		if(p==0){
			p=1;
		}
		UriComponentsBuilder  uri=UriComponentsBuilder.fromPath("product/search?search_key="+search_key);
		
		PageRequest pageRequest=new  PageRequest(p-1, PageWrapper.MAX_PAGE_ITEM_DISPLAY, Direction.DESC,"id");
		Page<Product> prod=productService.findLikeName(search_key,pageRequest);
		PageWrapper<Product> page = new PageWrapper<Product>(prod, uri.build().toString());
		
		model.addAttribute("products", page.getContent());
		model.addAttribute("page", page);
		model.addAttribute("category_name",search_key);
		model.addAttribute("headTitle", "search.product.title");
		return "shop/product/list";
	}
	
	@RequestMapping(value={"product/findByCate/{id}/*"})
	public String getProductByCate(Model model,@PathVariable("id") Integer id,@RequestParam(value="page",required=false,defaultValue="1") int p){
		if(p==0){
			p=1;
		}
		UriComponentsBuilder  uri=UriComponentsBuilder.fromPath("product/findByCate/"+id+"/list");
		PageRequest pageRequest=new  PageRequest(p-1, PageWrapper.MAX_PAGE_ITEM_DISPLAY, Direction.DESC,"id");
		Page<Product> prod=productService.findByCateID(id,pageRequest);
		PageWrapper<Product> page = new PageWrapper<Product>(prod, uri.build().toString());
		
		model.addAttribute("products", page.getContent());
		model.addAttribute("category_name",categoryService.findByid(id).getCategoryName());
		model.addAttribute("page", page);
		model.addAttribute("headTitle", "category.product.list.title");
		return "shop/product/list";
	}
	
	
	
	@RequestMapping(value={"product/detail/{id}/*"})
	public String getDetail(Model model,@PathVariable("id") String id){
		
		model.addAttribute("product", productService.findByid(id));
		model.addAttribute("related_products",productService.findByProductID(id,PRODUCT_IN_RELATED));
		model.addAttribute("headTitle", "product.detail.title");
		return "shop/product/detail";
	}
	
	
}
