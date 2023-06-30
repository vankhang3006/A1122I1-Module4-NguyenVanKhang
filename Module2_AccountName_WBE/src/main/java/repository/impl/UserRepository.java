package repository.impl;

import model.user.User;
import model.user.User;
import repository.BaseRepository;
import repository.IUserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements IUserRepository {
    private final String SELECT_USER= "SELECT id,username,password,real_name FROM user WHERE username = ? AND password = ?";


    public UserRepository() {
    }

    @Override
    public User selectUser(String username, String password) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = BaseRepository.getConnectDB();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER);) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String realName = rs.getString("real_name");
                user = new User(id,username,password,realName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
