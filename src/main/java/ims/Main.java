package ims;
import java.util.ArrayList;

public class Main {
    public static void main(String []args) {
      Parser parser = new Parser("./ProductInfo.json");
      ProductCollections products = new ProductCollections(parser);
      Costumer costumer = new Costumer(products);

    }
}
