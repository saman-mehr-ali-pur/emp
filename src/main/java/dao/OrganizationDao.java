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
import model.enumeration.UserType;

public class OrganizationDao {

    private static final String INSERT_QUERY = " insert into organization(createddate, name, code)values (?, ?, ?)";
    private static final String FIND_BY_ID = "select * from organization where id =?;";
    private static final String FIND_ALL = "select * from organization;";
    private static final String DELETE_Oganizition = "delete from organization where id=?";
    private static final String UPDATE_Oganiziton = "update organization set " +
            "createdDate=?,name=?,code=?";


    public void create(Organization organization) {
        List<Organization> organizationDb = Database.getOrganizationDB();
        organizationDb.add(organization);
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement prepareStatement = connection.prepareStatement(INSERT_QUERY);
            prepareStatement.setString(1, organization.getCreatedDate().toString());
            prepareStatement.setString(2, organization.getName());
            prepareStatement.setString(3, organization.getCode());

            int result = prepareStatement.executeUpdate();

            prepareStatement.close();
            connection.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public Organization findbyId(int id) {

        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement prepareStatement = connection.prepareStatement(FIND_BY_ID);
            prepareStatement.setInt(1, id);

            ResultSet rs = prepareStatement.executeQuery();

            Organization organizations = new Organization();

            while (rs.next()) {
                organizations.setId(rs.getInt("id"));
                organizations.setCreatedDate(ZonedDateTime.parse(rs.getString("createddate")));
                organizations.setName(rs.getString("name"));
                organizations.setCode(rs.getString("code"));

            }
            rs.close();
            prepareStatement.close();
            connection.close();

            return organizations;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public List<Organization> findAll() {
        try {
            Connection connection = DatabaseConnection.getInstance();
            PreparedStatement prepareStatement = connection.prepareStatement(FIND_ALL);

            ResultSet rs = prepareStatement.executeQuery();

            List<Organization> organizationList = new ArrayList<>();
            while (rs.next()) {
                Organization organizations = new Organization();
                organizations.setId(rs.getInt("id"));
                organizations.setCreatedDate(ZonedDateTime.parse(rs.getString("createddate")));
                organizations.setName(rs.getString("name"));
                organizations.setCode(rs.getString("code"));
                organizationList.add(organizations);

            }
            rs.close();
            prepareStatement.close();
            connection.close();

            return organizationList;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }


    public void updateOganizatoin(Organization organization){
        Connection connection=null;
        try {
            connection=DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_Oganiziton);
            preparedStatement.setString(1,organization.getCreatedDate().toString());
            preparedStatement.setString(2,organization.getName());
            preparedStatement.setString(3,organization.getCode());

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteOraganization(Organization oraOrganization){
        Connection connection=null;
        try {
            connection=DatabaseConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_Oganizition);
            preparedStatement.setInt(1,oraOrganization.getId());


            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
