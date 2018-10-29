package vivmallcn.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vivmallcn.domain.News_category;

public interface INews_categories {

	List<News_category> findAll();
	News_category save(News_category nc);
	News_category findByid(Integer id);
	void delete(Integer id);
	void active(String[] arr_id);
	void disabled(String[] arr_id);
	void delete(String[] arr_id);
	Page<News_category> findAll(Pageable pageable);
}
