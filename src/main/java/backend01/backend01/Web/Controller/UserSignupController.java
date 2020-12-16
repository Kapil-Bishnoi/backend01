package backend01.backend01.Web.Controller;

import backend01.backend01.Modal.User;
import backend01.backend01.Service.UserService;
import backend01.backend01.Web.dto.UserSignupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/signup")
public class UserSignupController {

    @Autowired
    private UserService userService;

    public UserSignupController() {

    }

    public UserSignupController(UserService userService) {
        super();
        this.userService = userService;
    }

//    @ModelAttribute("user")
//    public UserSignupDto signupDto() {
//        return new UserSignupDto();
//    }

    @PostMapping()
    public User registerUserAccount(@RequestBody  UserSignupDto signupDto) { // handler function to handle post http signup request
        return userService.save(signupDto);
//        return "redirect:/signup?success" ;
    }
}
