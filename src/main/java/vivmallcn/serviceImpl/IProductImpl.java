package vivmallcn.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vivmallcn.domain.Product;
import vivmallcn.repository.ProductRepository;
import vivmallcn.service.IProduct;

@Service
public class IProductImpl implements IProduct {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public boolean isExists(String id) {
		// TODO Auto-generated method stub
		return productRepository.exists(id);
	}

	@Override
	public Product save(Product Product) {
		// TODO Auto-generated method stub
		return productRepository.save(Product);
	}

	@Override
	public Product findByid(String id) {
		// TODO Auto-generated method stub
		return productRepository.findOne(id);
	}

	@Override
	@Transactional
	public void active(String[] arr_id) {
		// TODO Auto-generated method stub
				if(arr_id.length>0){
					for(int i=0;i<arr_id.length;i++){
						productRepository.active(arr_id[i]);
					}
				}
		
	}

	@Override
	@Transactional
	public void disabled(String[] arr_id) {
		// TODO Auto-generated method stub
				if(arr_id.length>0){
					for(int i=0;i<arr_id.length;i++){
						productRepository.disabled(arr_id[i]);
					}
				}
		
	}

	@Override
	@Transactional
	public void delete(String[] arr_id) {
		// TODO Auto-generated method stub
				if(arr_id.length>0){
					for(int i=0;i<arr_id.length;i++){
						productRepository.delete(arr_id[i]);
					}
				}
		
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return productRepository.findAll(pageable);
	}

	@Override
	public String GenarateBarcodeWithoutCheckSum() {
		// TODO Auto-generated method stub
		return productRepository.GenarateBarcodeWithoutCheckSum();
	}

	@Override
	public List<Product> findByCateID(Integer id,Integer limit) {
		// TODO Auto-generated method stub
		return productRepository.findByCateID(id,limit);
	}

	@Override
	public Page<Product> findByCateID(Integer id,Pageable pageable) {
		// TODO Auto-generated method stub
		return productRepository.findByCateID(id,pageable);
	}

	

	@Override
	public List<Product> findByProductID(String id, Integer limit) {
		// TODO Auto-generated method stub
		return productRepository.findByProductID(id, limit);
	}

	@Override
	public List<Product> findContainName(String name, Integer limit) {
		// TODO Auto-generated method stub
		return productRepository.findContainName(name, limit);
	}

	@Override
	public Page<Product> findLikeName(String name,Pageable pageable) {
		// TODO Auto-generated method stub
		return productRepository.findLikeName(name,pageable);
	}

	


}
