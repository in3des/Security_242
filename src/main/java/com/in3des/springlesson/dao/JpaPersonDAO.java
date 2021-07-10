//package com.in3des.springlesson.dao;
//
//import com.in3des.springlesson.entity.Person;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//
//
////@Component
//@Service
////@Transactional(readOnly = true)
//public class JpaPersonDAO implements PersonDAO {
//
//    @PersistenceContext
//    private EntityManager em;
//
//    @Override
////    @Transactional(readOnly = true)
//    public List<Person> index() {
//        return em.createQuery("SELECT person FROM Person person", Person.class).getResultList();
//    }
//
//    @Override
////    @Transactional(readOnly = true)
//    public Person show(final Long id) {
//        return em.find(Person.class, id);
//    }
//
//    @Override
//    @Transactional
//    public void save(Person person) {
//        em.persist(person);
//    }
//
//    @Override
//    @Transactional
//    public void update(Person updatedPerson, Long id) {
//        em.merge(updatedPerson);
//    }
//
//    @Override
//    @Transactional
//    public void delete(Long id) {
//        Person person = em.find(Person.class, id);
//        em.remove(person);
//    }
//
//
//}
//
