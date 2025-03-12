package Model;

import Domain.Sale;
import Tools.CSVReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SalesRepository {
    private ArrayList<Sale> salesList = new ArrayList<Sale>();

    public SalesRepository() throws FileNotFoundException {
        this.salesList = CSVReader.readSalesFileToArray("src/Resources/Cesaeland_vendas.csv");
    }

    public ArrayList<Sale> getSalesList() {
        return salesList;
    }
}
