package vivmallcn.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import vivmallcn.domain.Product;
import vivmallcn.domain.ViewGridProduct;
import vivmallcn.layout.support.web.AjaxUtils;
import vivmallcn.layout.support.web.EAN13Helper;
import vivmallcn.layout.support.web.MessageHelper;
import vivmallcn.layout.support.web.PageWrapper;
import vivmallcn.layout.support.web.SeoUtils;
import vivmallcn.layout.support.web.URLUtils;
import vivmallcn.service.IBigUnit;
import vivmallcn.service.IBusinessType;
import vivmallcn.service.ICategory;
import vivmallcn.service.IProduct;
import vivmallcn.service.ISupplier;
import vivmallcn.service.IUnit;
import vivmallcn.service.IViewGridProduct;

@Controller
public class ProductController {
	@Autowired
	private ApplicationContext appContext;
	@Autowired
	private IProduct productService;
	
	@Autowired
	private IViewGridProduct biewGridProductService; 
	
	@Autowired
	private IBigUnit bigUnitService;
	
	@Autowired
	private IBusinessType businessTypeService;
	
	@Autowired
	private ICategory categoryService;
	
	@Autowired
	private ISupplier supplierService;
	
	@Autowired
	private IUnit unitService;
	
	@Autowired
	private	URLUtils	URLUtils;
	
	@RequestMapping(value={"admin/product"})
	public String index(Model model,
				@RequestHeader(value = "X-Requested-With", required = false) String requestedWith,
				@ModelAttribute("viewGridProduct")ViewGridProduct viewGridProduct,
				@RequestParam(value="page",required=false,defaultValue="1") int p){
		if(p==0){
			p=1;
		}
		UriComponentsBuilder  uri=UriComponentsBuilder.fromPath("admin/product")
												.queryParam("ProductName", viewGridProduct.getProductName())
												.queryParam("CategoryId", viewGridProduct.getCategoryId())
												.queryParam("SupplierId", viewGridProduct.getSupplierId());
		
		
		boolean isAjaxRequest=AjaxUtils.isAjaxRequest(requestedWith);

		PageRequest pageRequest=new  PageRequest(p-1, PageWrapper.MAX_PAGE_ITEM_DISPLAY, Direction.DESC,"id");
		Page<ViewGridProduct> s=biewGridProductService.findByObjectAttribute(viewGridProduct, pageRequest);
		PageWrapper<ViewGridProduct> page = new PageWrapper<ViewGridProduct>(s, uri.build().toString());
		model.addAttribute("categorys", categoryService.findAll());
		model.addAttribute("suppliers", supplierService.findAll());
		model.addAttribute("headTitle", "Product");
		model.addAttribute("gridproducts", page.getContent());
		model.addAttribute("page", page);
		model.addAttribute("isAjaxRequest", isAjaxRequest);
		if (isAjaxRequest) {
			return ("admin/product/list :: boxGridProduct");
		}
		
		return "admin/product/list";
	}
	
	private void AddAtributeIntoForm(Model model){
		model.addAttribute("bigunits", bigUnitService.findAll());
		model.addAttribute("businesstypes", businessTypeService.findAll());
		model.addAttribute("categorys", categoryService.findAll());
		model.addAttribute("suppliers", supplierService.findAll());
		model.addAttribute("units", unitService.findAll());
		
	}
	
	@GetMapping("admin/product/add")
	public String add(Model model,boolean isBidingResult){
		model.addAttribute("headTitle", "Product Add new Item");
		model.addAttribute("h1", "Add item");
		this.AddAtributeIntoForm(model);
		if(!isBidingResult){
			model.addAttribute("product", new Product());

		}
		return "admin/product/form";
	}
	
	@GetMapping("admin/product/edit/{id}")
	public String edit(Model model,boolean isBidingResult,@PathVariable(value="id") String id){
		model.addAttribute("headTitle", "Product Edit Item");
		model.addAttribute("h1", "Edit item");
		this.AddAtributeIntoForm(model);
		if(!isBidingResult){
			model.addAttribute("product",productService.findByid(id));
		}
		return "admin/product/form";
	}
	
	@PostMapping("admin/product/save")
	public String Save(@Valid Product product,BindingResult result, RedirectAttributes ra,Locale locale,Principal productsession,Model model){
	
		  if(product.isNew()){
			  if (result.hasErrors()) {
			  	  return add(model,true);
			  	}
			  if(productService.isExists(product.getId())){
				  result.reject("global.error.product.id.exists", "#id is exists!");
				  //System.out.println("#!3");
				  return add(model,true);
			  }
			  //System.out.println("!@3");
		  }else{
			  if (result.hasErrors()) {
			  	  return edit(model,true,product.getId());
			  	}
		  }
		  try{
			 
			  if(product.isNew()){//set defaul value when insert
				  product.setCreateDate(new Date());
				  product.setUpdateDate(new Date());
				  product.setCreateUser(productsession.getName());
				  product.setUpdateUser(productsession.getName());
			  }else{//set value when update object
			
				  product.setUpdateDate(new Date());
				  product.setUpdateUser(productsession.getName());
				  
				  Product productpersit=productService.findByid(product.getId());
				  product.setCreateDate(productpersit.getCreateDate());
				  product.setCreateUser(productpersit.getCreateUser());
				 
			  }
			  productService.save(product);
			  MessageHelper.addSuccessAttribute(ra, "save.success");
		  }catch(Exception ex){
			  MessageHelper.addErrorAttribute(ra, "save.fail");
	  		throw(ex);
		  }
		  return "redirect:/admin/product";
		
	}

	@PostMapping(value="admin/product/active")
	public String active(@RequestParam(value="arr_id") String[] arr_id,RedirectAttributes ra){
		try{
			  	
			productService.active(arr_id);
	    	    MessageHelper.addSuccessAttribute(ra, "active.success");
	    	  
  	   }catch(Exception ex){
  		   
  		    MessageHelper.addErrorAttribute(ra, "active.fail");
  			throw(ex);
	    	   
  	   }
		 return "redirect:/admin/product";
	}
	@PostMapping(value="admin/product/disabled")
	public String disabled(@RequestParam(value="arr_id") String[] arr_id,RedirectAttributes ra){
		try{
			  	
			  productService.disabled(arr_id);
	    	    MessageHelper.addSuccessAttribute(ra, "disabled.success");
	    	  
  	   }catch(Exception ex){
  		   
  		    MessageHelper.addErrorAttribute(ra, "disabled.fail");
  			throw(ex);
	    	   
  	   }
		 return "redirect:/admin/product";
	}
	
	@PostMapping(value="admin/product/delete")
	public String delete(@RequestParam(value="arr_id") String[] arr_id,RedirectAttributes ra){
		try{
			  	
			productService.delete(arr_id);
	    	    MessageHelper.addSuccessAttribute(ra, "delete.success");
	    	  
  	   }catch(Exception ex){
  		   
  		    MessageHelper.addErrorAttribute(ra, "delete.fail");
  			throw(ex);
  	   }
		 return "redirect:/admin/product";
	}
	@GetMapping(value="admin/product/get/barcode")
	@ResponseBody
	public String getbarcode(){
		String EAN13="";
		try{
			String BarCodeWithoutChecksum=productService.GenarateBarcodeWithoutCheckSum();
			if(!BarCodeWithoutChecksum.isEmpty()){
				EAN13=EAN13Helper.calculateCodeWithcheckSum(BarCodeWithoutChecksum);
			}
			
  	   }catch(Exception ex){
  		   throw(ex);
  	   }
		 return EAN13;
	}
	/*@GetMapping("admin/product/QRandBarCode13/{id}")
	public ModelAndView PrintQRandBarCode13(@PathVariable(value="id") String id){
		  JasperReportsPdfView view = new JasperReportsPdfView();
	       // view.setHeaders((Properties) new Properties().setProperty("Content-Disposition", "attachment; Industry.pdf") );
	        view.setUrl("classpath:jasper/qrproduct.jrxml");
	        view.setApplicationContext(appContext);
	        view.set
	        
	      //  view.setReportDataKey("UserReport");
	        
	   	 /* Convert List to JRBeanCollectionDataSource 
	       // JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(productService.findByid(id));
	        //System.out.println(productService.findByid(id).toString());
	        test t=new test();
	        t.setProductName("asdkjaskldj1234");
	        Map<String, Object> params = new HashMap<>();
	        params.put("productDatasource",t);
	       // ModelAndView mav=	new ModelAndView(view, params);
	        return new ModelAndView(view, params);
	}*/
	
	@GetMapping("admin/product/QRandBarCode13/{id}")
	@ResponseBody
	public void PrintQRandBarCode13(@PathVariable(value="id") String id,HttpServletResponse response,HttpServletRequest request) {

	    //JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(industryService.findAll());
		Product p=productService.findByid(id);
		String fullUrlQRcode=URLUtils.getDomainName().concat("/product/detail/").concat(p.getId()).concat("/"+SeoUtils.getSeoUrl(p.getProductName()));
		//String fullUrlQRcode=URLUtils.getURLBase(request).concat("/product/detail/").concat(p.getId()).concat("/"+SeoUtils.getSeoUrl(p.getProductName()));
		Map<String, Object> parameterMap = new HashMap<>();
	    //parameterMap.put("title", "Results table"));
	    parameterMap.put("productDatasource",p);
	    parameterMap.put("QrUrldatasource",fullUrlQRcode);
	    
	    try {
	    	    InputStream is = getClass().getResourceAsStream("/jasper/qrproduct.jrxml");
	    		JasperReport report = JasperCompileManager.compileReport(is);
	            JasperPrint jasperPrint = JasperFillManager.fillReport( report, parameterMap, new JREmptyDataSource());         
	            String filename = "new-qrproduct.pdf";
	            response.setContentType("application/pdf");
	            response.addHeader("Content-disposition", "attachment; filename=" +filename);
	            OutputStream outputStream = response.getOutputStream();
	     
	            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	        } catch (JRException | IOException e) {
	            System.out.println("Error in generating pdf : {}");
	        }
	}
	
	
}
