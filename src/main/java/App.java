import java.util.List;
import java.util.Random;
import java.util.Scanner;

import business.OrganizationBusiness;
import business.UserBusiness;
import business.UserOrganizationBusiness;
import model.Organization;
import model.User;
import model.UserOrganization;
import model.enumeration.ModelType;
import model.enumeration.UserType;
import utils.Utils;

public class App {
    private static final Scanner sc = new Scanner(System.in);
    private static final UserBusiness userBusiness = new UserBusiness();
    private static final OrganizationBusiness organizationBusiness = new OrganizationBusiness();
    private static final UserOrganizationBusiness userOrganizationBusiness = new UserOrganizationBusiness();
    private static int mainMenu;
    private static int secondMenu;
    private static ModelType modelType;

    public static void main(String[] args) {
        System.out.println("Welcome to Employee-Management-System");

        printMainMenu();

        System.out.println("Exit from application...");
    }

    private static void printMainMenu() {
        System.out.println("\n/*/*/*/*/*/* MAIN MENU /*/*/*/*/*/*\n");
        System.out.println("Enter 1 : to operate users ");
        System.out.println("Enter 2 : to operate organizations ");
        System.out.println("Enter 3 : to operate user organizations ");
        System.out.println("Enter 0 : to exit ");

        do {
            mainMenu = sc.nextInt();
            sc.nextLine();
            if (mainMenu != 0) {
                if (mainMenu > 0 && mainMenu <= 3) {
                    printSecondMenu();
                } else {
                    System.err.println("Please enter again correct answer...");
                }
            }
        } while (mainMenu != 0);
    }

    private static void printSecondMenu() {
        String modelTitle = "";
        if (mainMenu == 1) {
            modelTitle = "user";
            modelType = ModelType.USER;
        } else if (mainMenu == 2) {
            modelTitle = "organization";
            modelType = ModelType.ORGANIZATION;
        } else if (mainMenu == 3) {
            modelTitle = "user organization";
            modelType = ModelType.USER_ORGANIZATION;
        }

        System.out.println("---------- menu of " + modelTitle + "----------");

        System.out.println("Enter 1 : for create " + modelTitle);
        System.out.println("Enter 2 : for find by id " + modelTitle);
        System.out.println("Enter 3 : for find all " + modelTitle);
        System.out.println("Enter 0 : for back to main menu " + modelTitle);

        do {
            secondMenu = sc.nextInt();
            sc.nextLine();
            if (secondMenu != 0) {
                if (secondMenu > 0 && secondMenu <= 3) {
                    handleSecondMenu();
                } else {
                    System.err.println("Please enter again correct answer...");
                }
            }

        } while (secondMenu != 0);
        printMainMenu();
    }

    private static void handleSecondMenu() {
        switch (secondMenu) {
            case 1: {
                doCreate();
                break;
            }
            case 2: {
                doFindById();
                break;
            }
            case 3: {
                doFindAll();
                break;
            }
        }
    }

    private static void doCreate() {

        if (modelType.equals(ModelType.USER)) {
            User user = new User();



            System.out.println("Enter name : ");
            user.setName(sc.next());
            sc.nextLine();

            System.out.println("Enter age : ");
            user.setAge(sc.nextInt());
            sc.nextLine();

            System.out.println("Enter email : ");
            user.setEmail(sc.next());
            sc.nextLine();

            System.out.println("Enter user type :(M) Manager, (O) Operator, (E) Expert, (T) Teacher, (S) Student");
            String role = sc.next();
            sc.nextLine();
            switch (role) {
                case "M": {
                    user.setUserType(UserType.MANAGER);
                    break;
                }
                case "O": {
                    user.setUserType(UserType.OPERATOR);
                    break;
                }
                case "E": {
                    user.setUserType(UserType.EXPERT);
                    break;
                }
                case "T": {
                    user.setUserType(UserType.TEACHER);
                    break;
                }
                case "S": {
                    user.setUserType(UserType.STUDENT);
                    break;
                }
            }

            userBusiness.createUser(user);
        } else if (modelType.equals(ModelType.ORGANIZATION)) {
            Organization organization = new Organization();


            System.out.println("Enter name : ");
            organization.setName(sc.next());
            sc.nextLine();
            System.out.println("Enter code : ");
            organization.setCode(sc.next());
            sc.nextLine();

            organizationBusiness.createOrganization(organization);
        } else if (modelType.equals(ModelType.USER_ORGANIZATION)) {
            UserOrganization userOrganization = new UserOrganization();


            System.out.println("Enter user id : ");
            int userId = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter organization id : ");
            int organizationId = sc.nextInt();
            sc.nextLine();

            User user = userBusiness.findById(userId);
            Organization organization = organizationBusiness.findById(organizationId);

            userOrganization.setUser(user);
            userOrganization.setOrganization(organization);

            userOrganizationBusiness.createUserOrganization(userOrganization);

        }
        printSecondMenu();
    }

    private static void doFindById() {
        System.out.println("Enter id : ");
        int id = sc.nextInt();
        sc.nextLine();
        if (modelType.equals(ModelType.USER)) {
            User user = userBusiness.findById(id);
            System.out.println(Utils.print(user));
        } else if (modelType.equals(ModelType.ORGANIZATION)) {
            Organization organization = organizationBusiness.findById(id);
            System.out.println(Utils.print(organization));
        } else if (modelType.equals(ModelType.USER_ORGANIZATION)) {
            UserOrganization userOrganization = userOrganizationBusiness.findById(id);
            System.out.println(Utils.print(userOrganization));
        }
        printSecondMenu();
    }

    private static void doFindAll() {
        if (modelType.equals(ModelType.USER)) {
            List<User> users = userBusiness.findAll();
            for (User user : users) {
                System.out.println(Utils.print(user));
            }

        } else if (modelType.equals(ModelType.ORGANIZATION)) {
            List<Organization> organizations = organizationBusiness.findAll();
            for (Organization organization : organizations) {
                System.out.println(Utils.print(organization));
            }

        } else if (modelType.equals(ModelType.USER_ORGANIZATION)) {
            List<UserOrganization> userOrganizations = userOrganizationBusiness.findAll();
            for (UserOrganization userOrganization : userOrganizations) {
                System.out.println(Utils.print(userOrganization));
            }
        }
        printSecondMenu();
    }
}
