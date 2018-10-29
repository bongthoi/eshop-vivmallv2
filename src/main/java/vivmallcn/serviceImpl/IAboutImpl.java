package vivmallcn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vivmallcn.domain.About;
import vivmallcn.repository.AboutRepository;
import vivmallcn.service.IAbout;
@Service
public class IAboutImpl implements IAbout {
	
	@Autowired
	private AboutRepository aboutRepository;

	@Override
	public List<About> findAll() {
		// TODO Auto-generated method stub
		return aboutRepository.findAll();
	}

	@Override
	public void save(About about) {
		// TODO Auto-generated method stub
		aboutRepository.save(about);
	}

	@Override
	public About findOne(String id) {
		// TODO Auto-generated method stub
		return aboutRepository.findOne(id);
	}

	
}
