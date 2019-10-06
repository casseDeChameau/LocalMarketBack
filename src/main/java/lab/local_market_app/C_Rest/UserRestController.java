package lab.local_market_app.C_Rest;

import lab.local_market_app.B_Services.UserService;
import lab.local_market_app._Domain.User;
import lab.local_market_app.security.JwtTokenUtil;
import lab.local_market_app.security.JwtUser;
import lab.local_market_app.security.JwtTokenUtil;
import lab.local_market_app.security.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserRestController {

    @Autowired
    private UserService userService;
    //CREATE
    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addProduct(user);
    }
/*    //UPDATE
    @PutMapping(path = "/{id}")
    @PreAuthorize("hasRole('ADMIN') " +
            "or hasRole('USER')")
    public void updateUser(@PathVariable Long id, @RequestBody User user){
        User u = userService.findById(id);
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
    }*/
    //UPDATE
    @PutMapping
    @PreAuthorize("hasRole('ADMIN') " +
                "or hasRole('USER')")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    //DELETE
    @DeleteMapping(path = "/{id}")
    @PreAuthorize("hasRole('ADMIN') " +
                "or hasRole('USER')")
    public void deleteUser(@PathVariable Long idUser){
        userService.deleteUser(idUser);
    }
    //READ ONE
    @GetMapping(path = "/{name}")
/*    @PreAuthorize("hasRole('ADMIN')")*/
    public List<User> findUserByName(@PathVariable String userName) {
        return userService.findUserByName(userName);
    }
    //READ LIST
    @GetMapping("/all")
/*    @PreAuthorize("hasRole('ADMIN')")*/
    public List<User> listUser() {
        return userService.listUser();
    }

    //----------------------------      SECURITY        -----------------------------------//

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;
    }

    //----------------------------------------------------------------------------------//

}
