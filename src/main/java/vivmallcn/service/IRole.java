package vivmallcn.service;

import java.util.List;

import vivmallcn.domain.Role;

public interface IRole {

	public List<Role> findAll();
	public Role findOne(String id);
}
