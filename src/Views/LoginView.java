package Views;

import Controllers.LoginController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginView {
    private LoginController loginController;

    public LoginView() throws FileNotFoundException {
        this.loginController = new LoginController();
    }

    /**
     * Displays the main system entry menu
     * Allows choosing between customer, staff member, or exit
     *
     * @throws FileNotFoundException If an error occurs while accessing files
     */
    public void entryView() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        int loginOption;

        do {
            System.out.println("Welcome to CESAE Land");
            System.out.println("1. Customer");
            System.out.println("2. Staff Member");
            System.out.println("0. Exit");

            System.out.print("Choose: ");

            loginOption = input.nextInt();

            switch (loginOption) {
                case 1: // Customer
                    CustomerView customerView = new CustomerView();
                    customerView.customerMenu();
                    break;
                case 2: // Staff Member
                    System.out.println("\nLogin with your credentials:");

                    System.out.print("Username: ");
                    String username = input.next();

                    System.out.print("Password: ");
                    String password = input.next();

                    validateLogin(username, password);

                    break;
                case 0: // Exit
                    break;
                default: // Invalid Option
                    System.out.println("Invalid Option!");
            }
        } while (loginOption != 0);
    }

    /**
     * Validates staff member login credentials
     * Directs users to the menu corresponding to their access type
     *
     * @param usernameInput Username entered
     * @param passwordInput Password entered
     * @throws FileNotFoundException If an error occurs while accessing menus
     */
    private void validateLogin(String usernameInput, String passwordInput) throws FileNotFoundException {
        String access = loginController.accessType(usernameInput, passwordInput);

        switch (access) {
            case "ADMIN":
                AdminView adminView = new AdminView();
                adminView.adminMenu();
                break;
            case "ENG":
                EngineerView engView = new EngineerView();
                engView.engMenu();
                break;
            case "ERROR":
                System.out.println("Invalid Credentials!");
                break;
        }
    }
}
