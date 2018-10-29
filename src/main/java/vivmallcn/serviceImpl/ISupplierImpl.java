package vivmallcn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vivmallcn.domain.Supplier;
import vivmallcn.repository.SupplierRepository;
import vivmallcn.service.ISupplier;

@Service
public class ISupplierImpl implements ISupplier {

	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	public List<Supplier> findAll() {
		return supplierRepository.findAll();
	}

	@Override
	public boolean isExists(String id) {
		return supplierRepository.exists(id);
	}

	@Override
	public Supplier save(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	@Override
	public Supplier findByid(String id) {
		return supplierRepository.findOne(id);
	}

	@Override
	@Transactional
	public void active(String[] arr_id) {
		if (arr_id.length > 0) {
			for (int i = 0; i < arr_id.length; i++) {
				supplierRepository.active(arr_id[i]);
			}
		}
	}

	@Override
	@Transactional
	public void disabled(String[] arr_id) {
		if (arr_id.length > 0) {
			for (int i = 0; i < arr_id.length; i++) {
				supplierRepository.disabled(arr_id[i]);
			}
		}
	}

	@Override
	@Transactional
	public void delete(String[] arr_id) {
		if (arr_id.length > 0) {
			for (int i = 0; i < arr_id.length; i++) {
				supplierRepository.delete(arr_id[i]);
			}
		}
	}

	@Override
	public void delete(String id) {
		supplierRepository.delete(id);
	}
	
	@Override
	public Page<Supplier> findAll(Pageable pageable) {
		return supplierRepository.findAll(pageable);
	}

}
