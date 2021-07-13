package web.model;

//import java.util.Set;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public enum Role {
////    Java 9
////    USER(Set.of(Permission.PEOPLE_READ)),
////    ADMIN(Set.of(Permission.PEOPLE_WRITE, Permission.PEOPLE_READ));
//
//    USER(Stream.of(Permission.PEOPLE_READ).collect(Collectors.toSet())),
//    ADMIN(Stream.of(Permission.PEOPLE_READ, Permission.PEOPLE_WRITE).collect(Collectors.toSet()));
//
//    final private Set<Permission> permissionSet;
//
//    Role(Set<Permission> permissionSet) {
//        this.permissionSet = permissionSet;
//    }
//
//    public Set<Permission> getPermissionSet() {
//        return permissionSet;
//    }
//}

import web.entity.Person;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role")
    private String role;

//    @ManyToMany(mappedBy = "roles")
//    private Set<Person> people;

    public Role() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public Set<Person> getPeople() {
//        return people;
//    }
//
//    public void setPeople(Set<Person> people) {
//        this.people = people;
//    }
//
//    @Override
//    public String toString() {
//        return "Role{" +
//                "id=" + id +
//                ", role='" + role + '\'' +
//                ", people=" + people +
//                '}';
//    }
}
