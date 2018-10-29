package vivmallcn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vivmallcn.domain.PaymentMethod;
import vivmallcn.repository.PaymentMethodRepository;
import vivmallcn.service.IPaymentMethod;

@Service
public class IPaymentMethodImpl implements IPaymentMethod {

	@Autowired
	private PaymentMethodRepository  paymentMethodRepository;
	@Override
	public List<PaymentMethod> findAll() {
		// TODO Auto-generated method stub
		return paymentMethodRepository.findAll();
	}
	@Override
	public PaymentMethod findByid(Integer id) {
		// TODO Auto-generated method stub
		return paymentMethodRepository.findOne(id);
	}
	@Override
	public List<PaymentMethod> findByActive() {
		// TODO Auto-generated method stub
		return paymentMethodRepository.findByActive();
	}
	@Override
	public void active(String[] arr_id) {
		// TODO Auto-generated method stub
		if(arr_id.length>0){
			for(int i=0;i<arr_id.length;i++){
				paymentMethodRepository.active(Integer.parseInt(arr_id[i]));
			}
		}
	}
	@Override
	public void disabled(String[] arr_id) {
		// TODO Auto-generated method stub
		if(arr_id.length>0){
			for(int i=0;i<arr_id.length;i++){
				paymentMethodRepository.disabled(Integer.parseInt(arr_id[i]));
			}
		}
	}
	@Override
	public void delete(String[] arr_id) {
		// TODO Auto-generated method stub
		if(arr_id.length>0){
			for(int i=0;i<arr_id.length;i++){
				paymentMethodRepository.delete(Integer.parseInt(arr_id[i]));
			}
		}
	}
	@Override
	public void save(PaymentMethod payment) {
		// TODO Auto-generated method stub
		paymentMethodRepository.save(payment);
	}
	@Override
	public boolean isExists(Integer id) {
		// TODO Auto-generated method stub
		return paymentMethodRepository.exists(id);
	}


}
