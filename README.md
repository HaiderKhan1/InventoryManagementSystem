Application Layout
Super class of product
Multiple instantiations (constructor parameters)
Full product instantiation:
-name
-UPC
-price
-department
  - location
-Quantity on hand

* A product can be instantiated without all it's required fields.
  - it will be primarily used for adding a product later by the manager class
Possible constructor parameters
-name
-price
-upc


*** Data Structures ***
HashMap<Integer, Product>
Key: Integer is the product UPC
Value: Product object type

Features to Add:
 - Writing to a JSON file after products have been added or such
 - Graphical User Interface ( Swing UI )
 - Costumer Prompt:
 - Can look up products by:
 - UPC or name
 - it provides a list of all the products on hand, click a product (JLSIT) to view information
 - Manager outlook:
 - Enter log in creds
 - Do everything a costumer can with a IMS +
 - add, remove and update item info ( quantity ) -> write the new data to a JSON
