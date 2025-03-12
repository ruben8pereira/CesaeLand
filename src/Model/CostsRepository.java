package Model;

import Domain.Cost;
import Domain.User;
import Tools.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CostsRepository {
    private ArrayList<Cost> costsList;

    public CostsRepository() throws FileNotFoundException {
        this.costsList = CSVReader.readCostsFileToArray("src/Resources/Cesaeland_custos.csv");
    }

    public ArrayList<Cost> getCostsList() {
        return costsList;
    }
}
