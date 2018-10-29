package vivmallcn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import vivmallcn.domain.News;
import vivmallcn.layout.support.web.PageWrapper;
import vivmallcn.service.INews;
import vivmallcn.service.INews_categories;

@Controller
public class FE_NewsCtrl {

	@Autowired
	INews	iNews;
	
	@Autowired
	INews_categories	iNews_categories;
	
	@RequestMapping(value = { "news" }, method = RequestMethod.GET)
	public String News(Model model,@RequestParam(value="page",required=false,defaultValue="1") int p) {
		if(p==0){
			p=1;
		}
		UriComponentsBuilder  uri=UriComponentsBuilder.fromPath("news");
		PageRequest pageRequest=new  PageRequest(p-1, PageWrapper.MAX_PAGE_ITEM_DISPLAY, Direction.ASC,"id");
		Page<News> s=iNews.findAll(pageRequest);
		PageWrapper<News> page = new PageWrapper<News>(s, uri.build().toString());
		
		model.addAttribute("newslist", page.getContent());
		model.addAttribute("page", page);
		model.addAttribute("newscategories",iNews_categories.findAll());
		
		
		model.addAttribute("headTitle", "news.title");
		return "shop/news/list";
	}
	
	@RequestMapping(value = { "newsbycateid/{id}/*" }, method = RequestMethod.GET)
	public String getNewsbyCategory(Model model,@PathVariable("id") Integer id,@RequestParam(value="page",required=false,defaultValue="1") int p) {
		if(p==0){
			p=1;
		}
		UriComponentsBuilder  uri=UriComponentsBuilder.fromPath("newsbycateid/"+id+"/"+iNews_categories.findByid(id).getName());
		PageRequest pageRequest=new  PageRequest(p-1, PageWrapper.MAX_PAGE_ITEM_DISPLAY, Direction.ASC,"id");
		Page<News> s=iNews.findByCateID(pageRequest, id);
		PageWrapper<News> page = new PageWrapper<News>(s, uri.build().toString());
		
		model.addAttribute("newslist", page.getContent());
		model.addAttribute("page", page);
		model.addAttribute("newscategories",iNews_categories.findAll());
		
		model.addAttribute("active", id);
		model.addAttribute("headTitle", "news.title");
		return "shop/news/list";
	}
	
	@RequestMapping(value={"news/detail/{id}/*"})
	public String getDetail(Model model,@PathVariable("id") Integer id){
		
		model.addAttribute("news", iNews.findByid(id));
		model.addAttribute("newscategories",iNews_categories.findAll());
		
		model.addAttribute("active", iNews.findByid(id).getCategory_id());
		model.addAttribute("headTitle", "news.title");
		return "shop/news/newsdetail";
	}

}
