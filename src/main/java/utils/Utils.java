package utils;

import model.Organization;
import model.User;
import model.UserOrganization;

public class Utils {
    public static String print(User user) {
        StringBuilder builder = new StringBuilder();

        builder
                .append("\n { \n")
                .append("\t id : ").append(user.getId()).append("\n")
                .append("\t name : ").append(user.getName()).append("\n")
                .append("\t age : ").append(user.getAge()).append("\n")
                .append("\t email : ").append(user.getEmail()).append("\n")
                .append("\t createdDate : ").append(user.getCreatedDate()).append("\n } \n");

        return builder.toString();
    }

    public static String print(Organization organization) {
        StringBuilder builder = new StringBuilder();

        builder
                .append("\n { \n")
                .append("\t id : ").append(organization.getId()).append("\n")
                .append("\t name : ").append(organization.getName()).append("\n")
                .append("\t code : ").append(organization.getCode()).append("\n")
                .append("\t createdDate : ").append(organization.getCreatedDate()).append("\n } \n");

        return builder.toString();
    }

    public static String print(UserOrganization userOrganization) {
        StringBuilder builder = new StringBuilder();

        builder
                .append("\n { \n")
                .append("\t id : ").append(userOrganization.getId()).append("\n")
                .append("\t user : ").append(print(userOrganization.getUser())).append("\n")
                .append("\t organization : ").append(print(userOrganization.getOrganization())).append("\n")
                .append("\t register date : ").append(userOrganization.getRegisterDate()).append("\n")
                .append("\t createdDate : ").append(userOrganization.getCreatedDate()).append("\n } \n");

        return builder.toString();
    }
}
