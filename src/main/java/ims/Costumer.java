package ims;
import java.util.*;
import java.io.*;

/** Costumer class responsibilites:
  - an event handler when pressed the costumer, creates the costumer object
  - a function to prompt a user:
    Welcome to my IMS
    You may enter the UPC, Product name or the Product Category you're looking for

    Hash Map of hash Map
*/

public class Costumer {

  private ProductCollections products;

  public Costumer(ProductCollections parsedProducts) {
    this.products = parsedProducts;
    promptUser();
  }

  private void promptUser() {
    Scanner scan = new Scanner(System.in);
    String input = "";
    boolean imsState = true;
    System.out.println("Terminal UI Instructions");
    System.out.println("You can enter a UPC to find a specific product");
    System.out.println("You can enter a product name, if that specific product is not found it'll show related products");
    System.out.println("You can enter a department name to display every single product from the given department");
    System.out.println("You may type 'exit' to exit out of the IMS program at anytime :)");
    //enter the instructions
    while (imsState) {
      System.out.println("Product Lookup: ");
      input = scan.nextLine();
      if (input.equals("exit")) {
        exitPrompt();
        imsState = false;
        break;
      }

      try {
        int upc = Integer.parseInt(input);
        upcLookup(upc);
      } catch (NumberFormatException e) {
          e.getMessage();
      }
      productLookUp(input.toLowerCase());
    }

  }

  private void productLookUp(String input) {
    boolean departmentCase = products.checkDepartmnetList(input);
    if (departmentCase == true) {
      ArrayList<Product> newProducts = new ArrayList<Product>();
      newProducts = products.getProductsInDepartment(input);
      if (newProducts != null) {
        printDepartmentProductsList(newProducts);
      } else {
        System.out.println("The given product name or department was not found");
      }
    }
  }

  private void printDepartmentProductsList(ArrayList<Product> displayProducts) {
    for (Product i: displayProducts) {
      System.out.println(i.productDetails());
    }
  }

  //should be callable from the UI class, therefore, I am leaving it as public ( if exit call this function)
  public void exitPrompt() {
    System.out.println("Thanks for using the IMS");
    System.out.println("Exiting session now...");
  }

  private void upcLookup(int upc) {
    Product product;
    product =  products.getProductUPC(upc);
    if ( product != null ) {
      System.out.println(product.productDetails());
    } else {
    System.out.println("Product not found, the provided UPC is incorrect");

    }

  }


}
