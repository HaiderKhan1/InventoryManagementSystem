package ims;

public class Product {

  // instead of int I chose integer becuase with the Integer Object I can set the values to null
  // also when I return these values through the getter, I unbox it to it's primitive data type int
  private Integer productUPC = null;
  private String productName = "Undefined";
  private String productDepartmet = "Undefined";
  private Integer productLocation = null;
  private double productPrice = Double.NaN;
  private Integer productQuantity = null;
  private String outPut = "";

  /** A product must be initalized with the upc, name and departmet
  * for example, a new product expected to come later so we can initalize but add quantitites to it later
  @param upc
  @param name
  @param departmet
  */
  public Product(int upc, String name, String department) {
    setUPC(upc);
    setName(name);
    setDepartment(department);
    updateOutPut();
  }

  /** full product initalizion.
  @param upc (int)
  @param name (String)
  @param department ( String )
  @param location ( int )
  @param price (double)
  @param quantity (int)
  */
  public Product(int upc, String name, String department, int location, double price, int quantity) {
    setUPC(upc);
    setName(name);
    setDepartment(department);
    setLocation(location);
    setPrice(price);
    setQuantity(quantity);
    updateOutPut();
  }

  public void updateOutPut() {
    outPut += "Name: " + productName + "\n";
    outPut += "UPC: " + productUPC + "\n";
    outPut += "Departmet: " + productDepartmet + "\n";
    outPut += "Asile: " + productLocation + "\n";
    outPut += "Price: " + productPrice + "\n";
    outPut += "Quantity: " + productQuantity + "\n";
  }

  public String Details() {
    return outPut;
  }

  /** For now I'm leaving all getters and setters public
  - the manager class needs to be able to access all the setters
  - while both the classes need access to the setter.
  */
  public void setUPC(int upc) {
    this.productUPC = upc;
  }

  public void setName(String name) {
    this.productName = name;
  }

  public void setDepartment(String departmet) {
    this.productDepartmet = departmet;
  }

  public void setLocation(int location){
    this.productLocation = location;
  }

  public void setPrice(double price) {
    this.productPrice = price;
  }

  public void setQuantity(int quantity) {
    this.productQuantity = quantity;
  }

  public int getUPC(){
    return productUPC;
  }

  public String getName(){
    return productName;
  }

  public String getDepartment(){
    return productDepartmet;
  }

  public int getLocation() {
    return productLocation;
  }

  public double getPrice() {
    return productPrice;
  }

  public int getQuantity() {
    return productQuantity;
  }
}
