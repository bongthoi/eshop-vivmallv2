package vivmallcn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vivmallcn.domain.DeliveryMethod;
import vivmallcn.repository.DeliveryMethodRepository;
import vivmallcn.service.IDeliveryMethod;

@Service
public class IDeliveryMethodImpl implements IDeliveryMethod {

	@Autowired
	private DeliveryMethodRepository deliveryMethodRepository;
	@Override
	public List<DeliveryMethod> findAll() {
		// TODO Auto-generated method stub
		return deliveryMethodRepository.findAll();
	}
	@Override
	public DeliveryMethod findOne(Integer id) {
		// TODO Auto-generated method stub
		return deliveryMethodRepository.findOne(id);
	}
	@Override
	public List<DeliveryMethod> findByActive() {
		// TODO Auto-generated method stub
		return deliveryMethodRepository.findByActive();
	}
	@Override
	public void active(String[] arr_id) {
		// TODO Auto-generated method stub
		if(arr_id.length>0){
			for(int i=0;i<arr_id.length;i++){
				deliveryMethodRepository.active(Integer.parseInt(arr_id[i]));
			}
		}
	}
	@Override
	public void disabled(String[] arr_id) {
		// TODO Auto-generated method stub
		if(arr_id.length>0){
			for(int i=0;i<arr_id.length;i++){
				deliveryMethodRepository.disabled(Integer.parseInt(arr_id[i]));
			}
		}
	}
	@Override
	public void delete(String[] arr_id) {
		// TODO Auto-generated method stub
		if(arr_id.length>0){
			for(int i=0;i<arr_id.length;i++){
				deliveryMethodRepository.delete(Integer.parseInt(arr_id[i]));
			}
		}
	}
	@Override
	public void save(DeliveryMethod payment) {
		// TODO Auto-generated method stub
		deliveryMethodRepository.save(payment);
	}
	@Override
	public boolean isExists(Integer id) {
		// TODO Auto-generated method stub
		return deliveryMethodRepository.exists(id);
	}

}
