/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Subject: Algorithms and Programming II
 * Integrative Task I
 * Student Code: A00365977
 * @Author: Juan Esteban Caicedo A.
 * @Date: September, 26th 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import exceptions.NonLogicalDocumentTypeException;
import exceptions.NonLogicalStatusException;

public class AssociationRestaurant {

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    public final static String SAVE_RESTAURANTS_PATH_FILE = "data/restaurants.ap2";
    public final static String SAVE_PRODUCTS_PATH_FILE = "data/products.ap2";
    public final static String SAVE_CLIENTS_PATH_FILE = "data/clients.ap2";
    public final static String SAVE_ORDERS_PATH_FILE = "data/orders.ap2";
    public final static String SEPARATOR = " ; ";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    private String nameAssociation;

    // -----------------------------------------------------------------
    // Relations
    // -----------------------------------------------------------------

    private List<Restaurant> restaurants;
    private List<Product> products;
    private List<Client> clients;
    private List<Order> orders;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
	 * Name: AssociationRestaurant
	 * Constructor method of a restaurant association. <br>
	 * @param nameAssociation - name of the restaurant association - nameAssociation = String, nameAssociation != null, nameAssociation != ""
	*/
    public AssociationRestaurant(String nameAssociation) throws ClassNotFoundException, IOException {
        this.nameAssociation = nameAssociation;
        restaurants = new ArrayList<Restaurant>();
        products = new ArrayList<Product>();
        clients = new ArrayList<Client>();
        orders = new ArrayList<Order>();
        loadData();
    }

    public String getNameAssociation() {
        return nameAssociation;
    }

    public void setNameAssociation(String nameAssociation) {
        this.nameAssociation = nameAssociation;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> order) {
        this.orders = order;
    }

    /**
     * Name: addRestaurant
     * Method used to register a restaurant in the list of restaurants of the system. <br>
     * <b>pre: </b> List of restaurants already initialized. <br>
     * <b>post: </b> Registry process determined of the restaurant in question in the list of restaurants of the system. <br>
     * @param nameRestaurant - restaurant name - nameRestaurant = String, nameRestaurant != null, nameRestaurant != ""
     * @param nitRestaurant - restaurant NIT - nitRestaurant = String, nitRestaurant != null, nitRestaurant != ""
     * @param nameCeo - restaurant administrator - nameCeo = String, nameCeo != null, nameCeo != ""
     * @param operator - restaurant operator - operator = String, operator != null, operator != ""
     * @throws IOException - if it cannot write the file properly while saving after adding a restaurant.
     * @return A String with a message about the successful adding process of the restaurant to the list of restaurants of the system; or, a String with a message about an error because the restaurant already exists in the system.
    */
    public String addRestaurant(String nameRestaurant, String nitRestaurant, String nameCeo, String operator) throws IOException {
        String message = "";
        if (restaurants.isEmpty()) {
            Restaurant obj = new Restaurant(nameRestaurant, nitRestaurant, nameCeo, operator);
            restaurants.add(obj);
            message = "\nSaving data...\nNew restaurant successfully registered.";
            saveDataRestaurants();
        } else {
            Restaurant objSearch = searchRestaurant(nitRestaurant);
            if (objSearch != null)
                message = "\nThis restaurant was already registered in the system previously.";
            else {
                Restaurant obj = new Restaurant(nameRestaurant, nitRestaurant, nameCeo, operator);
                restaurants.add(obj);
                message = "\nSaving data...\nNew restaurant successfully registered.";
                saveDataRestaurants();
            }
        }
        return message;
    }

    /**
     * Name: addRestaurantForTest
     * Method used in a JUnit Test for testing the registration of a restaurant in the list of restaurants of the system, without serializing this list in the test. <br>
     * <b>pre: </b> List of restaurants already initialized. <br>
     * <b>post: </b> Registry process determined of the restaurant in question in the list of restaurants of the system. <br>
     * @param nameRestaurant - restaurant name - nameRestaurant = String, nameRestaurant != null, nameRestaurant != ""
     * @param nitRestaurant - restaurant NIT - nitRestaurant = String, nitRestaurant != null, nitRestaurant != ""
     * @param nameCeo - restaurant administrator - nameCeo = String, nameCeo != null, nameCeo != ""
     * @param operator - restaurant operator - operator = String, operator != null, operator != ""
     * @return A String with a message about the successful adding process of the restaurant to the list of restaurants of the system; or, a String with a message about an error because the restaurant already exists in the system.
    */
    public String addRestaurantForTest(String nameRestaurant, String nitRestaurant, String nameCeo, String operator) {
        String message = "";
        Restaurant objSearch = searchRestaurant(nitRestaurant);
        if (objSearch != null)
            message = "\nThis restaurant was already registered in the system previously.";
        else {
            Restaurant obj = new Restaurant(nameRestaurant, nitRestaurant, nameCeo, operator);
            restaurants.add(obj);
            message = "\nSaving data...\nNew restaurant successfully registered.";
        }
        return message;
    }

    /**
     * Name: searchRestaurant
     * Method used to search a restaurant in the list of restaurants of the system. <br>
     * <b>pre: </b> List of restaurants already initialized. <br>
     * <b>post: </b> Searching process determined of the restaurant in question in the list of restaurants registered in the system. <br>
     * @param nitRestaurant - restaurant NIT - nitRestaurant = String, nitRestaurant != null, nitRestaurant != ""
     * @return A Restaurant object different from null if the restaurant in question was found in the system, or with null if not.
    */
    public Restaurant searchRestaurant(String nitRestaurant) {
        Restaurant objSearch = null;
        boolean findRestaurant = false;
        for (int i = 0; i < restaurants.size() && !findRestaurant; i++) {
            if (restaurants.get(i) != null) {
                if (restaurants.get(i).getNitRestaurant().equals(nitRestaurant)) {
                    objSearch = restaurants.get(i);
                    findRestaurant = true;
                }
            }
        }
        return objSearch;
    }

    /**
     * Name: addProduct
     * Method used to register a product in the list of products of the system. <br>
     * <b>pre: </b> List of products already initialized and at least one restaurant is registered in the system. <br>
     * <b>post: </b> Registry process determined of the product in question in the list of products of the system. <br>
     * @param codeProduct - Product code - codeProduct = String, codeProduct != null, codeProduct != ""
     * @param nameProduct - Product name - nameProduct = String, nameProduct != null, nameProduct != ""
     * @param description - Product description - description = String, description != null, description != ""
     * @param cost - Product cost - cost = double, cost != null, cost != 0
     * @param nitRestaurant - NIT of the restaurant product owner - nitRestaurant = String, nitRestaurant != null, nitRestaurant != ""
     * @param content - Product content - content = double, content != null, content != 0
     * @param amountOrdered - Ordered units of the product when an order is going to be placed - amountOrdered = int, amountOrdered != null
     * @throws IOException - if it cannot write the file properly while saving after adding a product.
     * @return A String with a message about the successful adding process of the product to the list of products of the system; or, a String with a message about an error because the product already exists in the system; or, a String with a message about an error because the restaurant doesn't exist in the system.
    */
    public String addProduct(String codeProduct, String nameProduct, String description, double cost, String nitRestaurant, double content, int amountOrdered) throws IOException {
        String message = "";
        Restaurant objSearch1 = searchRestaurant(nitRestaurant);
        if (objSearch1 == null)
            message = "The restaurant with NIT " + nitRestaurant + " isn't registered in the system.";
        else {
            Product objSearch2 = searchProductWithCodeAndNit(codeProduct, nitRestaurant);
            if (objSearch2 != null)
                message = "\nThis product already exists in the system for that restaurant.";
            else {
                Product obj = new Product(codeProduct, nameProduct, description, cost, nitRestaurant, content,
                        amountOrdered);
                products.add(obj);
                message = "\nSaving data...\nNew product successfully registered.";
                saveDataProducts();
            }
        }
        return message;
    }

    /**
     * Name: addProductForTest
     * Method used in a JUnit Test for testing the registration of a product in the list of products of the system, without serializing this list in the test. <br>
     * <b>pre: </b> List of products already initialized and at least one restaurant is registered in the system. <br>
     * <b>post: </b> Registry process determined of the product in question in the list of products of the system. <br>
     * @param codeProduct - Product code - codeProduct = String, codeProduct != null, codeProduct != ""
     * @param nameProduct - Product name - nameProduct = String, nameProduct != null, nameProduct != ""
     * @param description - Product description - description = String, description != null, description != ""
     * @param cost - Product cost - cost = double, cost != null, cost != 0
     * @param nitRestaurant - NIT of the restaurant product owner - nitRestaurant = String, nitRestaurant != null, nitRestaurant != ""
     * @param content - Product content - content = double, content != null, content != 0
     * @param amountOrdered - Ordered units of the product when an order is going to be placed - amountOrdered = int, amountOrdered != null
     * @return A String with a message about the successful adding process of the product to the list of products of the system; or, a String with a message about an error because the product already exists in the system; or, a String with a message about an error because the restaurant doesn't exist in the system.
    */
    public String addProductForTest(String codeProduct, String nameProduct, String description, double cost, String nitRestaurant, double content, int amountOrdered) throws IOException {
        String message = "";
        Restaurant objSearch1 = searchRestaurant(nitRestaurant);
        if (objSearch1 == null)
            message = "The restaurant with NIT " + nitRestaurant + " isn't registered in the system.";
        else {
            Product objSearch2 = searchProductWithCodeAndNit(codeProduct, nitRestaurant);
            if (objSearch2 != null)
                message = "\nThis product already exists in the system for that restaurant.";
            else {
                Product obj = new Product(codeProduct, nameProduct, description, cost, nitRestaurant, content,
                        amountOrdered);
                products.add(obj);
                message = "\nSaving data...\nNew product successfully registered.";
            }
        }
        return message;
    }

    /**
     * Name: searchProductWithCodeAndNit
     * Method used to search a product that is offered by a specified restaurant. <br>
     * <b>pre: </b> List of products already initialized. <br>
     * <b>post: </b> Searching process determined of the product in question in the list of products registered in the system. <br>
     * @param codeProduct - Product code - codeProduct = String, codeProduct != null, codeProduct != ""
     * @param nitRestaurant - Restaurant NIT - nitRestaurant = String, nitRestaurant != null, nitRestaurant != ""
     * @return A Product object different from null if the product in question was found in the system, or with null if not.
    */
    public Product searchProductWithCodeAndNit(String codeProduct, String nitRestaurant) {
        Product objSearch = null;
        boolean findProduct = false;
        for (int i = 0; i < products.size() && !findProduct; i++) {
            if (products.get(i).getCodeProduct().equals(codeProduct) && products.get(i).getNitRestaurant().equals(nitRestaurant)) {
                objSearch = products.get(i);
                findProduct = true;
            }
        }
        return objSearch;
    }

    /**
     * Name: searchProductOnlyWithCode
     * Method used to search the existence of a product in the list of products of the system. <br>
     * <b>pre: </b> List of products already initialized. <br>
     * <b>post: </b> Searching process determined of the product in question in the list of products registered in the system. <br>
     * @param codeProduct - Product code - codeProduct = String, codeProduct != null, codeProduct != ""
     * @return A Product object different from null if the product in question was found in the system, or with null if not.
    */
    public Product searchProductOnlyWithCode(String codeProduct) {
        Product objSearch = null;
        boolean findProduct = false;
        for (int i = 0; i < products.size() && !findProduct; i++) {
            if (products.get(i).getCodeProduct().equals(codeProduct)) {
                objSearch = products.get(i);
                findProduct = true;
            }
        }
        return objSearch;
    }

    /**
     * Name: addClient
     * Method used to register/insert a client in an orderly way by its last name and its name, in the list of clients of the system. <br>
     * <b>pre: </b> List of clients already initialized. <br>
     * <b>post: </b> Registry process determined of the client in question in the list of clients of the system. <br>
     * @param typeDocument - Client document type - typeDocument = String, typeDocument != null, typeDocument != ""
     * @param idClient - Client ID number - idClient = String, idClient != null, idClient != ""
     * @param lastNameClient - Client last name - lastNameClient = String, lastNameClient != null, lastNameClient != ""
     * @param nameClient - Client name - nameClient = String, nameClient != null, nameClient != ""
     * @param phone - Client phone - phone = String, phone != null, phone != ""
     * @param address - Client address - address = String, address != null, address != ""
     * @throws IOException - if it cannot write the file properly while saving after adding a client.
     * @return A String with a message about the successful adding process of the client to the list of clients of the system; or, a String with a message about an error because the client already exists in the system.
    */
    public String addClient(String typeDocument, String idClient, String lastNameClient, String nameClient, String phone, String address) throws IOException {
        String message = "";
        if (clients.isEmpty()) {
            Client obj = new Client(typeDocument, idClient, lastNameClient, nameClient, phone, address);
            clients.add(obj);
            message = "\nNew client successfully registered.";
            saveDataClients();
        } else {
            Client objSearch = searchClient(idClient);
            if (objSearch != null)
                message = "\nThis client was already registered in the system.";
            else {
                Client obj = new Client(typeDocument, idClient, lastNameClient, nameClient, phone, address);
                boolean finish = false;
                for (int i = 0; i < clients.size() && !finish; i++) {
                    int result1 = obj.getLastNameClient().compareTo(clients.get(i).getLastNameClient());
                    if (result1 == 0) {
                        int result2 = obj.getNameClient().compareTo(clients.get(i).getNameClient());
                        if (result2 < 0) {
                            continue;
                        }
                        if (result2 > 0) {
                            clients.add(i, obj);
                            message = "\nSaving data...\nNew client successfully registered.";
                            saveDataClients();
                            finish = true;
                        }
                    } else if (result1 < 0)
                        continue;
                    else if (result1 > 0) {
                        clients.add(i, obj);
                        message = "\nSaving data...\nNew client successfully registered.";
                        saveDataClients();
                        finish = true;
                    }
                }
                if (finish == false) {
                    clients.add(obj);
                    message = "\nSaving data...\nNew client successfully registered.";
                    saveDataClients();
                }
            }
        }
        return message;
    }

    /**
     * Name: searchClient
     * Method used to search a client in the list of clients of the system. <br>
     * <b>pre: </b> List of client already initialized. <br>
     * <b>post: </b> Searching process determined of the client in question in the list of clients registered in the system. <br>
     * @param idClient - Client ID number - idClient = String, idClient != null, idClient != ""
     * @return A Client object different from null if the client in question was found in the system, or with null if not.
    */
    public Client searchClient(String idClient) {
        Client objSearch = null;
        boolean findClient = false;
        for (int i = 0; i < clients.size() && !findClient; i++) {
            if (clients.get(i) != null) {
                if (clients.get(i).getIdClient().equals(idClient)) {
                    objSearch = clients.get(i);
                    findClient = true;
                }
            }
        }
        return objSearch;
    }

    /**
     * Name: searchFastlyAClient
     * Method used to search efficiently a client with his/her in the list of clients of the system, through binary search. <br>
     * <b>pre: </b> List of clients already initialized. <br>
     * <b>post: </b> Searching process determined of the client in question in the list of clients registered in the system, and the search time is given. <br>
     * @param nameClient - Client name - nameClient = String, nameClient != null, nameClient != ""
     * @throws InterruptedException - when a thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted, either before or during the activity.
     * @return A String with a message saying that the client was found, and the time the system took to find him/her; or, a String with a message saying that the client wasn't found in the list of clients of the system.
    */
    public String searchFastlyAClient(String nameClient) throws InterruptedException {
        String message = "";
        if (clients.isEmpty())
            message = "There are no clients registered in the system to search one.";
        else {
            List<Client> copyClients = new ArrayList<Client>(clients);
            Collections.sort(copyClients, new Comparator<Client>() {
    
                @Override
                public int compare(Client client1, Client client2) {
                    return client1.getNameClient().compareTo(client2.getNameClient());
                }
            });
            boolean finish = false;
            int start1 = 0;
            int end1 = copyClients.size() - 1;
            while (start1 <= end1 && !finish) {
                int medium = (start1 + end1) / 2;
                if (copyClients.get(medium).getNameClient().equals(nameClient)) {
                    message = "\nClient found in the list of clients.\n";
                    long start2 = System.currentTimeMillis();
                    Thread.sleep(2000);
                    long end2 = System.currentTimeMillis();
                    double time = (double) ((end2 - start2) / 1000);
                    message += "Time it took to find him/her: " + time + " milliseconds.";
                    finish = true;
                } else if (copyClients.get(medium).getNameClient().compareTo(nameClient) > 0)
                    end1 = medium - 1;
                else
                    start1 = medium + 1;
            }
            if (finish == false)
                message = "\nClient not found in the list of clients.\n";
        }
        return message;
    }

    /**
     * Name: addOrder
     * Method used to register an order in the list of orders of the system. <br>
     * <b>pre: </b> List of orders already initialized; list of restaurants already initialized with at least one restaurant registered; list of products already initialized with at least one product registered; list of clients already initialized with at least one client registered. <br>
     * <b>post: </b> Registry process determined of the order in question in the list of orders of the system. <br>
     * @param codeOrder - Order code - codeOrder = int, codeOrder != null, codeOrder != 0
     * @param dateTime - Date and time of order creation - dateTime = Date, dateTime != null
     * @param idClient - Client ID number - idClient = String, idClient != null, idClient != ""
     * @param nitRestaurant - Restaurant NIT - nitRestaurant = String, nitRestaurant != null, nitRestaurant != ""
     * @param status - Order status - status = String, status != null, status != ""
     * @param productsOrdered - List of products from the order - productsOrdered = List<Product>, productsOrdered != null
     * @throws IOException - if it cannot write the file properly while saving after adding an order.
     * @return A String with a message about the successful adding process of the order to the list of orders of the system; or, a String with a message about an error because the order already exists in the system.
    */
    public String addOrder(int codeOrder, Date dateTime, String idClient, String nitRestaurant, String status, List<Product> productsOrdered) throws IOException {
        String message = "";
        Order obj = new Order(codeOrder, dateTime, idClient, nitRestaurant, status, productsOrdered);
        orders.add(obj);
        message = "\nSaving data...\n\nOrder successfully registered.\n";
        saveDataOrders();
        return message;
    }

    
    /**
     * Name: searchOrder
     * Method used to search an order in the list of orders of the system. <br>
     * <b>pre: </b> List of orders already initialized. <br>
     * <b>post: </b> Searching process determined of the order in question in the list of orders registered in the system. <br>
     * @param codeOrder - Order code - codeOrder = int, codeOrder != null, codeOrder != 0
     * @return An Order object different from null if the order in question was coincidentally found in the system (even if it's a randomly generated code), or with null if not.
    */
    public Order searchOrder(int codeOrder) {
        Order objSearch = null;
        boolean findOrder = false;
        for (int i = 0; i < orders.size() && !findOrder; i++) {
            if (orders.get(i) != null) {
                if (orders.get(i).getCodeOrder() == codeOrder) {
                    objSearch = orders.get(i);
                    findOrder = true;
                }
            }
        }
        return objSearch;
    }

    /**
     * Name: setDataRestaurant
     * Method used to update the data from a restaurant registered in the list of restaurants of the system. <br>
     * <b>pre: </b> List of restaurants already initialized with at least one restaurant registered. <br>
     * <b>post: </b> Updating process determined of the data from the restaurant in question registered in the list of restaurants of the system. <br>
     * @param nitRestaurant - restaurant NIT - nitRestaurant = String, nitRestaurant != null, nitRestaurant != ""
     * @param attribute - The specified attribute to be changed of the restaurant in question - attribute = int, attribute != null, attribute is a number from 1 to 4.
     * @param newValue - The new value that the String attribute to change will take - newValue = String, newValue != null, newValue != ""
     * @throws IOException - if it cannot write the file properly while saving after updating an information from a restaurant.
     * @return A String with a message about the successful updating process of the data from the restaurant registered in the list of restaurants of the system.
    */
    public String setDataRestaurant(String nitRestaurant, int attribute, String newValue) throws IOException {
        String message = "";
        if (attribute == 1) {
            for (int i = 0; i < restaurants.size(); i++) {
                if (restaurants.get(i).getNitRestaurant().equals(nitRestaurant)) {
                    restaurants.get(i).setNameRestaurant(newValue);
                    message = "\nSaving data...\nRestaurant's name successfully updated.";
                }
            }
        } else if (attribute == 2) {
            for (int i = 0; i < restaurants.size(); i++) {
                if (restaurants.get(i).getNitRestaurant().equals(nitRestaurant)) {
                    restaurants.get(i).setNitRestaurant(newValue);
                    message = "\nSaving data...\nRestaurant's NIT successfully updated.";
                }
            }
        } else if (attribute == 3) {
            for (int i = 0; i < restaurants.size(); i++) {
                if (restaurants.get(i).getNitRestaurant().equals(nitRestaurant)) {
                    restaurants.get(i).setNameCeo(newValue);
                    message = "\nSaving data...\nRestaurant administrator name successfully updated.";
                }
            }
        } else if (attribute == 4) {
            for (int i = 0; i < restaurants.size(); i++) {
                if (restaurants.get(i).getNitRestaurant().equals(nitRestaurant)) {
                    restaurants.get(i).setOperator(newValue);
                    message = "\nSaving data...\nRestaurant operator name successfully updated.";
                }
            }
        }
        saveDataRestaurants();
        return message;
    }

    /**
     * Name: setDataProduct
     * Method used to update the data from a product registered in the list of products of the system. <br>
     * <b>pre: </b> List of products already initialized with at least one product registered. <br>
     * <b>post: </b> Updating process determined of the data from the product in question registered in the list of products of the system. <br>
     * @param codeProduct - Product code - codeProduct = String, codeProduct != null, codeProduct != ""
     * @param attribute - The specified attribute to be changed of the product in question - attribute = int, attribute != null, attribute is a number from 1 to 6.
     * @param newValue1 - Variable to be used for new String values from the String attributes of the product - newValue1 = String, newValue1 != null, newValue1 != ""
     *  @param newValue2 - Variable to be used for new double values from the double attributes of the product - newValue2 = String, newValue2 != null, newValue2 != ""
     * @throws IOException - if it cannot write the file properly while saving after updating an information from a product.
     * @return A String with a message about the successful updating process of the data from the product registered in the list of products of the system.
    */
    public String setDataProduct(String codeProduct, int attribute, String newValue1, double newValue2) throws IOException {
        String message = "";
        if (attribute == 1) {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getCodeProduct().equals(codeProduct)) {
                    products.get(i).setCodeProduct(newValue1);
                    message = "\nProduct code successfully updated.";
                }
            }
        } else if (attribute == 2) {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getCodeProduct().equals(codeProduct)) {
                    products.get(i).setNameProduct(newValue1);
                    message = "\nProduct's code successfully updated.";
                }
            }
        } else if (attribute == 3) {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getCodeProduct().equals(codeProduct)) {
                    products.get(i).setDescription(newValue1);
                    message = "\nSaving data...\nProduct description successfully updated.";
                }
            }
        } else if (attribute == 4) {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getCodeProduct().equals(codeProduct)) {
                    products.get(i).setCost(newValue2);
                    message = "\nSaving data...\nProduct cost successfully updated.";
                }
            }
        } else if (attribute == 5) {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getCodeProduct().equals(codeProduct)) {
                    products.get(i).setNitRestaurant(newValue1);
                    message = "\nSaving data...\nNIT of the restaurant owner of the product successfully updated.";
                }
            }
        } else if (attribute == 6) {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getCodeProduct().equals(codeProduct)) {
                    products.get(i).setContent(newValue2);
                    message = "\nSaving data...\nProduct content successfully updated.";
                }
            }
        }
        saveDataProducts();
        return message;
    }

    /**
     * Name: setDataClient
     * Method used to update the data from a client registered in the list of clients of the system. <br>
     * <b>pre: </b> List of clients already initialized with at least one client registered. <br>
     * <b>post: </b> Updating process determined of the data from the client in question registered in the list of clients of the system. <br>
     * @param idClient - Client ID number - idClient = String, idClient != null, idClient != ""
     * @param attribute - The specified attribute to be changed of the client in question - attribute = int, attribute != null, attribute is a number from 1 to 6.
     * @param newValue - The new value that the String attribute to change will take - newValue = String, newValue != null, newValue != ""
     * @throws IOException - if it cannot write the file properly while saving after updating an information from a client.
     * @throws NonLogicalDocumentTypeException - if the new value chosen to update the document type attribute from a client isn't logical.
     * @return A String with a message about the successful updating process of the data from the client registered in the list of clients of the system.
    */
    public String setDataClient(String idClient, int attribute, String newValue) throws IOException, NonLogicalDocumentTypeException {
        String message = "";
        if (attribute == 1) {
            for (int i = 0; i < clients.size(); i++) {
                if (clients.get(i).getIdClient().equals(idClient)) {
                    if (newValue.equals(Client.DocumentType.IDENTITY_CARD.name())
                            && orders.get(i).getStatus().equals(Client.DocumentType.IDENTITY_CARD.name())) {
                        message = "Error. This client has already IDENTITY CARD as document type.";
                        throw new NonLogicalDocumentTypeException(message);
                    } else if (newValue.equals(Client.DocumentType.CITIZENSHIP_CARD.name())
                            && orders.get(i).getStatus().equals(Client.DocumentType.CITIZENSHIP_CARD.name())) {
                        message = "Error. This client has already CITIZENSHIP CARD as document type.";
                        throw new NonLogicalDocumentTypeException(message);
                    } else if (newValue.equals(Client.DocumentType.PASSPORT.name())
                            && orders.get(i).getStatus().equals(Client.DocumentType.PASSPORT.name())) {
                        message = "Error. This client has already PASSPORT as document type.";
                        throw new NonLogicalDocumentTypeException(message);
                    } else if (newValue.equals(Client.DocumentType.FOREIGNER_CARD.name())
                            && orders.get(i).getStatus().equals(Client.DocumentType.FOREIGNER_CARD.name())) {
                        message = "Error. This client has already FOREIGNER CARD as document type.";
                        throw new NonLogicalDocumentTypeException(message);
                    } else {
                        if (orders.get(i).getStatus().equals(Client.DocumentType.CITIZENSHIP_CARD.name())
                                && (newValue.equals(Client.DocumentType.FOREIGNER_CARD.name())
                                        || newValue.equals(Client.DocumentType.IDENTITY_CARD.name()))) {
                            message = "Error. You may have one of this problems:\n(1) Error. A client can't be a foreigner if it is already a citizen.\n(2) Error. A client can't be a minor if it is already an adult.";
                            throw new NonLogicalDocumentTypeException(message);
                        } else if (orders.get(i).getStatus().equals(Client.DocumentType.IDENTITY_CARD.name())
                                && newValue.equals(Client.DocumentType.FOREIGNER_CARD.name())) {
                            message = "Error. A client can't be a foreigner if it is already a minor citizen.\n";
                            throw new NonLogicalDocumentTypeException(message);
                        } else {
                            clients.get(i).setTypeDocument(newValue);
                            message = "\nSaving data...\nClient's document type successfully updated.";
                            saveDataClients();
                        }
                    }
                }
            }
        } else if (attribute == 2) {
            for (int i = 0; i < clients.size(); i++) {
                if (clients.get(i).getIdClient().equals(idClient)) {
                    clients.get(i).setIdClient(newValue);
                    message = "\nSaving data...\nClient's ID successfully updated.";
                    saveDataClients();
                }
            }
        } else if (attribute == 3) {
            for (int i = 0; i < clients.size(); i++) {
                if (clients.get(i).getIdClient().equals(idClient)) {
                    clients.get(i).setLastNameClient(newValue);
                    message = "\nSaving data...\nClient's last name successfully updated.";
                    saveDataClients();
                }
            }
        } else if (attribute == 4) {
            for (int i = 0; i < clients.size(); i++) {
                if (clients.get(i).getIdClient().equals(idClient)) {
                    clients.get(i).setNameClient(newValue);
                    message = "\nSaving data...\nClient's name successfully updated.";
                    saveDataClients();
                }
            }
        } else if (attribute == 5) {
            for (int i = 0; i < clients.size(); i++) {
                if (clients.get(i).getIdClient().equals(idClient)) {
                    clients.get(i).setPhone(newValue);
                    message = "\nClient's phone number successfully updated.";
                    saveDataClients();
                }
            }
        } else if (attribute == 6) {
            for (int i = 0; i < clients.size(); i++) {
                if (clients.get(i).getIdClient().equals(idClient)) {
                    clients.get(i).setAddress(newValue);
                    message = "\nClient's address successfully updated.";
                    saveDataClients();
                }
            }
        }
        return message;
    }

    /**
     * Name: setDataOrder
     * Method used to update the data from an order registered in the list of orders of the system. <br>
     * <b>pre: </b> List of orders already initialized with at least one order registered. <br>
     * <b>post: </b> Updating process determined of the data from the order in question registered in the list of orders of the system. <br>
     * @param codeOrder - Order code - codeOrder = String, codeOrder != null, codeOrder != ""
     * @param attribute - The specified attribute to be changed of the order in question - attribute = int, attribute != null, attribute is a number from 1 to 4.
     * @param newValue - The new value that the Client ID number and the Restaurant NIT both will take - newValue = String, newValue != null, newValue != ""
     * @param newStatus - The new value that the status attribute of an order will take - newStatus = String, newStatus != null, newStatus != ""
     * @param codeProduct - Product code - codeProduct = String, codeProduct != null, codeProduct != ""
     * @param action - The specified chosen action to do when updating the list of products from the order - action = int, action != null, action is a number from 1 to 2.
     * @param amountOrdered - Ordered units of a product - amountOrdered = int, amountOrdered != null, amountOrdered != 0
     * @param searchNit - Restaurant NIT - searchNit = String, searchNit != null, searchNit != ""
     * @param removeAction - The specified chosen action to do when removing a product from the list of products of the order - removeAction = int, removeAction != null, removeAction is a number from 1 to 2.
     * @param amountToRemove - Units to remove from a product present in the list of products from an order - amountToRemove = int, amountToRemove != null
     * @throws IOException - if it cannot write the file properly while saving after updating an information from an order.
     * @throws NonLogicalStatusException - if the new value chosen to update the status attribute from an order isn't logical.
     * @return A String with a message about the successful updating process of the data from the order registered in the list of orders of the system.
    */
    public String setDataOrder(int codeOrder, int attribute, String newValue, String newStatus, String codeProduct, int action, int amountOrdered, String searchNit, int removeAction, int amountToRemove) throws NonLogicalStatusException, IOException {
        String message = "";
        if (attribute == 1) {
            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i).getCodeOrder() == codeOrder) {
                    orders.get(i).setIdClient(newValue);
                    message = "\nOrder's ID successfully updated.";
                    saveDataOrders();
                }
            }
        } else if (attribute == 2) {
            for (int i = 0; i < orders.size(); i++) {
                if (orders.get(i).getCodeOrder() == codeOrder) {
                    orders.get(i).setNitRestaurant(newStatus);
                    message = "\nNIT of the restaurant chosen successfully updated.";
                    saveDataOrders();
                }
            }
        } else if (attribute == 3) {
            boolean finish = false;
            for (int i = 0; i < orders.size() && !finish; i++) {
                if (orders.get(i).getCodeOrder() == codeOrder) {
                    if (newStatus.equals(Order.OrderStatus.REQUESTED.name())
                            && orders.get(i).getStatus().equals(Order.OrderStatus.REQUESTED.name())) {
                        message = "Error. This order has already a REQUESTED status.";
                        throw new NonLogicalStatusException(message);
                    } else if (newStatus.equals(Order.OrderStatus.IN_PROCESS.name())
                            && orders.get(i).getStatus().equals(Order.OrderStatus.IN_PROCESS.name())) {
                        message = "Error. This order has already an IN PROCESS status.";
                        throw new NonLogicalStatusException(message);
                    } else if (newStatus.equals(Order.OrderStatus.SENT.name())
                            && orders.get(i).getStatus().equals(Order.OrderStatus.SENT.name())) {
                        message = "Error. This order has already a SENT status.";
                        throw new NonLogicalStatusException(message);
                    } else if (newStatus.equals(Order.OrderStatus.DELIVERED.name())
                            && orders.get(i).getStatus().equals(Order.OrderStatus.DELIVERED.name())) {
                        message = "Error. This order has already a DELIVERED status.";
                        throw new NonLogicalStatusException(message);
                    } else {
                        if (orders.get(i).getStatus().equals(Order.OrderStatus.IN_PROCESS.name())
                                && newStatus.equals(Order.OrderStatus.REQUESTED.name())) {
                            message = "Error. This order can't pass from an IN PROCESS status to a REQUESTED status.";
                            throw new NonLogicalStatusException(message);
                        } else if (orders.get(i).getStatus().equals(Order.OrderStatus.SENT.name())
                                && (newStatus.equals(Order.OrderStatus.REQUESTED.name())
                                        || newStatus.equals(Order.OrderStatus.IN_PROCESS.name()))) {
                            message = "Error. You may have one of this problems:\n(1) Error. This order can't pass from a SENT status to an IN PROCESS status.\n(2) Error. This order can't pass from a SENT status to a REQUESTED status.";
                            throw new NonLogicalStatusException(message);
                        } else if (orders.get(i).getStatus().equals(Order.OrderStatus.DELIVERED.name())
                                && (newStatus.equals(Order.OrderStatus.REQUESTED.name())
                                        || newStatus.equals(Order.OrderStatus.IN_PROCESS.name())
                                        || newStatus.equals(Order.OrderStatus.SENT.name()))) {
                            message = "Error. You may have one of this problems:\n(1) Error. This order can't pass from a DELIVERED status to a SENT status.\n(2) Error. This order can't pass from a DELIVERED status to an IN PROCESS status.\n(3) Error. This order can't pass from a DELIVERED status to a REQUESTED status.\n";
                            throw new NonLogicalStatusException(message);
                        } else {
                            orders.get(i).setStatus(newStatus);
                            message = "\nOrder's status successfully updated.";
                            saveDataOrders();
                        }
                    }
                }
            }
        } else if (attribute == 4) {
            if (action == 1) {
                message = addProductsInOrder(codeProduct, codeOrder, amountOrdered, searchNit);
                saveDataOrders();
            } else if (action == 2) {
                message = removeProductFromOrder(codeProduct, codeOrder, removeAction, amountToRemove);
                saveDataOrders();
            }
        }
        return message;
    }

    /**
     * Name: addProductsInOrder
     * Method used to register a product in the list of products from an order. <br>
     * <b>pre: </b> List of products from the order already exists and at least one product was registered before in this list. <br>
     * <b>post: </b> Registry process determined of the product in question in the list of products from the order. <br>
     * @param codeProduct - Product code - codeProduct = String, codeProduct != null, codeProduct != ""
     * @param codeOrder - Order code - codeOrder = String, codeOrder != null, codeOrder != ""
     * @param searchNit - Restaurant NIT - searchNit = String, searchNit != null, searchNit != ""
     * @param amountOrdered - Ordered units of a product - amountOrdered = int, amountOrdered != null, amountOrdered != 0
     * @return A String with a message about the successful adding process of the product to the list of products from the order; or, a String with a message about an error because the product doesn't exist in the system OR it isn't offered by the specified chosen restaurant.
    */
    public String addProductsInOrder(String codeProduct, int codeOrder, int amountOrdered, String searchNit) {
        String message = "";
        Product objsearch1 = searchProductInOrder(codeProduct, codeOrder);
        if (objsearch1 != null) {
            Product copyProduct = objsearch1;
            copyProduct.setAmountOrdered(copyProduct.getAmountOrdered() + amountOrdered);
            message = "\nThe client is now ordering " + copyProduct.getAmountOrdered() + " units of the product with code " + codeProduct;
        } else {
            Product objsearch2 = searchProductWithCodeAndNit(codeProduct, searchNit);
            if (objsearch2 != null) {
                for (int i = 0; i < orders.size(); i++) {
                    if (orders.get(i) != null) {
                        if (orders.get(i).getCodeOrder() == codeOrder) {
                            Product copyProduct = objsearch2;
                            orders.get(i).getProducts().add(copyProduct);
                            copyProduct.setAmountOrdered(copyProduct.getAmountOrdered() + amountOrdered);
                            message = "\nThe product with code " + codeProduct + " has been added to the products list from the order with code " + codeOrder;
                        }
                    }
                }
            } else
                message = "This product doesn't exist in the system, OR it isn't offered by the specified restaurant. Register it.";
        }
        return message;
    }

    /**
     * Name: searchProductInOrder
     * Method used to search the existence of a product in the list of products from an order. <br>
     * <b>pre: </b> List of products from the order already exists and at least one product was registered before in this list. <br>
     * <b>post: </b> Searching process determined of the product in question in the list of products from the order. <br>
     * @param codeProduct - Product code - codeProduct = String, codeProduct != null, codeProduct != ""
     * @param codeOrder - Order code - codeOrder = String, codeOrder != null, codeOrder != ""
     * @return A Product object different from null if the product in question was found in the list of products from the order, or with null if not.
    */
    public Product searchProductInOrder(String codeProduct, int codeOrder) {
        Product objSearch = null;
        boolean findProduct = false;
        for (int i = 0; i < orders.size() && !findProduct; i++) {
            if (orders.get(i) != null) {
                if (orders.get(i).getCodeOrder() == codeOrder) {
                    for (int j = 0; j < orders.get(i).getProducts().size(); j++) {
                        if (orders.get(i).getProducts().get(j) != null) {
                            if (orders.get(i).getProducts().get(j).getCodeProduct().equals(codeProduct)) {
                                objSearch = orders.get(i).getProducts().get(j);
                                findProduct = true;
                            }
                        }
                    }
                }
            }
        }
        return objSearch;
    }

    /**
     * Name: removeProductFromOrder
     * Method used to remove a product from the list of products of an order. <br>
     * <b>pre: </b> List of products from the order already exists and at least one product was registered before in this list. <br>
     * <b>post: </b> Removing process determined of the product in question from the list of products of the order. <br>
     * @param codeProduct - Product code - codeProduct = String, codeProduct != null, codeProduct != ""
     * @param codeOrder - Order code - codeOrder = String, codeOrder != null, codeOrder != ""
     * @param removeAction - The specified chosen action to do when removing a product from the list of products of the order - removeAction = int, removeAction != null, removeAction is a number from 1 to 2.
     * @param amountToRemove - Units to remove from a product present in the list of products from an order - amountToRemove = int, amountToRemove != null
     * @return A String with a message about the successful removing process of the product from the list of products of the order; and, if it was the unique product present in this list, also with a message about the removing process of this order due to absence of products in its list of products.
    */
    public String removeProductFromOrder(String codeProduct, int codeOrder, int removeAction, int amountToRemove) {
        String message = "";
        boolean done = false;
        Product objsearch = searchProductInOrder(codeProduct, codeOrder);
        if (objsearch != null) {
            for (int i = 0; i < orders.size() && !done; i++) {
                if (orders.get(i) != null) {
                    if (orders.get(i).getCodeOrder() == codeOrder) {
                        for (int j = 0; j < orders.get(i).getProducts().size() && !done; j++) {
                            if (orders.get(i).getProducts().get(j) != null) {
                                if (orders.get(i).getProducts().get(j).getCodeProduct().equals(codeProduct)) {
                                    if (removeAction == 1){
                                        orders.get(i).getProducts().remove(j);
                                        message += "\nThe product with code " + codeProduct + " has been done from the products list from the order with code " + codeOrder;
                                        done = true;
                                    }
                                    else if (removeAction == 2) {
                                        if (amountToRemove > objsearch.getAmountOrdered()) {
                                            message = "\nThe number of units you want to remove is greater than the actual number of units ordered from the product.\n";
                                            done = true;
                                        }
                                        else {
                                            Product copy = objsearch; 
                                            copy.setAmountOrdered(copy.getAmountOrdered() - amountToRemove);
                                            message = "\nThe client is now ordering " + copy.getAmountOrdered() + " units of the product with code " + codeProduct + ", from the order " + codeOrder;
                                            done = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (removeAction == 1) {
                        if (orders.get(i).getProducts().isEmpty()) {
                            orders.remove(i);
                            message += "As this product was the unique one present in the list of products from this order, this order was also done from the system.";
                            done = true;
                        }
                    }
                }
            }
        }
        return message;
    }

    /**
     * Name: importData
     * Method used to import external data from restaurants, products, clients or orders. <br>
     * <b>pre: </b> List of orders already initialized; list of restaurants already initialized; list of products already initialized; list of clients already initialized. <br>
     * <b>post: </b> Importing process determined of the external data from restaurants, products, clients or orders. <br>
     * @param fileName - File name from the external data in question that will be read - fileName = String, fileName != null, fileName != ""
     * @param data - Variable to specify what is it going to be imported - data = int, data != null, data is a number from 1 to 4.
     * @throws IOException - if it cannot write a file properly while saving after importing and then adding a restaurant, a product, a client or an order.
     * @throws ParseException - signals that an error has been reached unexpectedly while parsing.
    */
    public String importData(String fileName, int data) throws IOException, ParseException {
        String message = "";
        if (data == 1) {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split(SEPARATOR);
                Restaurant objsearch = searchRestaurant(parts[1]);
                if (objsearch != null)
                    message = "The restaurant with NIT " + parts[1] + " was already registered in the system.";
                else {
                    addRestaurant(parts[0], parts[1], parts[2], parts[3]);
                    line = br.readLine();
                }
            }
            br.close();
        } else if (data == 2) {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split(SEPARATOR);
                Client objsearch = searchClient(parts[1]);
                if (objsearch != null)
                    message = "The client with ID " + parts[1] + " was already registered in the system.";
                else {
                    addClient(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
                    line = br.readLine();
                }
            }
            br.close();
        } else if (data == 3) {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split(SEPARATOR);
                double cost = Double.parseDouble(parts[3]);
                double content = Double.parseDouble(parts[5]);
                int amountOrdered = Integer.parseInt(parts[6]);
                Restaurant objsearch1 = searchRestaurant(parts[4]);
                if (objsearch1 == null) {
                    addRestaurant(parts[7], parts[4], parts[8], parts[9]);
                    addProduct(parts[0], parts[1], parts[2], cost, parts[4], content, amountOrdered);
                    line = br.readLine();
                } else {
                    Product objSearch2 = searchProductWithCodeAndNit(parts[0], parts[4]);
                    if (objSearch2 != null)
                        message = "\nThe product with code " + parts[0]
                                + " already exists in the system for the restaurant with NIT " + parts[4];
                    else {
                        addProduct(parts[0], parts[1], parts[2], cost, parts[4], content, amountOrdered);
                        line = br.readLine();
                    }
                }
            }
            br.close();
        } else if (data == 4) {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            List<Product> productsOrdered = new ArrayList<Product>();
            String[] parts = line.split(SEPARATOR);
            String comparatorOrders = parts[0];
            while (line != null) {
                // codeOrder 0; dateTime 1; status 2; nameRestaurant 3; nitRestaurant 4; nameCeo 5; operator 6; typeDocument 7; idClient 8; lastNameClient 9; nameClient 10; phone 11; address 12; codeProduct 13; nameProduct 14; description 15; cost 16; content 17; amountOrdered 18;
                parts = line.split(SEPARATOR);
                if (comparatorOrders.equals(parts[0])) {
                    int codeOrder = Integer.parseInt(parts[0]);
                    SimpleDateFormat format = new SimpleDateFormat();
                    Date dateTime = format.parse(parts[1]);
                    double cost = Double.parseDouble(parts[16]);
                    double content = Double.parseDouble(parts[17]);
                    int amountOrdered = Integer.parseInt(parts[18]);
                    Restaurant objsearch1 = searchRestaurant(parts[4]);
                    if (objsearch1 == null) {
                        message = "\nThe restaurant with NIT " + parts[4] + " wasn't registered in the system, so it will be registered now.\n";
                        addRestaurant(parts[3], parts[4], parts[5], parts[6]);
                        addProduct(parts[13], parts[14], parts[15], cost, parts[4], content, amountOrdered);
                        Client objsearch2 = searchClient(parts[8]);
                        if (objsearch2 == null) {
                            message = "The client with ID " + parts[8] + " wasn't already registered in the system, so it will be registered now.";
                            addClient(parts[7], parts[8], parts[9], parts[10], parts[11], parts[12]);
                            Product obj = new Product(parts[13], parts[14], parts[15], cost, parts[4], content, amountOrdered);
                            productsOrdered.add(obj);
                            line = br.readLine();
                        } else {
                            Product obj = new Product(parts[13], parts[14], parts[15], cost, parts[4], content, amountOrdered);
                            productsOrdered.add(obj);
                            addOrder(codeOrder, dateTime, parts[8], parts[4], parts[2], productsOrdered);
                            line = br.readLine();
                        }
                    } else {
                        Product objSearch3 = searchProductWithCodeAndNit(parts[13], parts[4]);
                        if (objSearch3 != null) {
                            Client objsearch2 = searchClient(parts[8]);
                            if (objsearch2 == null) {
                                message = "The client with ID " + parts[8] + " wasn't already registered in the system, so it will be registered now.";
                                addClient(parts[7], parts[8], parts[9], parts[10], parts[11], parts[12]);
                                Product obj = new Product(parts[13], parts[14], parts[15], cost, parts[4], content, amountOrdered);
                                productsOrdered.add(obj);
                                addOrder(codeOrder, dateTime, parts[8], parts[4], parts[2], productsOrdered);
                                line = br.readLine();
                            } else {
                                Product obj = new Product(parts[13], parts[14], parts[15], cost, parts[4], content, amountOrdered);
                                productsOrdered.add(obj);
                                addOrder(codeOrder, dateTime, parts[8], parts[4], parts[2], productsOrdered);
                                line = br.readLine();
                            }
                        } else {
                            message = "\nThe product with code " + parts[13] + " wasn't registered in the system for the restaurant with NIT " + parts[4] + ", so it will be registered now.";
                            addProduct(parts[13], parts[14], parts[15], cost, parts[4], content, amountOrdered);
                            Client objsearch2 = searchClient(parts[8]);
                            if (objsearch2 == null) {
                                message = "The client with ID " + parts[8] + " wasn't already registered in the system, so it will be registered now.";
                                addClient(parts[7], parts[8], parts[9], parts[10], parts[11], parts[12]);
                                Product obj = new Product(parts[13], parts[14], parts[15], cost, parts[4], content, amountOrdered);
                                productsOrdered.add(obj);
                                addOrder(codeOrder, dateTime, parts[8], parts[4], parts[2], productsOrdered);
                                line = br.readLine();
                            } else {
                                Product obj = new Product(parts[13], parts[14], parts[15], cost, parts[4], content, amountOrdered);
                                productsOrdered.add(obj);
                                addOrder(codeOrder, dateTime, parts[8], parts[4], parts[2], productsOrdered);
                                line = br.readLine();
                            }
                        }
                    }
                } else {
                    comparatorOrders = parts[0];
                }
            }
            br.close();
        }
        return message;
    }

    /**
     * Name: exportData
     * Method used to export the orders data registered in the system, besides all the correspondent data from the restaurant, the client and the products involved in the order. <br>
     * <b>pre: </b> List of orders already initialized with at least one product added to the list of products from the order; list of restaurants already initialized with at least one restaurant registered; list of products already initialized with at least one product registered; list of clients already initialized with at least one client registered. <br>
     * <b>post: </b> Exporting process determined of the registered orders in the list of orders from the system. <br>
     * @param fileName - File name where the data in question will be written - fileName = String, fileName != null, fileName != ""
     * @param separator - Separator used between the attributes in the file - separator = String, separator != null, separator != ""
     * @throws FileNotFoundException - when a file with the specified pathname doesn't exist.
    */
    public void exportData(String fileName, String separator) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(fileName);
        Collections.sort(orders);
        pw.println("Order code" + separator + "Date and time of the order" + separator + "Order Status" + separator + "Restaurant name" + separator + "Restaurant NIT" + separator + "Restaurant administrator name" + separator + "Restaurant operator name" + separator + "Document type" + separator + "Client ID" + separator + "Client last name" + separator + "Client name" + separator + "Client phone" + separator + "Client address" + separator + "Product code" + separator + "Product name" + separator + "Product description" + separator + "Product cost" + separator + "Product content" + separator + "Ordered amount of the product");
        for (int i = 0; i < orders.size(); i++) {
            for (int k=0; k<restaurants.size(); k++) {
                if (orders.get(i).getNitRestaurant().equals(restaurants.get(k).getNitRestaurant())) {
                    String infoRestaurant = restaurants.get(k).getNameRestaurant() + separator + restaurants.get(k).getNitRestaurant() + separator + restaurants.get(k).getNameCeo() + separator + restaurants.get(k).getOperator();
                    for (int l=0; l<clients.size(); l++){
                        if (orders.get(i).getIdClient().equals(clients.get(l).getIdClient())) {
                            String infoClient = clients.get(l).getTypeDocument() + separator + clients.get(l).getIdClient() + separator + clients.get(l).getLastNameClient() + separator + clients.get(l).getNameClient() + separator + clients.get(l).getPhone() + separator + clients.get(l).getAddress();
                            for (int j=0; j<orders.get(i).getProducts().size(); j++)
                                pw.println(orders.get(i).getCodeOrder() + separator + orders.get(i).getDateTime() + separator + orders.get(i).getStatus() + separator + infoRestaurant + separator + infoClient + separator + orders.get(i).getProducts().get(j).getProductInfoToExport());
                        }
                    }
                }
            }
        }
        pw.close();
    }

    /**
     * Name: saveDataRestaurants
     * Method used to serialize the list of restaurants of the system. <br>
     * <b>pre: </b> List of clients already initialized and a Restaurant object is added to this list or the information of this object is updated. <br>
     * <b>post: </b> List of restaurants serialized. <br>
     * @throws IOException - if it cannot write the file properly while saving.
    */
    public void saveDataRestaurants() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_RESTAURANTS_PATH_FILE));
        oos.writeObject(restaurants);
        oos.close();
    }

    /**
     * Name: saveDataProducts
     * Method used to serialize the list of products of the system. <br>
     * <b>pre: </b> List of products already initialized and a Product object is added to this list or the information of this object is updated. <br>
     * <b>post: </b> List of products serialized. <br>
     * @throws IOException - if it cannot write the file properly while saving.
    */
    public void saveDataProducts() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PRODUCTS_PATH_FILE));
        oos.writeObject(products);
        oos.close();
    }

    /**
     * Name: saveDataClients
     * Method used to serialize the list of clients of the system. <br>
     * <b>pre: </b> List of clients already initialized and a Client object is added to this list or the information of this object is updated. <br>
     * <b>post: </b> List of clients serialized. <br>
     * @throws IOException - if it cannot write the file properly while saving.
    */
    public void saveDataClients() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_CLIENTS_PATH_FILE));
        oos.writeObject(clients);
        oos.close();
    }

    /**
     * Name: saveDataOrders
     * Method used to serialize the list of orders of the system. <br>
     * <b>pre: </b> List of orders already initialized and an Order object is added to this list or the information of this object is updated. <br>
     * <b>post: </b> List of orders serialized. <br>
     * @throws IOException - if it cannot write the file properly while saving.
    */
    public void saveDataOrders() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_ORDERS_PATH_FILE));
        oos.writeObject(orders);
        oos.close();
    }

    /**
     * Name: loadData
     * Method used to deserialize all the saved data in the system. <br>
     * <b>post: </b> Loading process determined of all the saved data in the system. <br>
     * @throws ClassNotFoundException - if the program tries to load in a class through its String name but no definition for the class with the specified name could be found.
     * @throws IOException - if it cannot read the file properly while loading.
    */
    @SuppressWarnings("unchecked")
    public void loadData() throws ClassNotFoundException, IOException {
        System.out.println("\nLoading data...");
        File f1 = new File(SAVE_RESTAURANTS_PATH_FILE);
        if (f1.exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f1));
            restaurants = (List<Restaurant>) ois.readObject();
            ois.close();
        }
        else {
            System.out.println("\nRestaurants path file not found to load.");
        }
        File f2 = new File(SAVE_CLIENTS_PATH_FILE);
        if (f2.exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f2));
            clients = (List<Client>) ois.readObject();
            ois.close();
        }
        else {
            System.out.println("\nClients path file not found to load.");
        }
        File f3 = new File(SAVE_PRODUCTS_PATH_FILE);
        if (f3.exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f3));
            products = (List<Product>) ois.readObject();
            ois.close();
        }
        else {
            System.out.println("\nProducts path file not found to load.");
        }
        File f4 = new File(SAVE_ORDERS_PATH_FILE);
        if (f4.exists()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f4));
            orders = (List<Order>) ois.readObject();
            ois.close();
        }
        else {
            System.out.println("\nOrders path file not found to load.");
        }
    }
}