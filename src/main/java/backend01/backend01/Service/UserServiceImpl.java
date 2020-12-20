package backend01.backend01.Service;

import backend01.backend01.Modal.Role;
import backend01.backend01.Modal.User;
import backend01.backend01.Repository.UserRepository;
import backend01.backend01.Web.dto.UserSignupDto;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserSignupDto signupDto)
    {
        User user = new User(signupDto.getFirstname(),
                signupDto.getLastname(), signupDto.getEmail(),
                signupDto.getPassword(), Arrays.asList(new Role("Admin"))
        );

        return userRepository.save(user);
    }

    @Override
    public User loadUserByUsername(String username,String password) throws NotFoundException {
        User user = userRepository.findByEmail(username);
        if(user == null){
            throw new NotFoundException("Invalid Email...do signup bro!!");
        }
//        else if(user.getPassword() != password){
//            throw new NotFoundException("Wrong password...please provide correct password");
//        }
        return new User(user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword(),null);
    }

//    @Override
//    public UserDetails loadUserByUsername(String email_id) throws UsernameNotFoundException {
//
//        User user = userRepository.findByEmail(email_id);
//        if(user == null) {
//            throw new UsernameNotFoundException("Invalid username or password...Pls sign up first");
//        }
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
//    }

//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
//        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//    }
}
