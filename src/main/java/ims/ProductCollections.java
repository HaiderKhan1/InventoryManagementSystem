package ims;
import java.util.*;

public class ProductCollections {
  private Map<String, ArrayList<Product>> departmentProducts = new HashMap<String, ArrayList<Product>>();
  private ArrayList<String> departmentsList = new ArrayList<String>();
  private Map<Integer, Product> productUPCHash = new HashMap<Integer, Product>();
  private ArrayList<Product> products = new ArrayList<Product>();
  private Parser parsedProducts;

  public ProductCollections(Parser parser) {
    this.parsedProducts = parser;
    setDepartmentList();
    setProductUPChash();
    setProductList();
    sortProductstoDepartments();
  }

  private void sortProductstoDepartments() {
    for (String i: departmentsList) {
      ArrayList<Product> newProducts = new ArrayList<Product>();
      for (Product j: products) {
        if (j.getDepartment().equals(i)) {
          newProducts.add(j);
        }
      }
      departmentProducts.put(i, newProducts);
    }
  }

  private void setDepartmentList() {
    this.departmentsList = parsedProducts.getDepartmentsList();
  }

  private void setProductUPChash() {
    this.productUPCHash = parsedProducts.getProductHashMap();
  }

  private void setProductList() {
    this.products = parsedProducts.getProductArrayList();
  }

  public Product getProductUPC(int upc) {
    if (productUPCHash.containsKey(upc)) {
      return productUPCHash.get(upc);
    } else {
      return null;
    }
  }

  public boolean checkDepartmnetList(String input) {
    for (String i: departmentsList) {
      if(i.equals(input)) {
        return true;
      }
    }
    return false;
  }

  public ArrayList<Product> getProductsInDepartment(String input) {
    if (departmentProducts.containsKey(input)) {
      return departmentProducts.get(input);
    } else {
      return null;
    }
  }

}
