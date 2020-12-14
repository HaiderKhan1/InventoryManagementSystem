package ims;

public class Main {
    public static void main(String []args) {
      // tester code
      Product product = new Product(1098469,"Tv", "Electronics", 5, 799.99, 3);
      System.out.println(product.Details());
      int quantity = product.getQuantity();

      if (quantity == 3) {
        System.out.println(true);
      }

      product.setQuantity(5);
      quantity = product.getQuantity();

      if (quantity == 5) {
        System.out.println(true);
      }
    }
}
