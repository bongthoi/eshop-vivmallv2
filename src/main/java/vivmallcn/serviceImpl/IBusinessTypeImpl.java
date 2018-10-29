package vivmallcn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vivmallcn.domain.BusinessType;
import vivmallcn.repository.BusinessTypeRepository;
import vivmallcn.service.IBusinessType;


@Service
public class IBusinessTypeImpl implements IBusinessType{
	@Autowired
	private BusinessTypeRepository businessTypeRepository;

	@Override
	public List<BusinessType> findAll() {
		// TODO Auto-generated method stub
		return businessTypeRepository.findAll();
	}
}
