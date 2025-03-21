package Controllers;

import Domain.Attraction;
import Domain.Sale;
import Model.AttractionsRepository;
import Model.SalesRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class EngineerController {
    private AttractionsRepository attractionsRepository;
    private SalesRepository salesRepository;

    public EngineerController() throws FileNotFoundException {
        this.attractionsRepository = new AttractionsRepository();
        this.salesRepository = new SalesRepository();
    }

    /**
     * Gets the upcoming maintenance reviews (3 nearest reviews)
     * Shows attraction ID, name and number of tickets until review
     */
    public void getUpcomingReviews() {
        ArrayList<Attraction> attractions = attractionsRepository.getAttractionsList();
        ArrayList<Sale> sales = salesRepository.getSalesList();

        // Count tickets sold for each attraction
        int[] ticketCounter = new int[10];

        for (Sale sale : sales) {
            int id = sale.getAttractionId();
            ticketCounter[id - 1]++;
        }

        // Arrays to store attraction information and tickets until review
        int[] attractionIds = new int[attractions.size()];
        String[] attractionNames = new String[attractions.size()];
        int[] ticketsUntilReview = new int[attractions.size()];

        // Calculate tickets until next review
        for (int i = 0; i < attractions.size(); i++) {
            Attraction attraction = attractions.get(i);
            int id = attraction.getId();

            int soldTickets = ticketCounter[id - 1];
            int remainingTickets = 50 - (soldTickets % 50);

            if (remainingTickets == 50) {
                remainingTickets = 0; // Review needed immediately
            }

            attractionIds[i] = id;
            attractionNames[i] = attraction.getName();
            ticketsUntilReview[i] = remainingTickets;
        }

        // Bubble sort to sort by tickets until review
        for (int i = 0; i < attractions.size() - 1; i++) {
            for (int j = 0; j < attractions.size() - i - 1; j++) {
                if (ticketsUntilReview[j] > ticketsUntilReview[j + 1]) {
                    // Swap tickets
                    int tempTickets = ticketsUntilReview[j];
                    ticketsUntilReview[j] = ticketsUntilReview[j + 1];
                    ticketsUntilReview[j + 1] = tempTickets;

                    // Swap IDs
                    int tempId = attractionIds[j];
                    attractionIds[j] = attractionIds[j + 1];
                    attractionIds[j + 1] = tempId;

                    // Swap names
                    String tempName = attractionNames[j];
                    attractionNames[j] = attractionNames[j + 1];
                    attractionNames[j + 1] = tempName;
                }
            }
        }

        // Display the 3 nearest reviews
        System.out.println("---------------------- UPCOMING REVIEWS ----------------------");
        for (int i = 0; i < attractions.size() && i < 3; i++) {
            System.out.println("ID: " + attractionIds[i] +
                    " | Attraction: " + attractionNames[i] +
                    " | Tickets until review: " + ticketsUntilReview[i]);
        }
        System.out.println("--------------------------------------------------------------");
    }

    /**
     * Gets the history of maintenance reviews (3 most recent reviews)
     */
    public void getReviewsHistory() {
        System.out.println("Not implemented yet");
    }
}