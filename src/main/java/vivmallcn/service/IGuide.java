package vivmallcn.service;

import java.util.List;

import vivmallcn.domain.Guide;

public interface IGuide {

	List<Guide> findAll();

	void save(Guide guide);
	Guide findOne(String id);
}
