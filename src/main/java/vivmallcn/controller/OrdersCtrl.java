package vivmallcn.controller;

import java.security.Principal;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import vivmallcn.domain.Orders;
import vivmallcn.domain.Product;
import vivmallcn.layout.support.web.MessageHelper;
import vivmallcn.layout.support.web.PageWrapper;
import vivmallcn.service.IDeliveryMethod;
import vivmallcn.service.IOrders;
import vivmallcn.service.IPaymentMethod;
import vivmallcn.service.IProduct;

@Controller
public class  OrdersCtrl {
	@Autowired
	private IOrders ordersService;
	
	@Autowired
	private IProduct productService;
	
	@Autowired
	private IDeliveryMethod deliveryMethodService;
	
	@Autowired
	private IPaymentMethod paymentMethodService;

	private void AddAtributeIntoForm(Model model){
		model.addAttribute("deliveryMethods", deliveryMethodService.findAll());
		model.addAttribute("paymentMethods", paymentMethodService.findAll());
	}
	@RequestMapping(value={"admin/orders"})
	public String index(Model model,@RequestParam(value="page",required=false,defaultValue="1") int p){
		if(p==0){
			p=1;
		}
		UriComponentsBuilder  uri=UriComponentsBuilder.fromPath("admin/orders");
		PageRequest pageRequest=new  PageRequest(p-1, PageWrapper.MAX_PAGE_ITEM_DISPLAY, Direction.DESC,"CreateDate");
		Page<Orders> s=ordersService.findAll(pageRequest);
		PageWrapper< Orders> page = new PageWrapper<Orders>(s, uri.build().toString());
		model.addAttribute("headTitle", "Orders  ");
		model.addAttribute("orderses", page.getContent());
		 model.addAttribute("page", page);
		return "admin/orders/list";
	}
	
	@RequestMapping(value={"admin/neworders"})
	public String getNewOrders(Model model,@RequestParam(value="page",required=false,defaultValue="1") int p){
		if(p==0){
			p=1;
		}
		UriComponentsBuilder  uri=UriComponentsBuilder.fromPath("admin/neworders");
		PageRequest pageRequest=new  PageRequest(p-1, PageWrapper.MAX_PAGE_ITEM_DISPLAY, Direction.DESC,"CreateDate");
		Page<Orders> s=ordersService.findByIsCheck(0,pageRequest);
		PageWrapper< Orders> page = new PageWrapper<Orders>(s, uri.build().toString());
		model.addAttribute("headTitle", "Orders  ");
		model.addAttribute("orderses", page.getContent());
		 model.addAttribute("page", page);
		return "admin/orders/list";
	}
	@GetMapping("admin/orders/add")
	public String add(Model model,boolean isBidingResult){
		model.addAttribute("headTitle", "Orders Add new Item");
		model.addAttribute("h1", "Add item");
		this.AddAtributeIntoForm(model);
		if(!isBidingResult){
			model.addAttribute("orders", new  Orders());
		}
		return "admin/orders/form";
	}
	
	@GetMapping("admin/orders/edit/{id}")
	public String edit(Model model,boolean isBidingResult,@PathVariable(value="id") String id){
		model.addAttribute("headTitle","Orders Edit Item");
		model.addAttribute("h1", "Edit item");
		this.AddAtributeIntoForm(model);
		if(!isBidingResult){
			model.addAttribute("orders",ordersService.findByid(id));
		}
		return "admin/orders/form";
	}
	
	@GetMapping("admin/orders/info/{id}")
	public String info(Model model,boolean isBidingResult,@PathVariable(value="id") String id){
		model.addAttribute("headTitle", "Orders Info Item");
		model.addAttribute("h1", "Info item");
		//this.AddAtributeIntoForm(model);
		model.addAttribute("orders",ordersService.findByidOnInfoPage(id));
		return "admin/orders/info";
	}
	
	@GetMapping("admin/orders/getTrDetail")
	public String getTrDetail(Model model,@RequestParam(value="productid") String productid){
		Product product=productService.findByid(productid);
		model.addAttribute("product", product);
		return "admin/orders/tableDetail :: trDetail";
		
	}
	
	@PostMapping("admin/orders/approve")
	public String approve(Model model,Principal session, RedirectAttributes ra,@RequestParam(value="id") String id){
	
		
		/*step 1 check exits ID*/
		if(!ordersService.exists(id)){
			  MessageHelper.addErrorAttribute(ra, "orders.NotFound");
			  return "redirect:/admin/orders";
		}

		/*step 3  Approve this*/
		else{
			try{
				ordersService.approve(id);
				MessageHelper.addSuccessAttribute(ra, "processing.success");
				
				
			 }catch(Exception ex){
				 	MessageHelper.addErrorAttribute(ra, "processing.error"); 
				 	throw(ex);
			  }
		}

		return "redirect:/admin/orders/info/"+id;
		
	}
	@PostMapping("admin/orders/destroy")
	public String destroy(Model model,Principal session, RedirectAttributes ra,@RequestParam(value="id") String id){
		/*step 1 check exits ID*/
		if(!ordersService.exists(id)){
			  MessageHelper.addErrorAttribute(ra, "orders.NotFound");
			  return "redirect:/admin/orders";
		}
		
		/*step 3  Approve this*/
		else{
			try{
				 ordersService.destroy(id);
				 MessageHelper.addSuccessAttribute(ra, "processing.success");
			 }catch(Exception ex){
				 	MessageHelper.addErrorAttribute(ra, "processing.error"); 
				 	throw(ex);
			  }
		}

		//model.addAttribute("goodsReceiptNote",goodsReceiptNote);
		return "redirect:/admin/orders/info/"+id;
		
	}
	
	@PostMapping("admin/orders/save")
	public String Save(@Valid @ModelAttribute  Orders orders,BindingResult result, RedirectAttributes ra,Principal session,Model model){
		if(orders.getOrdersDetails()==null){
			  result.reject("global.error.ordersDetails.null", "Detail info is empty!");
		  }
		  if(orders.isNew()){
			  if (result.hasErrors()) {
			  	  return add(model,true);
			  	}
			  
		  }else{
			  if (result.hasErrors()) {
			  	  return edit(model,true,orders.getId());
			  	}
		  }
		  try{
			 
			  if(orders.isNew()){//set defaul value when insert
				  orders.setCreateDate(new Date());
				  orders.setId(ordersService.GenarateId());
				  orders.setIsCheck(0);
			  }else{//set value when update object
				   Orders  ordersPersited= ordersService.findOne(orders.getId());
				  orders.setCreateDate(ordersPersited.getCreateDate());
				  orders.setId(ordersPersited.getId());
				  orders.setIsCheck(ordersPersited.getIsCheck());
				 
			  }
			  ordersService.save(orders);
			  MessageHelper.addSuccessAttribute(ra, "save.success");
		  }catch(Exception ex){
			  MessageHelper.addErrorAttribute(ra, "save.fail");
	  		throw(ex);
		  }
		  return "redirect:/admin/orders";
		
	}
	
	/*
	@RequestMapping(value = "admin/orders/export", method = RequestMethod.POST)
	@ResponseBody
	public void generateResultsPdf(@RequestParam(value="id") String id, HttpServletResponse response) throws IOException {
		
		OrdersReport ordersReport=ordersService.getDeliveriedReportById(id);
		List<OrdersDetailReport> DeliveriedDetailReports=ordersService.findByGoodsDeliveriedId(id);
	    JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(DeliveriedDetailReports);
	    Map<String, Object> parameterMap = new HashMap<>();
	    //parameterMap.put("title", "Results table"));
	    parameterMap.put("ListDeliveriedDetails", itemsJRBean);
	    parameterMap.put("goodsDeliveried",ordersReport);

	    try {
	    	    InputStream is = getClass().getResourceAsStream("/jasper/PXuatkho.jrxml");
	    	   JasperReport report = JasperCompileManager.compileReport(is);
	            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameterMap, new JREmptyDataSource());
	            String filename = "Phieuxuat.pdf";

	            response.setContentType("application/pdf");
	            response.addHeader("Content-disposition", "attachment; filename=" +filename);
	            response.setCharacterEncoding("UTF-8");
	            OutputStream outputStream = response.getOutputStream();
	    
	            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	        } catch (JRException | IOException e) {
	        	PrintWriter out=response.getWriter();
	        	out.println(e);
	            System.out.println("Error in generating pdf : {}");
	        }
	}
*/
}
