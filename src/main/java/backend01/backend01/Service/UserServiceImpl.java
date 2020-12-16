package backend01.backend01.Service;

import backend01.backend01.Modal.Role;
import backend01.backend01.Modal.User;
import backend01.backend01.Repository.UserRepository;
import backend01.backend01.Web.dto.UserSignupDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

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
}
