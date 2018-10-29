package vivmallcn.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vivmallcn.domain.Slide;
import vivmallcn.repository.SlideRepository;
import vivmallcn.service.ISlide;

@Service
public class ISlideImpl implements ISlide {

	@Autowired
	private SlideRepository slideRepository;

	@Override
	public Iterable<Slide> findAll() {
		return slideRepository.findAll();
	}

	@Override
	public Slide findOne(int id) {
		return slideRepository.findOne(id);
	}

	@Override
	public void save(Slide slide) {
		slideRepository.save(slide);
	}

	@Override
	public void delete(int id) {
		slideRepository.delete(id);
	}

}
