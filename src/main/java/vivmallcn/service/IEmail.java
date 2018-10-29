package vivmallcn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vivmallcn.domain.Emailfeedback;
public interface IEmail {
	
	Page<Emailfeedback> findAll(Pageable pageable);
	Iterable<Emailfeedback> findAll();

	Emailfeedback findOne(int id);

    void save(Emailfeedback email);

    void delete(int id);
	
}
