package vivmallcn.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vivmallcn.domain.User;
import vivmallcn.domain.frmChangePassword;

public interface IUser {
	List<User> findAll();
	boolean isExists(String username);
	User save(User user);
	User findOne(String username);
	User findByEmail(String username);
	void active(String[] arr_id);
	void active(String id);
	void disabled(String[] arr_id);
	void delete(String[] arr_id);
	Page<User> findAll(Pageable pageable);
	void ChangePassword(frmChangePassword frm);
	Page<User> findNewUsersByIsEnabled(int enabled,Pageable page);
	Long getNewUserSize();
}
