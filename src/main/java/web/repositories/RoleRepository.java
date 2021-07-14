package web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
