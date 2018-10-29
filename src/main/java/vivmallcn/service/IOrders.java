package vivmallcn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vivmallcn.domain.Orders;

public interface IOrders {

	Page<Orders> findAll(Pageable page);

	Orders findByid(String id);

	String GenarateId();

	Orders save(Orders orders);

	Orders findOne(String id);

	boolean exists(String id);

	Orders approve(String id);

	Orders destroy(String id);
	
	Orders findByidOnInfoPage(String id);
	
	Page<Orders> findByUserID(String id,Pageable page);
	
	Page<Orders> findByIsCheck(int status,Pageable page);
	
	Long getNewOrderSize();
	
	 /*List<OrdersDetailReport> findByGoodsDeliveriedId(String id);

	OrdersReport getDeliveriedReportById(String id);*/
}
