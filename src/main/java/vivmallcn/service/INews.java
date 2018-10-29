package vivmallcn.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vivmallcn.domain.News;

public interface INews {
	List<News> findAll();
	boolean isExists(Integer id);
	News save(News news);
	News findByid(Integer id);
	void active(String[] arr_id);
	void disabled(String[] arr_id);
	void delete(String[] arr_id);
	Page<News> findAll(Pageable pageable);
	
	Page<News> findByCateID(Pageable pageable,Integer id);
}
