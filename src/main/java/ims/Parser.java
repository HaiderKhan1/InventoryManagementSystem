package ims;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
  private ArrayList<Product> products = new ArrayList<Product>();
  private Map<Integer, Product> productsMap = new HashMap<Integer, Product>();
  private ArrayList<String> departments = new ArrayList<String>();

  public Parser() {

  }

  public Parser(String filename) {
    parseFile(filename);
  }

  public void parseFile(String filename) {
    JSONObject parsedInfo = loadJsonFile(filename);
    JSONArray productsJSON = (JSONArray) parsedInfo.get("products");

    for (Object i: productsJSON) {
      JSONObject parseProduct = (JSONObject) i;
      String quantity = parseProduct.get("quantity").toString();
      String price = parseProduct.get("price").toString();
      String name = parseProduct.get("name").toString();
      String upc = parseProduct.get("upc").toString();
      String location = parseProduct.get("location").toString();
      String department = parseProduct.get("department").toString();
      Product newProduct = new Product(Integer.parseInt(upc), name, department, Integer.parseInt(location),
      Double.parseDouble(price), Integer.parseInt(quantity));
      products.add(newProduct);
    }
  }


  public ArrayList<Product> getProductArrayList() {
    return products;
  }


  public JSONObject loadJsonFile(String file) {
  JSONParser jsonparser = new JSONParser();
  JSONObject parsedFile = null;

  try {
    Object obj = jsonparser.parse(new FileReader(file));
    parsedFile = (JSONObject) obj;

  } catch (FileNotFoundException e) {
      e.printStackTrace();
  } catch (IOException e) {
      e.printStackTrace();
  } catch (ParseException e) {
      e.printStackTrace();
  }

  return parsedFile;
}

}
