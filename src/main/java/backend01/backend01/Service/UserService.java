package backend01.backend01.Service;

//import org.springframework.security.core.userdetails.UserDetailsService;
import backend01.backend01.Modal.User;
import backend01.backend01.Web.dto.UserSignupDto;
import javassist.NotFoundException;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserSignupDto signupDto);

//    User loadUserByUsername(String username,String password) throws NotFoundException;
}
