package web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import web.entity.Person;

import java.util.List;

public interface PersonDAO{

    public List<Person> index();

    public Person show(final Long id);

    public void save(Person person);

    public void update(Person updatedPerson, Long id);

    public void delete(Long id);

    Person findPersonByEmail(String email);


}

