package vivmallcn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import vivmallcn.domain.Guide;
import vivmallcn.repository.GuideRepository;
import vivmallcn.service.IGuide;

@Service
public class IGuideImpl implements IGuide {

	@Autowired
	private GuideRepository guideRepository;

	@Override
	public List<Guide> findAll() {
		// TODO Auto-generated method stub
		return guideRepository.findAll();
	}

	@Override
	public void save(Guide guide) {
		// TODO Auto-generated method stub
		guideRepository.save(guide);
	}

	@Override
	public Guide findOne(String id) {
		// TODO Auto-generated method stub
		return guideRepository.findOne(id);
	}

}
