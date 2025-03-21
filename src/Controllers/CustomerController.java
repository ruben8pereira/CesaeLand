package Controllers;

import Domain.Attraction;
import Model.AttractionsRepository;
import Model.SalesRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CustomerController {
    private AttractionsRepository attractionsRepository;
    private SalesRepository salesRepository;

    public CustomerController() throws FileNotFoundException {
        this.attractionsRepository = new AttractionsRepository();
        this.salesRepository = new SalesRepository();
    }

    /**
     * Lists all available attractions with their details in a tabular format
     */
    public void listAvailableAttractions() {
        ArrayList<Attraction> attractions = attractionsRepository.getAttractionsList();

        System.out.println("------------------- AVAILABLE ATTRACTIONS -------------------");
        for (Attraction attraction : attractions) {
            // Format duration as min:sec
            int minutes = attraction.getDurationInSeconds() / 60;
            int seconds = attraction.getDurationInSeconds() % 60;
            String duration = minutes + ":" + seconds;

            System.out.println("ID: " + attraction.getId() +
                    " | Attraction: " + attraction.getName() +
                    " | Adult Ticket: " + attraction.getAdultTicket() + "€" +
                    " | Child Ticket: " + attraction.getChildTicket() + "€" +
                    " | Duration: " + duration);
        }
        System.out.println("----------------------------------------------------------");
    }

    /**
     * Gets the name of the most popular attraction for adults
     * @return String with attraction name
     */
    public String getMostPopularAdultAttraction() {
        return "Not implemented yet";
    }

    /**
     * Gets the name of the most popular attraction for children
     * @return String with attraction name
     */
    public String getMostPopularChildAttraction() {
        return "Not implemented yet";
    }
}