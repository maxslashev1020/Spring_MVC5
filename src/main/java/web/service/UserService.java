package web.service;

import web.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public void saveUser(User user);
    public User showId(long id);
    public void update(User user);
    public void delete(long id);
}
