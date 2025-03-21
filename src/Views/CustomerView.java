package Views;

import Controllers.CustomerController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CustomerView {
    private CustomerController customerController;

    public CustomerView() throws FileNotFoundException {
        this.customerController = new CustomerController();
    }

    public void customerMenu() {
        Scanner input = new Scanner(System.in);

        int option;

        do {
            System.out.println("\n=== CUSTOMER MENU ===");
            System.out.println("1. View Available Attractions");
            System.out.println("2. View Favorite Attractions");
            System.out.println("0. Exit");

            System.out.print("Choose an option: ");
            option = input.nextInt();

            switch (option) {
                case 1: //Implemented Method
                    System.out.println("\n=== AVAILABLE ATTRACTIONS ===");
                    customerController.listAvailableAttractions();
                    break;
                case 2:
                    System.out.println("\n=== FAVORITE ATTRACTIONS ===");
                    System.out.println("Most popular attraction for Adults: " + customerController.getMostPopularAdultAttraction());
                    System.out.println("Most popular attraction for Children: " + customerController.getMostPopularChildAttraction());
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid Option!");
            }
        } while (option != 0);
    }
}