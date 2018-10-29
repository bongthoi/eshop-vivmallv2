package vivmallcn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vivmallcn.domain.Contact;

public interface IContact {

	Page<Contact> findAll(Pageable pageable);
    Iterable<Contact> findAll();

    Contact findOne(int id);

    void save(Contact contact);

    void delete(int id);
    boolean exists(int id);
    Page<Contact>	findByStatus(int status, Pageable pageable);
    Long getNewOrderSize();
}
