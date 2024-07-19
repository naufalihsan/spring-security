package id.codecamp.security.repository;

import id.codecamp.security.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {


}
