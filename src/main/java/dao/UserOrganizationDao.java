package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import database.Database;
import model.Organization;
import model.User;
import model.UserOrganization;

public class UserOrganizationDao {
   private final String INSERT_QUERY = "insert into user_organization (createdDate,registerDate,user_id," +
           "organization_id) values(?,?,?,?)";
   private final String DELETE_QUERY = "delete from user_organization where id=?";
   private final String UPDATE_QUERY = "update user_organization set" +
           "registerDate=?,user_id=?,organization_id=?";

   private final String FIND_BY_ID = "select * from user_organization where id=?";
   private final String FIND_ALL = "select uo.id id,uo.createdDate createdDate" +
           ",uo.registerDate registerDate,u.name user_name,o.name organization_name from" +
           " user_organization uo" +
           "inner join users u on uo.user_id=u.id" +
           "inner join organization o on o.id=uo.organization_id";

    public void create(UserOrganization userOrganization) {
        Connection connection = null;
        try {
            connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(1,userOrganization.getCreatedDate().toString());
            preparedStatement.setString(2,userOrganization.getRegisterDate().toString());
            preparedStatement.setInt(4,userOrganization.getUser().getId());
            preparedStatement.setInt(5,userOrganization.getOrganization().getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public UserOrganization findbyId(int id) {
        UserOrganization result = null;
        ResultSet rs;
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1,id);
            rs = preparedStatement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try {
            if(rs.next()){
                return new UserOrganization(new User(rs.getInt(1)),
                        new Organization(rs.getInt(1)),
                            ZonedDateTime.parse(rs.getString(3)));
            }

            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<UserOrganization> findAll() {
        ResultSet rs;
        List<UserOrganization> resultList = new ArrayList<>();
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            rs = preparedStatement.executeQuery();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return getUserOrganizationList(rs);
    }




   private List<UserOrganization> getUserOrganizationList(ResultSet resultSet){
            List<UserOrganization> finalList = new ArrayList<>();
            try {
                while(resultSet.next()) {
                    finalList.add(
                        new UserOrganization(new User(resultSet.getInt(1)),
                                new Organization(resultSet.getInt(1)),
                                ZonedDateTime.parse(resultSet.getString(3))));
)
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return finalList;
        }
   }
}
