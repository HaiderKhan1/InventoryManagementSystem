package ims;
import java.util.ArrayList;

public class Main {
    public static void main(String []args) {
      // tester code
    //  Product product = new Product(1098469,"Tv", "Electronics", 5, 799.99, 3);
    //  System.out.println(product.productDetails());
      Parser parser = new Parser("./ProductInfo.json");
      ArrayList<Product> products = new ArrayList<Product>();
      products = parser.getProductArrayList();

      for (Product i: products) {
        System.out.println(i.productDetails());
      }


    }
}
