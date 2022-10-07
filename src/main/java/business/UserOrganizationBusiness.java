package business;

import java.util.List;

import dao.UserOrganizationDao;
import model.UserOrganization;

public class UserOrganizationBusiness {
    private UserOrganizationDao dao = new UserOrganizationDao();

    public void createUserOrganization(UserOrganization userOrganization) {
        if (dao.findbyId(userOrganization.getId()) == null) {
            dao.create(userOrganization);
        } else {
            System.err.println("user organization with given id exists!");
        }
    }

    public UserOrganization findById(int id) {
        return dao.findbyId(id);
    }

    public List<UserOrganization> findAll() {
        return dao.findAll();
    }
}
