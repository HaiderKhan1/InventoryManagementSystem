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
    setProductList();
    setDepartmentList();
    setProductUPChash();
    sortProductstoDepartments();
  }

  private void setProductList() {
    this.products = parsedProducts.getProductArrayList();
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
    for (Product i: products){
      departmentsList.add(i.getDepartment());
    }
  }

  private void setProductUPChash() {
    for (Product i: products) {
      productUPCHash.put(i.getUPC(), i);
    }
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
