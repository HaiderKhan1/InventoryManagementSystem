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
      System.out.println("Your search: " + input);
      System.out.println("");
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
      departmentCase(input);
    } else {
      nameLookup(input);
    }
  }

  private void departmentCase(String input) {
    ArrayList<Product> newProducts = new ArrayList<Product>();
    newProducts = products.getProductsInDepartment(input);
    if (newProducts != null) {
      printProductList(newProducts);
    } else {
      System.out.println("The given product name or department was not found");
    }
  }

  private void departmentCase(Product product, String input) {
    ArrayList<Product> newProducts = new ArrayList<Product>();
    newProducts = products.getProductsInDepartment(input);
    if (newProducts != null) {
      newProducts.remove(product);
      printProductList(newProducts);
    } else {
      System.out.println("The given product name or department was not found");
    }
  }

  private void nameLookup(String input) {
    Product lookup = products.getProductFromName(input);
    boolean searchResult = false;
    ArrayList<Product> indirectResult = new ArrayList<Product>();

    if (lookup != null) {
      searchResult = true;
      System.out.println(lookup.productDetails());
      altChoices(lookup, lookup.getDepartment(), searchResult);
    } else {
      indirectResult = products.findProductIndirect(input);
        if (indirectResult != null) {
          searchResult = true;
          System.out.println("Found Products: ");
          System.out.println("");
          printProductList(indirectResult);
          altChoices(indirectResult, searchResult);
        } else {
          System.out.println("Sorry we couldn't find the product you're looking for");
        }
    }
  }

  private void altChoices(ArrayList<Product> results, boolean searchResult) {
    if (searchResult) {
      System.out.println("<----------- Also take a look at the following products ---------------->");
      departmentCase(results.get(0).getDepartment());
    }
  }

  private void altChoices(Product lookup, String department, boolean result) {
    if (result == true) {
    System.out.println("<----------- Also take a look at the following products ---------------->");
    departmentCase(lookup, department);

  } else {
    System.out.println("Sorry we could not find the product");
    System.out.println("Here's a list a products we do have currently, hope it helps :)");
    departmentCase(department);
    }
  }

  private void printProductList(ArrayList<Product> displayProducts) {
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
