package vivmallcn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vivmallcn.domain.Role;
import vivmallcn.repository.RoleRepository;
import vivmallcn.service.IRole;

@Service
public class IRoleImpl implements IRole {
	 @Autowired
	    private RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public Role findOne(String id) {
		// TODO Auto-generated method stub
		return roleRepository.findOne(id);
	}

}
