package dao;

import java.util.List;

import database.Database;
import model.UserOrganization;

public class UserOrganizationDao {
   private final String INSERT_QUERY = "insert into user_organization (createdDate,registerDate,user_id," +
           "organization_id) values(?,?,?,?)";
   private final String DELETE_QUERY = "delete from user_organization where id=?";
   private final String UPDATE_QUERY = "update user_organization set" +
           "registerDate=?,user_id=?,organization_id=?";




    public void create(UserOrganization userOrganization) {
        List<UserOrganization> organizationDb = Database.getUserOrganizationDB();
        organizationDb.add(userOrganization);
    }

    public UserOrganization findbyId(int id) {
        List<UserOrganization> organizationDB = Database.getUserOrganizationDB();
        for (UserOrganization organization : organizationDB) {
            if (organization.getId() == id) {
                return organization;
            }
        }
        return null;
    }

    public List<UserOrganization> findAll() {
        List<UserOrganization> organizations = Database.getUserOrganizationDB();
        return organizations;
    }
}
