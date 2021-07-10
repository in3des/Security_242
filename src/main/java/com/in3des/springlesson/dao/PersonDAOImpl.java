package com.in3des.springlesson.dao;

import com.in3des.springlesson.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class PersonDAOImpl implements PersonDAO {

    @PersistenceContext // or even @Autowired
    private EntityManager em;

    @Override
    public List<Person> index() {
        return em.createQuery("SELECT person FROM Person person", Person.class).getResultList();
    }

    @Override
    public Person show(final Long id) {
        return em.find(Person.class, id);
    }

    @Override
    public void save(Person person) {
        em.persist(person);
    }

    @Override
    public void update(Person updatedPerson, Long id) {
        Person person = em.find(Person.class, id);
        person.setName(updatedPerson.getName());
        person.setSurname(updatedPerson.getSurname());
        person.setAge(updatedPerson.getAge());
        em.merge(person);
    }

    @Override
    public void delete(Long id) {
        Person person = em.find(Person.class, id);
        em.remove(person);
    }


}

