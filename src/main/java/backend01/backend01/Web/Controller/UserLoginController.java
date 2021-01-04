package backend01.backend01.Web.Controller;

import backend01.backend01.Modal.User;
import backend01.backend01.Service.UserService;
import backend01.backend01.Web.dto.UserLoginDto;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/login")
public class UserLoginController {

    @Autowired
    private UserService userService;

    public UserLoginController() {

    }

    public UserLoginController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping
    public String login() {
        return "login";
    }

    @PostMapping
    public UserDetails loginUserAccount(@RequestBody UserLoginDto loginDto) {
        return userService.loadUserByUsername(loginDto.getEmail());
    }

//
//    @PostMapping
//    public User loginUserAccount(@RequestBody UserLoginDto loginDto) throws NotFoundException {
//
//        return userService.loadUserByUsername(loginDto.getEmail(),loginDto.getPassword());
//
//    }

}