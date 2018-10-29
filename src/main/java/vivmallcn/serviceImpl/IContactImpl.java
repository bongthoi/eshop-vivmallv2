package vivmallcn.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vivmallcn.domain.Contact;
import vivmallcn.repository.ContactRepository;
import vivmallcn.service.IContact;

@Service
public class IContactImpl  implements IContact{
	
	@Autowired
	private ContactRepository contactRepository;
	  @Override
	    public Iterable<Contact> findAll() {
	        return contactRepository.findAll();
	    }
	    @Override
	    public Contact findOne(int id) {
	        return contactRepository.findOne(id);
	    }

	    @Override
	    public void save(Contact contact) {
	        contactRepository.save(contact);
	    }

	    @Override
	    public void delete(int id) {
	        contactRepository.delete(id);
	    }

		@Override
		public Page<Contact> findAll(Pageable pageable) {
			// TODO Auto-generated method stub
			 return contactRepository.findAll(pageable);
		}
		@Override
		public boolean exists(int id) {
			// TODO Auto-generated method stub
			return contactRepository.exists(id);
		}
		@Override
		public Long getNewOrderSize() {
			// TODO Auto-generated method stub
			return contactRepository.getNewContactSize();
		}
		@Override
		public Page<Contact> findByStatus(int status,Pageable pageable) {
			// TODO Auto-generated method stub
			return contactRepository.findByStatus(status,pageable);
		}
}
