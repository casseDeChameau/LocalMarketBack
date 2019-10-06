package lab.local_market_app.security.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;

import lab.local_market_app.A_Repository.IUserRepository;
import lab.local_market_app._Domain.User;
import lab.local_market_app.security.domain.Authority;
import lab.local_market_app.security.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import lab.local_market_app.security.JwtAuthenticationRequest;
import lab.local_market_app.security.JwtTokenUtil;
import lab.local_market_app.security.JwtUser;
import lab.local_market_app.security.service.JwtAuthenticationResponse;

@RestController
@CrossOrigin(origins = "*")
public class AuthenticationRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST) //     ("/auth")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        // Reload password post-security so we can generate the token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));

    }

    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET) //   ("/refresh")
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        final String token = authToken.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping(value = "/register")
    @Transactional
    public void registerUser(@RequestBody JwtAuthenticationRequest user){
        Authority roleUser = authorityRepository.findById(1L).orElse(null);
        List<Authority> authorities = new ArrayList<>();
        authorities.add(roleUser);
        User nouveau = new User(user.getUsername(),  new BCryptPasswordEncoder().encode(user.getPassword()));
        nouveau.setAuthorities(authorities);
        List<User>listUser = roleUser.getUsers();
        listUser.add(nouveau);
        roleUser.setUsers(listUser);
        authorityRepository.save(roleUser);
        userRepository.save(nouveau);
    }

    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    /**
     * Authenticates the user. If something is wrong, an {@link AuthenticationException} will be thrown
     */
    private void authenticate(String username, String password) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticationException("User is disabled!", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("Bad credentials!", e);
        }
    }
}
