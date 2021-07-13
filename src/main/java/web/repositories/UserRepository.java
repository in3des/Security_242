package web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import web.entity.Person;

@Repository
public interface UserRepository extends JpaRepository<Person, Long> {
    User findByEmail(String email);
}
