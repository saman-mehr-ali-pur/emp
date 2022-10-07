package business;

import java.util.List;

import dao.OrganizationDao;
import model.Organization;

public class OrganizationBusiness {
    private OrganizationDao dao = new OrganizationDao();

    public void createOrganization(Organization organization) {
        if (dao.findbyId(organization.getId()) == null) {
            dao.create(organization);
        } else {
            System.err.println("organization with given id exists!");
        }
    }

    public Organization findById(int id) {
        return dao.findbyId(id);
    }

    public List<Organization> findAll() {
        return dao.findAll();
    }
}
