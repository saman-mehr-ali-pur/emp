package database;

import java.util.ArrayList;
import java.util.List;

import model.*;

public class Database {
    private static List<User> users = null;
    private static List<UserOrganization> userOrganizations = null;
    private static List<Organization> organizations = null;

    public static List<User> getUserDB() {
        if (users == null) {
            users = new ArrayList<>();

        }
        return users;
    }

    public static List<UserOrganization> getUserOrganizationDB() {
        if (userOrganizations == null) {
            userOrganizations = new ArrayList<>();
        }
        return userOrganizations;
    }

    public static List<Organization> getOrganizationDB() {
        if (organizations == null) {
            organizations = new ArrayList<>();
        }
        return organizations;
    }

}
