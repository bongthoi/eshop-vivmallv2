package vivmallcn.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vivmallcn.domain.Product;


public interface IProduct {

	List<Product> findAll();
	boolean isExists(String id);
	Product save(Product product);
	Product findByid(String id);
	void active(String[] arr_id);
	void disabled(String[] arr_id);
	void delete(String[] arr_id);
	Page<Product> findAll(Pageable pageable);
	List<Product> findByCateID(Integer id,Integer limit);
	Page<Product> findByCateID(Integer id,Pageable pageable);
	List<Product> findByProductID(String id,Integer limit);
	List<Product> findContainName(String name,Integer limit);
	Page<Product> findLikeName(String name,Pageable pageable);
	public String GenarateBarcodeWithoutCheckSum();
	
}
