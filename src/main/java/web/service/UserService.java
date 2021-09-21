package web.service;

import org.springframework.security.core.userdetails.UserDetails;
import web.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void updateUser(User user);

    void removeUserById(long id);

    User getUserById(long id);

    List<User> getAllUsers();

    User getUserByName(String username);
}
