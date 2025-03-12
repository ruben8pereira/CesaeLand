package Model;

import Domain.Attraction;
import Domain.Cost;
import Tools.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AttractionsRepository {
    private ArrayList<Attraction> attractionsList;

    public AttractionsRepository() throws FileNotFoundException {
        this.attractionsList = CSVReader.readAttractionsFileToArray("src/Resources/Cesaeland_atracoes.csv");
    }

    public ArrayList<Attraction> getAttractionsList() {
        return attractionsList;
    }
}
