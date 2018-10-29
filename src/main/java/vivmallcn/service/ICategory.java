package vivmallcn.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vivmallcn.domain.Category;


public interface ICategory {
	List<Category> findAll();
	boolean isExists(Integer id);
	Category save(Category Category);
	Category findByid(Integer integer);
	void active(String[] arr_id);
	void disabled(String[] arr_id);
	void delete(String[] arr_id);
	Page<Category> findAll(Pageable pageable);
	
	List<Category> findAllContainProducts(Integer IndustryID,Integer product_limit);
	List<Category> findAllByIndustryID(Integer id);
	
}
