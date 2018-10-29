package vivmallcn.service;

import java.util.List;

import vivmallcn.domain.PaymentMethod;

public interface IPaymentMethod {
	
	List<PaymentMethod> findAll();
	PaymentMethod	findByid(Integer id);
	List<PaymentMethod> findByActive();
	void active(String[] arr_id);
	void disabled(String[] arr_id);
	void delete(String[] arr_id);
	void save(PaymentMethod industry);
	boolean isExists(Integer id);
}
