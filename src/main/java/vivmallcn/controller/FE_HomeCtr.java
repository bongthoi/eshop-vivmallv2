package vivmallcn.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import vivmallcn.domain.Industry;
import vivmallcn.domain.Products_Seller;
import vivmallcn.service.ICategory;
import vivmallcn.service.IProduct;
import vivmallcn.service.Iindustry;

@Controller
public class FE_HomeCtr {
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${product_seller_url}")
    private String product_seller_url;
	
	@Value("${image_seller_url}")
    private String image_seller_url;
	
	@Value("${link_seller_url}")
    private String link_seller_url;
	
	@Value("${PRODUCT_IN_INDUSTRY}")
	private int PRODUCT_IN_INDUSTRY;
	
	@Autowired
	private ICategory categoryService;
	
	@Autowired
	private IProduct productService;
	
	@Autowired
	private Iindustry idustryService;
	
	
	
	@RequestMapping(value={"/","home","home/"})
	public String index(Model model)
	{
		List<Industry> industries=idustryService.findAllContainCategoryAndProduct(PRODUCT_IN_INDUSTRY);		
		Gson gson = new Gson();
		RestTemplate restTemplate = new RestTemplate();
		
	    String data = restTemplate.getForObject(product_seller_url, String.class);	    
	    List<Products_Seller> product_sellers = gson.fromJson(data, new TypeToken<List<Products_Seller>>(){}.getType());
		
		model.addAttribute("product_sellers",product_sellers);
		model.addAttribute("industries", industries);
		model.addAttribute("image_seller_url",image_seller_url);
		model.addAttribute("link_seller_url",link_seller_url);
		model.addAttribute("headTitle", "home.title");
		return "shop/home/index";
	}
	
	
}
