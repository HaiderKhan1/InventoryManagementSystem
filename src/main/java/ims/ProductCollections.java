package ims;
import java.util.*;

public class ProductCollections {
  private Map<String, ArrayList<Product>> departmentProducts = new HashMap<String, ArrayList<Product>>();
  private ArrayList<String> departmentsList = new ArrayList<String>();
  private Map<Integer, Product> productUPCHash = new HashMap<Integer, Product>();
  private Map<String, Product> productNameHash = new HashMap<String, Product>();
  private ArrayList<Product> products = new ArrayList<Product>();
  private Parser parsedProducts;

  public ProductCollections(Parser parser) {
    this.parsedProducts = parser;
    setProductList();
    setDepartmentList();
    setProductMaps();
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

  /** instentiates the two hashmaps
  * makes the product UPC hash where the key is the upc and the value is the product
  * makes the product name hashmap, where the key is the string array of the product name, and the value is the product
  */
  private void setProductMaps() {
    for (Product i: products) {
      productUPCHash.put(i.getUPC(), i); //put in the upc hash
      productNameHash.put(i.getName().toLowerCase(), i); //put in the name hash
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

  public Product getProductFromName(String productName) {
      if (productNameHash.containsKey(productName)) {
        return productNameHash.get(productName);
      } else {
        return null;
      }
  }


  public ArrayList<Product> getProductsInDepartment(String input) {
    if (departmentProducts.containsKey(input)) {
      return departmentProducts.get(input);
    } else {
      return null;
    }
  }

  private int min(int n1, int n2) {
    if (n1 > n2) {
      return n2;
    } else {
      return n1;
    }
  }

  public ArrayList<Product> findProductIndirect(String input) {
    String[] inputArr = input.split(" ");
    ArrayList<Product> indirectProducts = new ArrayList<Product>();
    for (Map.Entry<String, Product> i: productNameHash.entrySet()) {
      String[] key = i.getKey().split(" ");
      boolean found = false;
      for (int j = 0; j < min(inputArr.length, key.length); j++) {
        if (inputArr[j].equals(key[j])) {
          found = true;
        }
      }

      if (found) {
        indirectProducts.add(i.getValue());
      }
    }

    if ( indirectProducts.size() == 0) {
      return null;
    } else {
      return indirectProducts;
    }


  }

}
