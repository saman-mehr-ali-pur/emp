package dao;

import java.util.List;

import database.Database;
import model.UserOrganization;

public class UserOrganizationDao {
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
