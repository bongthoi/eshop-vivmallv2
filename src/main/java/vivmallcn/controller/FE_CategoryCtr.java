package vivmallcn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vivmallcn.domain.Category;
import vivmallcn.service.ICategory;
import vivmallcn.service.Iindustry;

@Controller
public class FE_CategoryCtr {
	@Value("${PRODUCT_IN_CATE}")
	private int PRODUCT_IN_CATE;
	
	@Autowired
	private ICategory categoryService;
	
	@Autowired
	private Iindustry iIndustry;
	
	@RequestMapping(value={"category/findByIndustry/{id}/*"})
	public String getList(Model model,@PathVariable("id") int id){
		
		List<Category> categories=categoryService.findAllContainProducts(id,PRODUCT_IN_CATE);
		
		model.addAttribute("categories", categories);
		model.addAttribute("industry_name",iIndustry.findByid(id).getIndustryName());
		model.addAttribute("url_breakcrum","category/findByIndustry"+id);
		
		model.addAttribute("headTitle", "category.title");
		return "shop/category/list";
	}
	
	
	
}
