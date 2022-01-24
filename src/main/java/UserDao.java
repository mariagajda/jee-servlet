import utils.DbUtil;

import java.sql.*;
import java.util.Arrays;
import java.util.ResourceBundle;

public class UserDao {

    private static final String CREATE_USER_QUERY = "INSERT INTO newsletterTable(name, email) VALUES (?, ?);";
    private static final String DELETE_USER_QUERY = "DELETE FROM newsletterTable WHERE id = ?;";
    private static final String FIND_ALL_USERS_QUERY = "SELECT * from newsletterTable;";

    public User create(User user) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void delete(int id){
        try(Connection conn = DbUtil.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_USER_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public User[] findAll(){
        try(Connection conn = DbUtil.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(FIND_ALL_USERS_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            User[] users = new User[0];
            while (resultSet.next()){
                User newUser = new User();
                newUser.setId((resultSet.getInt(1)));
                newUser.setName(resultSet.getString(2));
                newUser.setEmail(resultSet.getString(3));
                users = addToArray(newUser, users);

            }
            return users;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    private User[] addToArray(User u, User[] users) {
        User[] tmpUsers = Arrays.copyOf(users, users.length + 1);
        tmpUsers[users.length] = u;
        return tmpUsers;
    }
}
