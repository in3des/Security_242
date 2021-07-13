package web.entity;

import web.model.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotEmpty(message = "Name field should not be blank")
    @Size(min = 2, max = 30, message = "Please correct name size")
    private String name;

    @Column(name = "surname", nullable = false)
    @NotEmpty(message = "Surname field should not be blank")
    @Size(min = 2, max = 30, message = "Please correct surname size")
    private String surname;

    @Column(name = "age")
    @Min(value = 0, message = "Age should be a positive value")
    private int age;

    @Column(name = "email", nullable = false)
    @NotEmpty(message = "Email field should not be blank")
    @Email
//    @Size(min = 2, max = 30, message = "Please correct email size")
    private String email;

//    @Enumerated(value = EnumType.STRING)
//    @Column(name = "role", nullable = false)
////    @NotEmpty(message = "Role field should not be blank")
//    private Role role;

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Person() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
