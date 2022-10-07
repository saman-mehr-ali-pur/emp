package business;

import java.util.List;

import dao.UserDao;
import model.User;

public class UserBusiness {
    private UserDao dao = new UserDao();

    public void createUser(User user) {

        dao.create(user);

    }


    public User findById(int id) {
        return dao.findbyId(id);
    }

    public List<User> findAll() {
        return dao.findAll();
    }
}
