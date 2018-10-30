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
	
	@Value("${product_list_api}")
    private String product_list_api;
	
	@Value("${product_image_url}")
    private String product_image_url;
	
	@Value("${product_detail_link}")
    private String product_detail_link;
	
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
		
	    String data = restTemplate.getForObject(product_list_api, String.class);	    
	    List<Products_Seller> product_sellers = gson.fromJson(data, new TypeToken<List<Products_Seller>>(){}.getType());
		
		model.addAttribute("product_sellers",product_sellers);
		model.addAttribute("industries", industries);
		model.addAttribute("product_image_url",product_image_url);
		model.addAttribute("product_detail_link",product_detail_link);
		model.addAttribute("headTitle", "home.title");
		return "shop/home/index";
	}
	
	
}
