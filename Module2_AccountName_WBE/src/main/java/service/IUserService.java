package service;

import model.user.User;

public interface IUserService {
    public User selectUser(String username, String password);
}
