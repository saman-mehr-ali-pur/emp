package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import database.Database;
import model.User;
import model.enumeration.UserType;

public class UserDao {

    private static final String INSERT_QUERY = "insert into users(createdDate, name, age, email, userType)values (?, ?, ?, ?, ?);";
    private static final String FIND_BY_ID = "select *from users where id =?;";
    private static final String FIND_ALL = "select *from users;";
    private static final String DELETE = "delete from users where id=?";
    private static final String UPDATE = "update users set  createdDate =?, name=?, age=?, email=?," +
            " userType=? where  id=?";



    public void create(User user) {

        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement prepareStatement = connection.prepareStatement(INSERT_QUERY);
            prepareStatement.setString(1, user.getCreatedDate().toString());
            prepareStatement.setString(2, user.getName());
            prepareStatement.setInt(3, user.getAge());
            prepareStatement.setString(4, user.getEmail());
            prepareStatement.setString(5, user.getUserType().toString());

            int result = prepareStatement.executeUpdate();

            prepareStatement.close();
            connection.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static User findbyId(int id) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement prepareStatement = connection.prepareStatement(FIND_BY_ID);
            prepareStatement.setInt(1, id);

            ResultSet rs = prepareStatement.executeQuery();

            User user = new User();

            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setCreatedDate(ZonedDateTime.parse(rs.getString("createDate")));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setEmail(rs.getString("email"));
                user.setUserType(UserType.valueOf(rs.getString("userType")));

            }
            rs.close();
            prepareStatement.close();
            connection.close();

            return user;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

    public List<User> findAll() {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement prepareStatement = connection.prepareStatement(FIND_ALL);

            ResultSet rs = prepareStatement.executeQuery();

            List<User> users = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setCreatedDate(ZonedDateTime.parse(rs.getString("createdDate")));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setEmail(rs.getString("email"));
                user.setUserType(UserType.valueOf(rs.getString("userType")));
                users.add(user);

            }
            rs.close();
            prepareStatement.close();
            connection.close();

            return users;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }



    public void updateUser(User user) {

        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement prepareStatement = connection.prepareStatement(UPDATE);
            prepareStatement.setString(1, user.getName());
            prepareStatement.setInt(2, user.getAge());
            prepareStatement.setString(3, user.getEmail());
            prepareStatement.setString(4, user.getUserType().toString());
            prepareStatement.setInt(5, user.getId());

            int result = prepareStatement.executeUpdate();

            prepareStatement.close();
            connection.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



    public void deleteUser(User user){
        Connection connection = null;
        try {
            connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,user.getId());
            int result = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }
}




//    public void create(User user) {
//        List<User> userDB = Database.getUserDB();
//
//        userDB.add(user);
//    }
//
//    public User findbyId(int id) {
//        List<User> userDB = Database.getUserDB();
//        for (User user : userDB) {
//            if (user.getId() == id) {
//                return user;
//            }
//        }
//        return null;
//    }
//
//    public List<User> findAll() {
//        List<User> userDB = Database.getUserDB();
//        return userDB;
//    }

