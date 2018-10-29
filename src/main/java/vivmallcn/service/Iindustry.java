package vivmallcn.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vivmallcn.domain.Industry;

public interface Iindustry {
	List<Industry> findAll();
	boolean isExists(Integer integer);
	Industry save(Industry Industry);
	Industry findByid(Integer integer);
	void active(String[] arr_id);
	void disabled(String[] arr_id);
	void delete(String[] arr_id);
	Page<Industry> findAll(Pageable pageable);
	
	List<Industry> findAllContainCategoryAndProduct(Integer product_limit);
	List<Industry> findAllContainCategory();
}
