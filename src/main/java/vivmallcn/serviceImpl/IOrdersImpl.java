package vivmallcn.serviceImpl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vivmallcn.domain.Orders;
import vivmallcn.domain.OrdersDetail;
import vivmallcn.layout.support.web.Googs;
import vivmallcn.repository.OrdersDetailRepository;
import vivmallcn.repository.OrdersRepository;
import vivmallcn.service.IDeliveryMethod;
import vivmallcn.service.IOrders;
import vivmallcn.service.IPaymentMethod;

@Service
public class IOrdersImpl implements IOrders{

	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	private OrdersDetailRepository ordersDetailRepository;
	
	@Autowired
	private	IPaymentMethod	iPaymentMethod;
	
	@Autowired
	private	IDeliveryMethod	iDeliveryMethod;
	
	@Override
	public Page<Orders> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return ordersRepository.findAll(page);
	}

	@Override
	public Orders findByid(String id) {
		if(ordersRepository.exists(id)){
			Orders orders=ordersRepository.findOne(id);
			orders.setOrdersDetails(ordersDetailRepository	
					.findWhereQuery(" WHERE 1=1 and OrdersId ='"+orders.getId()+"' "));
			return orders;
		}
		return null;
	}

	@Override
	public String GenarateId() {
		// TODO Auto-generated method stub
		return ordersRepository.GenarateId();
	}

	@Override
	@Transactional
	public Orders save(Orders orders) {
		if(orders.getOrdersDetails()!=null){
			int TotalQuantity=0;
			BigDecimal TotalAmount=new BigDecimal(0);
			for (int i=0;i<orders.getOrdersDetails().size();i++) {
				OrdersDetail detail=orders.getOrdersDetails().get(i);
				if(detail.getIsDelete()==0){//chua xoa
					BigDecimal detailAmount=new BigDecimal(detail.getQuantity() * detail.getPrice().doubleValue());
					TotalAmount = TotalAmount.add(detailAmount);//++totalamount
					TotalQuantity += detail.getQuantity();//++totalquantity
					detail.setAmount(detailAmount);
					detail.setOrdersId(orders.getId());
					//System.out.println(detail.toString());
					ordersDetailRepository.save(detail);
				}else{
					if(detail.getId()!=null){
						ordersDetailRepository.delete(detail.getId());//delete detail
					}
				}//end if isdelete
			}//end foreach
			orders.setTotalAmount(TotalAmount);
			orders.setTotalQuantity(TotalQuantity);
			return ordersRepository.save(orders);
		}//end if detail size
		return new Orders();
	}

	@Override
	public Orders findOne(String id) {
		// TODO Auto-generated method stub
		return ordersRepository.findOne(id);
	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return ordersRepository.exists(id);
	}

	@Override
	public Orders approve(String id) {
		Orders od=ordersRepository.findOne(id);
		od.setIsCheck(Googs.APPROVE);
		od = ordersRepository.save(od);
		return od;
	}

	@Override
	public Orders destroy(String id) {
		Orders od=ordersRepository.findOne(id);
		od.setIsCheck(Googs.DESTROY);
		od = ordersRepository.save(od);
		return od;
	}

	/*@Override
	public Orders findByidOnInfoPage(String id) {
		if(ordersRepository.exists(id)){
			Orders orders=ordersRepository.findByidOnInfoPage(id);
			orders.setOrdersDetails(ordersDetailRepository.findWhereQuery(" WHERE 1=1 and OrdersId ='"+orders.getId()+"' "));
			return orders;
		}
		return null;
	}*/
	
	@Override
	public Orders findByidOnInfoPage(String id) {
		if(ordersRepository.exists(id)){
			Orders orders=ordersRepository.findOne(id);
			orders.setPaymentMethod(iPaymentMethod.findByid(orders.getPaymentMethod().getId()));
			orders.setDeliveryMethod(iDeliveryMethod.findOne(orders.getDeliveryMethod().getId()));
			orders.setOrdersDetails(ordersDetailRepository.findWhereQuery(" WHERE 1=1 and OrdersId ='"+orders.getId()+"' "));
			return orders;
		}
		return null;
	}

	@Override
	public Page<Orders> findByUserID(String id, Pageable page) {
		// TODO Auto-generated method stub
		return ordersRepository.findByUserID(id, page);
	}

	@Override
	public Page<Orders> findByIsCheck(int status, Pageable page) {
		// TODO Auto-generated method stub
		return ordersRepository.findByIsCheck(status, page);
	}

	@Override
	public Long getNewOrderSize() {
		// TODO Auto-generated method stub
		return ordersRepository.getNewOrderSize();
	}

}
