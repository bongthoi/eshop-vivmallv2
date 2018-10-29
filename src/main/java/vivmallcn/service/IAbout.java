package vivmallcn.service;

import java.util.List;

import vivmallcn.domain.About;


public interface IAbout {
	List<About> findAll();

	void save(About about);
	About findOne(String id);
	
}
