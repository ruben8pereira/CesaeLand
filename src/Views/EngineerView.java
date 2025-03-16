package Views;

import Controllers.EngineerController;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class EngineerView {
    private EngineerController engineerController;

    public EngineerView() throws FileNotFoundException {
        this.engineerController = new EngineerController();
    }

    public void engMenu() {
        Scanner input = new Scanner(System.in);

        int option;

        do {
            System.out.println("\n=== MAINTENANCE ENGINEER MENU ===");
            System.out.println("1. View Upcoming Maintenance Reviews");
            System.out.println("2. View Maintenance Reviews History");
            System.out.println("0. Exit");

            System.out.print("Choose an option: ");
            option = input.nextInt();

            switch (option) {
                case 1: //Implemented Method
                    System.out.println("\n=== UPCOMING MAINTENANCE REVIEWS ===");
                    engineerController.getUpcomingReviews();
                    break;
                case 2:
                    System.out.println("\n=== MAINTENANCE REVIEWS HISTORY ===");
                    engineerController.getReviewsHistory();
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