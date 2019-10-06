package lab.local_market_app.B_Services;


import lab.local_market_app._Domain.User;

import javax.persistence.Id;
import java.util.List;

public interface IUserService {

    User addProduct(User user);
    User  updateUser(User user);
    List<User> listUser();
    List <User> findUserByName(String name);
    void deleteUser(Long idUser);
    User findById(Long id);

}
