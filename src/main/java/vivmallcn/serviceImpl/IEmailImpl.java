package vivmallcn.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vivmallcn.domain.Emailfeedback;
import vivmallcn.repository.EmailRepository;
import vivmallcn.service.IEmail;


@Service
public class IEmailImpl implements IEmail  {

	@Autowired
	private EmailRepository emailRepository;
	
	@Override
	public Iterable<Emailfeedback> findAll() {
		// TODO Auto-generated method stub
		return emailRepository.findAll();
	}

	@Override
	public Emailfeedback findOne(int id) {
		// TODO Auto-generated method stub
		return emailRepository.findOne(id);
	}

	@Override
	public void save(Emailfeedback email) {
		// TODO Auto-generated method stub
		emailRepository.save(email);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		emailRepository.delete(id);
	}

	@Override
	public Page<Emailfeedback> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return emailRepository.findAll(pageable);
		}
}
