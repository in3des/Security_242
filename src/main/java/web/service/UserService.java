//package web.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import web.entity.Person;
//import web.entity.Role;
//import web.repositories.UserRepository;
//
//import java.util.Collection;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Service
//public class UserService implements UserDetailsService {
//    private UserRepository userRepository;
//
//    @Autowired
//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public Person findByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Person person = findByEmail(email);
//        if (person == null) {
//            throw new UsernameNotFoundException(String.format("User 's%' not found", email));
//        }
//        return new User(person.getEmail(), person.getPassword(), mapRolesToAuthority(person.getRoles()));
//    }
//
//    private Collection<? extends GrantedAuthority> mapRolesToAuthority(Set<Role> roles) {
//        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getRole())).collect(Collectors.toList());
//    }
//}
