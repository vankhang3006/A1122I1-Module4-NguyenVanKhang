package repository;


import model.user.User;

public interface IUserRepository {

    public User selectUser(String username, String password);

}
