package ims;

public class Main {
    public static void main(String []args) {
      Product product = new Product(1098469,"Tv", "Electronics", 5, 799.99, 3);
      System.out.println(product.Details());
    }
}
