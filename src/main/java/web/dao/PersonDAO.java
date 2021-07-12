package web.dao;

import web.entity.Person;

import java.util.List;

public interface PersonDAO {

    public List<Person> index();

    public Person show(final Long id);

    public void save(Person person);

    public void update(Person updatedPerson, Long id);

    public void delete(Long id);


}
