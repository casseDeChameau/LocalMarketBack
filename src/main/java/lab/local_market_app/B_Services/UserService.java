package lab.local_market_app.B_Services;

import lab.local_market_app.A_Repository.IUserRepository;
import lab.local_market_app._Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

@Service
public class UserService implements IUserService{


    @Autowired
    private IUserRepository userRepository;

    //CREATE
    @Override
    public User addProduct(User user) {
        return userRepository.save(user);
    }
    //UPDATE
    @Override
    @PreAuthorize("hasRole('ADMIN') " +
                "or hasRole('USER')")
    public User updateUser(User user) {
        return userRepository.save(user);
    }
    //READ LIST
    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> listUser() {
        return userRepository.findAll();
    }
    //READ ONE
    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> findUserByName(String name) {
        return userRepository.findByUsernameContaining(name);
    }
    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public User findById(Long id) {
        return userRepository.findUserById(id);
    }

    //DELETE
    @Override
    @PreAuthorize("hasRole('ADMIN') " +
                "or hasRole('USER')")
    public void deleteUser(Long idUser) {
        userRepository.deleteById(idUser);
    }
}
