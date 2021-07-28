package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.PersonDAO;
import web.entity.Person;

import java.util.List;

@Service
@Transactional
public class PeopleServiceImpl implements PeopleService {

    private final PersonDAO personDAO;

//    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public PeopleServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public List<Person> index() {
        return personDAO.index();
    }

    @Override
    public Person show(final Long id) {
        return personDAO.show(id);
    }

    @Override
    @Transactional
    public void save(Person person) {
//        person.setPassword(passwordEncoder.encode(person.getPassword()));
        personDAO.save(person);
    }

    @Override
    @Transactional
    public void update(Person updatedPerson, Long id) {
//        updatedPerson.setPassword(passwordEncoder.encode(updatedPerson.getPassword()));
        personDAO.update(updatedPerson, id);
    }


    @Transactional
    @Override
    public void delete(Long id) {
        personDAO.delete(id);
    }

    @Override
    @Transactional
    public Person findPersonByEmail(String email) {
        return personDAO.findPersonByEmail(email);
    }

    @Override
    @Transactional
    public Person findPersonByName(String name) {
        return personDAO.findPersonByName(name);
    }

}