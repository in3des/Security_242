package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.dao.PersonDAO;
import web.entity.Person;
//import web.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

//    @Autowired
//    private UserRepository userRepository;
    @Autowired
    private PersonDAO personDAO;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Person person = userRepository.findPersonByEmail(email);
        Person person = personDAO.findPersonByEmail(email);
        if (person == null) {
            throw new UsernameNotFoundException(String.format("User 's%' not found", email));
        }
        return person;
    }
}
