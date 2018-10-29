package vivmallcn.service;

import java.util.List;

import vivmallcn.domain.DeliveryMethod;

public interface IDeliveryMethod {
	List<DeliveryMethod> findAll();
	DeliveryMethod	findOne(Integer id);
	List<DeliveryMethod> findByActive();
	void active(String[] arr_id);
	void disabled(String[] arr_id);
	void delete(String[] arr_id);
	void save(DeliveryMethod payment);
	boolean isExists(Integer id);
}
