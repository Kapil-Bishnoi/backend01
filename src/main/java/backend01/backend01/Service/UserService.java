package backend01.backend01.Service;

import backend01.backend01.Modal.User;
import backend01.backend01.Web.dto.UserSignupDto;

public interface UserService {
    User save(UserSignupDto signupDto);
}
