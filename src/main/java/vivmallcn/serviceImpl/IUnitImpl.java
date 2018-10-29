package vivmallcn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vivmallcn.domain.Unit;
import vivmallcn.repository.UnitRepository;
import vivmallcn.service.IUnit;

@Service
public class IUnitImpl implements IUnit {
	
	@Autowired
	private UnitRepository unitRepository;
	@Override
	public List<Unit> findAll() {
		// TODO Auto-generated method stub
		return unitRepository.findAll();
	}

}
