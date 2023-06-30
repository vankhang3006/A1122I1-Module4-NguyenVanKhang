package service.impl;

import model.user.User;
import repository.IUserRepository;
import repository.impl.UserRepository;
import service.IUserService;

public class UserService implements IUserService {
    private IUserRepository userRepository = new UserRepository();

    @Override
    public User selectUser(String username, String password) {
        return userRepository.selectUser(username, password);
    }
}
