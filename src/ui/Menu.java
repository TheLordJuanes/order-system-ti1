/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Subject: Algorithms and Programming II
 * Integrative Task I
 * Student Code: A00365977
 * @Author: Juan Esteban Caicedo A.
 * @Date: September, 26th 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package ui;

import java.util.Scanner;
import exceptions.NonLogicalDocumentTypeException;
import exceptions.NonLogicalStatusException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import model.*;

public class Menu {

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    public final static String SEPARATOR = ",";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    public Scanner scanner = new Scanner(System.in);

    // -----------------------------------------------------------------
    // Relations
    // -----------------------------------------------------------------

    private AssociationRestaurant ar;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Name: Menu
     * Constructor method of a menu. <br>
    */
    public Menu() {
        String nameAssociation = "Restaurant Association®";
        try {
            ar = new AssociationRestaurant(nameAssociation);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: startMenu
     * Method used to show the menu. <br>
    */
    public void startMenu() {
        boolean menu = true;
        System.out.println("\n-----------------------");
        System.out.println(ar.getNameAssociation());
        System.out.println("-----------------------");
        while (menu) {
            System.out.println("\n**********");
            System.out.println("Start Menu");
            System.out.println("**********");
            System.out.println("\nChoose a module:\n");
            System.out.println("(1) Restaurants' module\n(2) Products' module\n(3) Clients' module\n(4) Orders' module\n(5) Persistence module\n(6) Exit menu\n");
            try {
                int module = Integer.parseInt(scanner.nextLine());
                int opt;
                switch (module) {
                    case 1:
                        System.out.println("\nType 1 to register a restaurant.\nType 2 to set the data of a restaurant.\nType 3 to show the registered restaurants by Ascending Name.\nType 4 to return to the modules menu.\n");
                        opt = Integer.parseInt(scanner.nextLine());
                        if (opt == 1) {
                            registerRestaurant();
                        } else if (opt == 2) {
                            setRestaurantData();
                        } else if (opt == 3) {
                            showRestaurantsByName();
                        }
                        break;
                    case 2:
                        System.out.println("\nType 1 to register a product in the system.\nType 2 to set the data of a product.\nType 3 to show the products list.\nType 4 to return to the modules menu.\n");
                        opt = Integer.parseInt(scanner.nextLine());
                        if (opt == 1) {
                            registerProduct();
                        } else if (opt == 2) {
                            setProductData();
                        } else if (opt == 3) {
                            showProducts();
                        }
                        break;
                    case 3:
                        System.out.println("\nType 1 to register a client.\nType 2 to set the data of a client.\nType 3 to show the registered clients by Descending Last Name and Name.\nType 4 to show the registered clients by Ascending Phone Number.\nType 5 to efficiently search for a client in the clients' list.\nType 6 to return to the modules menu.\n");
                        opt = Integer.parseInt(scanner.nextLine());
                        if (opt == 1) {
                            registerClient();
                        } else if (opt == 2) {
                            setClientData();
                        } else if (opt == 3) {
                            showClientsByLastNameAndName();
                        } else if (opt == 4) {
                            showClientsByPhone();
                        } else if (opt == 5) {
                            searchClientFastly();
                        }
                        break;
                    case 4:
                        System.out.println(
                                "\nType 1 to register a order.\nType 2 to set the data of an order.\nType 3 to show the orders list.\nType 4 to return to the modules menu.\n");
                        opt = Integer.parseInt(scanner.nextLine());
                        if (opt == 1) {
                            registerOrder();
                        } else if (opt == 2) {
                            setOrderData();
                        } else if (opt == 3) {
                            showOrders();
                        }
                        break;
                    case 5:
                        System.out.println("\nType 1 to import data from a file.\nType 2 to export data in a file.\nType 3 to return to the modules menu.\n");
                        opt = Integer.parseInt(scanner.nextLine());
                        if (opt == 1) {
                            toImportData();
                        } else if (opt == 2) {
                            toExportData();
                        }
                        break;
                    case 6:
                        menu = false;
                        System.out.print("\nLeaving the menu...\n\nEnd of menu.\nGoodbye!\n\n");
                        break;
                    default:
                        System.out.println("Option not available. Try again.");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("\nError! You must enter a whole number. Try again.");
            }
        }
    }

    /**
     * Name: toImportData
     * Method used to import external data from a text file (.csv), invoking the importData() method from the AssociationRestaurant class. <br>
    */
    public void toImportData() {
        System.out.println("What do you want to import?\n\n(1) Data from restaurants\n(2) Data from clients\n(3) Data from products\n(4) Data from orders\n");
        int data = Integer.parseInt(scanner.nextLine());
        System.out.print("\nFile Name to Import: ");
        String fileName = scanner.nextLine();
        if (data == 1) {
            try {
                String message = ar.importData(fileName, data);
                System.out.println(message);
                System.out.println("\nData from restaurants succesfully imported.\n");
            } catch (IOException ioe) {
                System.out.println("\nThe data can't be imported.\n");
                ioe.printStackTrace();
            } catch (ParseException pe) {
                pe.printStackTrace();
            }
        } else if (data == 2) {
            try {
                String message = ar.importData(fileName, data);
                System.out.println(message);
                System.out.println("\nData from clients succesfully imported.\n");
            } catch (IOException ioe) {
                System.out.println("\nThe data can't be imported.\n");
                ioe.printStackTrace();
            } catch (ParseException pe) {
                pe.printStackTrace();
            }
        } else if (data == 3) {
            try {
                String message = ar.importData(fileName, data);
                System.out.println(message);
                System.out.println("\nData from products succesfully imported.\n");
            } catch (IOException ioe) {
                System.out.println("\nThe data can't be imported.\n");
                ioe.printStackTrace();
            } catch (ParseException pe) {
                pe.printStackTrace();
            }
        } else if (data == 4) {
            try {
                String message = ar.importData(fileName, data);
                System.out.println(message);
                System.out.println("\nData from orders succesfully imported.\n");
            } catch (IOException ioe) {
                System.out.println("\nThe data can't be imported.\n");
                ioe.printStackTrace();
            } catch (ParseException pe) {
                pe.printStackTrace();
            }
        }
    }
    
    /**
     * Name: toExportData
     * Method used to export mainly the orders data from the system in a text file (.csv), besides all the correspondent data from the restaurant, the client and the products involved in the order, invoking the exportData() method from the AssociationRestaurant class. <br>
    */
    public void toExportData() {
        if (ar.getOrders().isEmpty())
            System.out.println("\nThere are no orders registered in the system to export their data.\n");
        else if (ar.getRestaurants().isEmpty())
            System.out.println("\nThere are no restaurants registered in the system to place an order to export then the data from this one and from the restaurant involved.\n");
        else if (ar.getClients().isEmpty())
            System.out.println("\nThere are no clients registered in the system to place an order to export then the data from this one and from the client involved.\n");
        else if (ar.getProducts().isEmpty())
            System.out.println("\nThere are no products registered in the system to place an order to export then the data from this one and from the product involved.\n");
        else {
            System.out.print("\nFile Name with the orders to Export: ");
            String fileName = scanner.nextLine();
            System.out.print("\nEnter the separator to be used between the attributes in the file: ");
            String separator = scanner.nextLine();
            try {
                ar.exportData(fileName, separator);
                System.out.println("\nOrders data succesfully exported.");
            } catch (FileNotFoundException fnfe) {
                System.out.println("Error trying to load data. The path file name doesn't exist.");
                fnfe.printStackTrace();
            }
        }
    }

    /**
     * Name: registerRestaurant
     * Method used to register a restaurant, invoking the addRestaurant() method from the AssociationRestaurant class. <br>
    */
    public void registerRestaurant() {
        System.out.print("Enter the restaurant's name: ");
        String nameRestaurant = scanner.nextLine().toUpperCase();
        System.out.print("Enter the restaurant's NIT: ");
        String nit = scanner.nextLine();
        System.out.print("Enter the restaurant administrator name: ");
        String nameCeo = scanner.nextLine().toUpperCase();
        System.out.print("Enter the restaurant operator name, in charge of entering information into the system: ");
        String operator = scanner.nextLine().toUpperCase();
        try {
            String message = ar.addRestaurant(nameRestaurant, nit, nameCeo, operator);
            System.out.println(message);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: showRestaurantsByName
     * Method used to show all the restaurants registered in the system, sorted in ascending order by their name. <br>
    */
    public void showRestaurantsByName() {
        if (ar.getRestaurants().isEmpty())
            System.out.println("There are no restaurants registered in the system to show their data.");
        else {
            // Bubble ascending sort:
            Restaurant aux;
            for (int i = 0; i < ar.getRestaurants().size() - 1; i++) {
                for (int j = 0; j < ar.getRestaurants().size() - i - 1; j++) {
                    if (ar.getRestaurants().get(j).getNameRestaurant().compareTo(ar.getRestaurants().get(j + 1).getNameRestaurant()) > 0) {
                        aux = ar.getRestaurants().get(j);
                        ar.getRestaurants().set(j, ar.getRestaurants().get(j + 1));
                        ar.getRestaurants().set(j + 1, aux);
                    }
                }
            }
            int x = 1;
            System.out.print("\nThese are the restaurants registered in the system:\n\n");
            for (Restaurant res : ar.getRestaurants()) {
                System.out.println("Restaurant " + x + ":\nRestaurant name" + SEPARATOR + "Restaurant NIT" + SEPARATOR + "Restaurant administrator name" + SEPARATOR + "Restaurant operator name\n" + res.toString() + "\n\n");
                x++;
            }
        }
    }

    /**
     * Name: registerProduct
     * Method used to register a product, invoking the addProduct() method from the AssociationRestaurant class. <br>
    */
    public void registerProduct() {
        if (ar.getRestaurants().isEmpty())
            System.out.println("There are no restaurants registered in the system to add a product from it.");
        else {
            System.out.print("Enter the product code: ");
            String codeProduct = scanner.nextLine();
            System.out.print("Enter the product's name: ");
            String nameProduct = scanner.nextLine();
            System.out.print("Enter the product's description: ");
            String description = scanner.nextLine();
            System.out.print("Enter the product's cost: ");
            double cost = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter the restaurant's NIT: ");
            String nitRestaurant = scanner.nextLine();
            int amountOrdered = 0;
            System.out.print("Net content of the product: ");
            double content = Double.parseDouble(scanner.nextLine());
            try {
                String message = ar.addProduct(codeProduct, nameProduct, description, cost, nitRestaurant, content, amountOrdered);
                System.out.println(message);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Name: showProducts
     * Method used to show all the products registered in the system. <br>
    */
    public void showProducts() {
        if (ar.getRestaurants().isEmpty())
            System.out.println("There are no restaurants registered in the system for them to offer a product to show it.");
        else if (ar.getProducts().isEmpty())
            System.out.println("There are no products registered in the system to show them.");
        else {
            int x = 1;
            System.out.print("\nThese are the products registered in the system:\n\n");
            for (Product prod : ar.getProducts()) {
                System.out.println("Product " + x + ":\nProduct code" + SEPARATOR + "Product name" + SEPARATOR + "Product cost" + SEPARATOR + "Product description" + SEPARATOR + "Product content" + SEPARATOR + "Restaurant owner NIT" + SEPARATOR + "Ordered amount\n" + prod.toString() + "\n\n");
                x++;
            }
        }
    }

    /**
     * Name: registerClient
     * Method used to register a client, invoking the addClient() method from the AssociationRestaurant class. <br>
    */
    public void registerClient() {
        System.out.print("\n(1) - Identity Card -\n(2) - Citizenship Card -\n(3) - Passport -\n(4) - Foreigner Card -\n\nDocument type of the person: ");
        int typeDoc = Integer.parseInt(scanner.nextLine());
        String typeDocument = "";
        if (typeDoc == 1) {
            Client.DocumentType dt = Client.DocumentType.IDENTITY_CARD;
            typeDocument = dt.name();
        } else if (typeDoc == 2) {
            Client.DocumentType dt = Client.DocumentType.CITIZENSHIP_CARD;
            typeDocument = dt.name();
        } else if (typeDoc == 3) {
            Client.DocumentType dt = Client.DocumentType.PASSPORT;
            typeDocument = dt.name();
        } else if (typeDoc == 4) {
            Client.DocumentType dt = Client.DocumentType.FOREIGNER_CARD;
            typeDocument = dt.name();
        }
        System.out.print("ID of the client: ");
        String idClient = scanner.nextLine();
        System.out.print("Last name of the client: ");
        String lastNameClient = scanner.nextLine().toUpperCase();
        System.out.print("Name of the client: ");
        String nameClient = scanner.nextLine().toUpperCase();
        System.out.print("Phone number of the client: ");
        String phone = scanner.nextLine();
        System.out.print("Address of the client: ");
        String address = scanner.nextLine();
        try {
            String message = ar.addClient(typeDocument, idClient, lastNameClient, nameClient, phone, address);
            System.out.println(message);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: showClientsByLastNameAndName
     * Method used to show all the clients registered in the system, sorted in descending order firstly by their last name and then by their name. <br>
    */
    public void showClientsByLastNameAndName() {
        if (ar.getClients().isEmpty())
            System.out.println("\nThere are no clients registered in the system to show their data.");
        else {
            int x = 1;
            System.out.print("\nThese are the clients registered in the system:\n\n");
            for (Client cl : ar.getClients()) {
                System.out.println("\nClient " + x + ":\nLast name" + SEPARATOR + "Name" + SEPARATOR + "Document type" + SEPARATOR + "ID number" + SEPARATOR + "Phone number" + SEPARATOR + "Address\n" + cl.toString() + "\n\n");
                x++;
            }
        }
    }

    /**
     * Name: showClientsByPhone
     * Method used to show all the clients registered in the system, sorted in descending order by their phone number. <br>
    */
    public void showClientsByPhone() {
        if (ar.getClients().isEmpty())
            System.out.println("\nThere are no clients registered in the system to show their data.");
        else {
            List<Client> clients2 = new ArrayList<Client>(ar.getClients());
            // Selection descending sort:
            for (int i = 0; i < clients2.size() - 1; i++) {
                int maxPosition = i;
                for (int j = i + 1; j < clients2.size(); j++) {
                    if (clients2.get(j).getPhone().compareTo(clients2.get(maxPosition).getPhone()) > 0) {
                        maxPosition = j;
                    }
                }
                if (maxPosition != i) {
                    Client aux = clients2.get(i);
                    clients2.set(i, clients2.get(maxPosition));
                    clients2.set(maxPosition, aux);
                }
            }
            int x = 1;
            System.out.print("\nThese are the clients registered in the system:\n\n");
            for (Client cl : clients2) {
                System.out.println("\nClient " + x + ":\nLast name" + SEPARATOR + "Name" + SEPARATOR + "Document type" + SEPARATOR + "ID number" + SEPARATOR + "Phone number" + SEPARATOR + "Address\n" + cl.toString() + "\n\n");
                x++;
            }
        }
    }

    /**
     * Name: searchClientFastly
     * Method used to search a client efficiently in the list of clients from the system, through binary search, invoking the searchFastlyAClient() method from the AssociationRestaurant class. <br>
    */
    public void searchClientFastly() {
        if (ar.getClients().isEmpty())
            System.out.println("There are no clients registered in the system to search one of them.");
        else {
            System.out.print("Enter the name of the client you want to search fastly: ");
            String nameClient = scanner.nextLine().toUpperCase();
            try {
                String message = ar.searchFastlyAClient(nameClient);
                System.out.println(message);
            } catch (InterruptedException ie) {
                System.out.println("\nThread interrupted due to this one being waiting, sleeping or occupied.\n");
                ie.printStackTrace();
            }
        }
    }

    /**
     * Name: registerOrder
     * Method used to register an order, invoking the addOrder() method from the AssociationRestaurant class. <br>
    */
    public void registerOrder() {
        if (ar.getRestaurants().isEmpty())
            System.out.println("There are no restaurants registered in the system to place an order.");
        else {
            if (ar.getProducts().isEmpty())
                System.out.println("There are no products registered in the system to place an order.");
            else {
                if (ar.getClients().isEmpty())
                    System.out.println("There are no clients registered in the system to place an order.");
                else {
                    int codeOrder = (int) (1000000000 * Math.random());
                    System.out.print("ID of the client: ");
                    String idClient = scanner.nextLine();
                    Client objSearch1 = ar.searchClient(idClient);
                    if (objSearch1 == null)
                        System.out.println("\nThis client doesn't exist in the system. Register it.");
                    else {
                        System.out.print("In which restaurant is the client interested in making an order? Enter its NIT: ");
                        String nitRestaurant = scanner.nextLine();
                        Restaurant objSearch2 = ar.searchRestaurant(nitRestaurant);
                        if (objSearch2 == null)
                            System.out.println("\nThis restaurant doesn't exist in the system. Register it.");
                        else {
                            Order objSearch3 = ar.searchOrder(codeOrder);
                            if (objSearch3 != null)
                                System.out.println("\nSorry, the code generated for this order is coincidentally the same as the one from another order. Repeat the process one more time.");
                            else {
                                boolean finish = false;
                                List<Product> productsOrdered = new ArrayList<Product>();
                                do {
                                    System.out.print("\nEnter the code of the product you want to add to the order: ");
                                    String codeProduct = scanner.nextLine();
                                    Product objsearch4 = ar.searchProductWithCodeAndNit(codeProduct, nitRestaurant);
                                    if (objsearch4 == null) {
                                        System.out.println("\nThis product is not registered in the system, OR it is not offered by the chosen restaurant.");
                                        System.out.print("Returning to the start menu...\n\n");
                                        finish = true;
                                    } else {
                                        System.out.print("Enter the number of units the client wants to order: ");
                                        int amountOrdered = Integer.parseInt(scanner.nextLine());
                                        Product copy = objsearch4;
                                        productsOrdered.add(copy);
                                        copy.setAmountOrdered(copy.getAmountOrdered() + amountOrdered);
                                        System.out.println("\nDo you want to add another product to the order? Type 1 if yes, type 2 to confirm the order, or type 3 to cancel the order.");
                                        int answer = Integer.parseInt(scanner.nextLine());
                                        while (answer != 1 && answer != 2 && answer != 3) {
                                            System.out.println("\nError. Option no available. Try again.");
                                            System.out.println("\nDo you want to add another product to the order? Type 1 if yes, type 2 to confirm the order, or type 3 to cancel the order.");
                                            answer = Integer.parseInt(scanner.nextLine());
                                        }
                                        if (answer == 2) {
                                            Date dateTime = new Date();
                                            Order.OrderStatus os = Order.OrderStatus.REQUESTED;
                                            String status = os.name();
                                            try {
                                                String message = ar.addOrder(codeOrder, dateTime, idClient, nitRestaurant, status, productsOrdered);
                                                System.out.println(message);
                                            } catch (IOException ioe) {
                                                ioe.printStackTrace();
                                            }
                                            System.out.print("\nReturning to the start menu...\n\n");
                                            finish = true;
                                        } else if (answer == 3) {
                                            objsearch4.setAmountOrdered(0);
                                            productsOrdered.clear();
                                            finish = true;
                                        }
                                    }
                                } while (!finish);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Name: showOrders
     * Method used to show all the orders registered in the system. <br>
    */
    public void showOrders() {
        if (ar.getRestaurants().isEmpty())
            System.out.println("There are no restaurants registered in the system to show an order after placing it.");
        else {
            if (ar.getProducts().isEmpty())
                System.out.println("There are no products registered in the system to show an order after placing it.");
            else {
                if (ar.getClients().isEmpty())
                    System.out.println("There are no clients registered in the system to show an order after placing it.");
                else {
                    int a = 1;
                    for (int i = 0; i < ar.getOrders().size(); i++) {
                        if (ar.getOrders().get(i) != null) {
                            System.out.println("\nOrder " + a + ":\nOrder code" + SEPARATOR + "Order date and time" + SEPARATOR + "Client ID number" + SEPARATOR + "Restaurant NIT" + SEPARATOR + "Order status\n" + ar.getOrders().get(i).toString() + "\n\n");
                            a++;
                            System.out.println();
                        }
                    }
                }
            }
        }
    }

    /**
     * Name: setRestaurantData
     * Method used to set the information from a registered restaurant in the system. <br>
    */
    public void setRestaurantData() {
        if (ar.getRestaurants().isEmpty())
            System.out.println("\nThere are no restaurants registered in the system to set the information from one of them.");
        else {
            showRestaurantsByName();
            System.out.print("Enter the restaurant's NIT: ");
            String nitRestaurant = scanner.nextLine();
            Restaurant objSearch = ar.searchRestaurant(nitRestaurant);
            if (objSearch == null)
                System.out.println("\nThis restaurant doesn't exist in the system.");
            else {
                boolean run = true;
                do {
                    System.out.println("\nWhat information do you want to set from this restaurant?\n\n(1) Restaurant's name\n(2) Restaurant's NIT\n(3) Restaurant administrator name\n(4) Restaurant operator name\n");
                    int attribute = Integer.parseInt(scanner.nextLine());
                    while (attribute != 1 && attribute != 2 && attribute != 3 && attribute != 4) {
                        System.out.println("\nError. Option no available. Try again.");
                        System.out.println("\nWhat information do you want to set from this restaurant?\n\n(1) Restaurant's name\n(2) Restaurant's NIT\n(3) Restaurant administrator name\n(4) Restaurant operator name\n");
                        attribute = Integer.parseInt(scanner.nextLine());
                    }
                    System.out.print("\nEnter the new value of this attribute: ");
                    String newValue = scanner.nextLine();
                    try {
                        String message = ar.setDataRestaurant(nitRestaurant, attribute, newValue);
                        System.out.println(message);
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                    System.out.println("\nDo you want to set another information from this restaurant? Type 1 if yes or type 0 if not.");
                    int answer = Integer.parseInt(scanner.nextLine());
                    while (answer != 1 && answer != 0) {
                        System.out.println("\nError. Option no available. Try again.");
                        System.out.println("Do you want to set another information from this restaurant? Type 1 if yes or type 0 if not.");
                        answer = Integer.parseInt(scanner.nextLine());
                    }
                    if (answer == 0) {
                        System.out.println("\nReturning to the start menu...");
                        run = false;
                    }
                } while (run);
            }
        }
    }

    /**
     * Name: setProductData
     * Method used to set the information from a registered product in the system. <br>
    */
    public void setProductData() {
        if (ar.getRestaurants().isEmpty())
            System.out.println("There are no restaurants registered in the system to set the product data from one of them.");
        else {
            showProducts();
            System.out.print("Enter the product code: ");
            String codeProduct = scanner.nextLine();
            Product objSearch = ar.searchProductOnlyWithCode(codeProduct);
            if (objSearch == null)
                System.out.println("This product doesn't exist in the system.");
            else {
                boolean run = true;
                do {
                    System.out.println("\nWhat information do you want to set from this product?\n\n(1) Product code\n(2) Product's name\n(3) Product description\n(4) Product cost\n(5) NIT of the restaurant owner of the product\n(6) Product content [for some products]\n");
                    int attribute = Integer.parseInt(scanner.nextLine());
                    while (attribute != 1 && attribute != 2 && attribute != 3 && attribute != 4 && attribute != 5 && attribute != 6) {
                        System.out.println("\nError. Option no available. Try again.");
                        System.out.println("\nWhat information do you want to set from this product?\n\n(1) Product code\n(2) Product's name\n(3) Product description\n(4) Product cost\n(5) NIT of the restaurant owner of the product\n(6) Product content\n");
                        attribute = Integer.parseInt(scanner.nextLine());
                    }
                    if (attribute == 1 || attribute == 2 || attribute == 3 || attribute == 5) {
                        System.out.print("\nEnter the new value of this attribute: ");
                        String newValue1 = scanner.nextLine();
                        double newValue2 = 0;
                        try {
                            String message = ar.setDataProduct(codeProduct, attribute, newValue1, newValue2);
                            System.out.println(message);
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    } else if (attribute == 4 || attribute == 6) {
                        System.out.print("\nEnter the new value of this attribute: ");
                        String newValue1 = "";
                        double newValue2 = Double.parseDouble(scanner.nextLine());
                        try {
                            String message = ar.setDataProduct(codeProduct, attribute, newValue1, newValue2);
                            System.out.println(message);
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    }
                    System.out.println("\nDo you want to set another information from this product? Type 1 if yes or type 0 if not.");
                    int answer = Integer.parseInt(scanner.nextLine());
                    while (answer != 1 && answer != 0) {
                        System.out.println("\nError. Option no available. Try again.");
                        System.out.println("Do you want to set another information from this product? Type 1 if yes or type 0 if not.");
                        answer = Integer.parseInt(scanner.nextLine());
                    }
                    if (answer == 0) {
                        System.out.println("\nReturning to the start menu...");
                        run = false;
                    }
                } while (run);
            }
        }
    }

    /**
     * Name: setClientData
     * Method used to set the information from a registered client in the system. <br>
    */
    public void setClientData() {
        if (ar.getClients().isEmpty())
            System.out.println("\nThere are no clients registered in the system to set the information from one of them.\n");
        else {
            showClientsByLastNameAndName();
            System.out.print("Enter the client's ID: ");
            String idClient = scanner.nextLine();
            Client objSearch = ar.searchClient(idClient);
            if (objSearch == null)
                System.out.println("\nThis client doesn't exist in the system.");
            else {
                boolean run = true;
                do {
                    System.out.println("\nWhat information do you want to set from this client?\n\n(1) Client's document type\n(2) Client's ID\n(3) Client's full name\n(4) Client's phone number\n(5) Client's address\n");
                    int attribute = Integer.parseInt(scanner.nextLine());
                    while (attribute != 1 && attribute != 2 && attribute != 3 && attribute != 4 && attribute != 5) {
                        System.out.println("\nError. Option no available. Try again.");
                        System.out.println("\nWhat information do you want to set from this client?\n\n(1) Client's document type\n(2) Client's ID\n(3) Client's last name\n(4) Client's name\n(5) Client's phone number\n(6) Client's address\n");
                        attribute = Integer.parseInt(scanner.nextLine());
                    }
                    if (attribute == 1) {
                        System.out.print("\n(1) - Identity Card -\n(2) - Citizenship Card -\n(3) - Passport -\n(4) - Foreigner Card -\n\nChoose the new value of this attribute: ");
                        int typeDoc = Integer.parseInt(scanner.nextLine());
                        String newValue = "";
                        if (typeDoc == 1) {
                            Client.DocumentType dt = Client.DocumentType.IDENTITY_CARD;
                            newValue = dt.name();
                        } else if (typeDoc == 2) {
                            Client.DocumentType dt = Client.DocumentType.CITIZENSHIP_CARD;
                            newValue = dt.name();
                        } else if (typeDoc == 3) {
                            Client.DocumentType dt = Client.DocumentType.PASSPORT;
                            newValue = dt.name();
                        } else if (typeDoc == 4) {
                            Client.DocumentType dt = Client.DocumentType.FOREIGNER_CARD;
                            newValue = dt.name();
                        }
                        try {
                            String message = ar.setDataClient(idClient, attribute, newValue);
                            System.out.println(message);
                        } catch (IOException ioe) {
                            System.out.println();
                            System.out.println("Exception in thread 'main'");
                            ioe.printStackTrace();
                        } catch (NonLogicalDocumentTypeException nldte) {
                            System.out.println();
                            System.out.println("Exception in thread 'main'");
                            nldte.printStackTrace();
                        }
                    } else {
                        System.out.print("\nEnter the new value of this attribute: ");
                        String newValue = scanner.nextLine();
                        try {
                            String message = ar.setDataClient(idClient, attribute, newValue);
                            System.out.println(message);
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        } catch (NonLogicalDocumentTypeException nldte) {
                            nldte.printStackTrace();
                        }
                    }
                    System.out.println("\nDo you want to set another information from this client? Type 1 if yes or type 0 if not.");
                    int answer = Integer.parseInt(scanner.nextLine());
                    while (answer != 1 && answer != 0) {
                        System.out.println("\nError. Option no available. Try again.");
                        System.out.println("Do you want to set another information from this client? Type 1 if yes or type 0 if not.");
                        answer = Integer.parseInt(scanner.nextLine());
                    }
                    if (answer == 0) {
                        System.out.println("\nReturning to the start menu...");
                        run = false;
                    }
                } while (run);
            }
        }
    }

    /**
     * Name: setOrderData
     * Method used to set the information from a registered order in the system. <br>
    */
    public void setOrderData() {
        if (ar.getOrders().isEmpty())
            System.out.println("\nThere are no orders registered in the system to set the information from one of them.\n");
        else {
            showOrders();
            System.out.print("Enter the order's code: ");
            int codeOrder = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter the NIT of the chosen restaurant in the order: ");
            String nitRestaurant = scanner.nextLine();
            Order objSearch = ar.searchOrder(codeOrder);
            if (objSearch == null)
                System.out.println("\nThis order isn't registered in the system.");
            else {
                boolean run = true;
                do {
                    System.out.println("\nWhat information do you want to set from this order?\n\n(1) ID of the client that ordered the products\n(2) NIT of the restaurant owner of the products\n(3) Order status\n(4) Order's list of products\n");
                    int attribute = Integer.parseInt(scanner.nextLine());
                    while (attribute != 1 && attribute != 2 && attribute != 3 && attribute != 4 && attribute != 5 && attribute != 6) {
                        System.out.println("\nError. Option no available. Try again.");
                        System.out.println("\nWhat information do you want to set from this order?\n\n(1) ID of the client that ordered the products\n(2) NIT of the restaurant owner of the products\n(3) Order status\n(4) Order's list of products\n");
                        attribute = Integer.parseInt(scanner.nextLine());
                    }
                    if (attribute == 1 && attribute == 2) {
                        System.out.print("\nEnter the new value of this attribute: ");
                        String newValue = scanner.nextLine();
                        String ignore1 = "";
                        String ignore2 = "";
                        int ignore3 = 0;
                        int ignore4 = 0;
                        int ignore5 = 0;
                        int ignore6 = 0;
                        try {
                            String message = ar.setDataOrder(codeOrder, attribute, newValue, ignore1, ignore2, ignore3, ignore4, nitRestaurant, ignore5, ignore6);
                            System.out.println(message);
                        } catch (NonLogicalStatusException nlse) {
                            System.out.println();
                            System.out.println("Exception not expected.");
                            nlse.printStackTrace();
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    } else if (attribute == 3) {
                        System.out.print("\n(1) REQUESTED\n(2) IN PROCESS\n(3) SENT\n(4) DELIVERED\n\nEnter the new value of this attribute (number): ");
                        int newStatus = Integer.parseInt(scanner.nextLine());
                        String newValue = "";
                        if (newStatus == 1) {
                            Order.OrderStatus os = Order.OrderStatus.REQUESTED;
                            newValue = os.name();
                        } else if (newStatus == 2) {
                            Order.OrderStatus os = Order.OrderStatus.IN_PROCESS;
                            newValue = os.name();
                        } else if (newStatus == 3) {
                            Order.OrderStatus os = Order.OrderStatus.SENT;
                            newValue = os.name();
                        } else if (newStatus == 4) {
                            Order.OrderStatus os = Order.OrderStatus.DELIVERED;
                            newValue = os.name();
                        }
                        String ignore1 = "";
                        String ignore2 = "";
                        int ignore3 = 0;
                        int ignore4 = 0;
                        int ignore5 = 0;
                        int ignore6 = 0;
                        try {
                            String message = ar.setDataOrder(codeOrder, attribute, ignore1, newValue, ignore2, ignore3, ignore4, nitRestaurant, ignore5, ignore6);
                            System.out.println(message);
                        } catch (NonLogicalStatusException nlse) {
                            System.out.println();
                            System.out.println("Exception in thread 'main'");
                            nlse.printStackTrace();
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    } else if (attribute == 4) {
                        System.out.println("\nWhat do you want to do?\n\n(1) To add a new product to the list\n(2) To remove a product from the list\n");
                        int action = Integer.parseInt(scanner.nextLine());
                        if (action == 1) {
                            int x = 1;
                            System.out.print("\nThese are the products offered by the restaurant chosen in this order:\n\n");
                            for (int k = 0; k < ar.getProducts().size(); k++) {
                                if (ar.getProducts().get(k).getNitRestaurant().equals(nitRestaurant)) {
                                    System.out.println("Product " + x + ":\n" + ar.getProducts().get(k).toString() + "\n\n");
                                    x++;
                                }
                            }
                            System.out.print("Enter the code of the new product you want to add to the order: ");
                            String codeProduct = scanner.nextLine();
                            Product objsearch4 = ar.searchProductWithCodeAndNit(codeProduct, nitRestaurant);
                            if (objsearch4 == null) {
                                System.out.println("\nThis product is not registered in the system, OR it is not offered by the chosen restaurant.");
                                System.out.print("Returning to the start menu...\n\n");
                            } else {
                                System.out.println("Enter how many more units the client wants to order: ");
                                int amountOrdered = Integer.parseInt(scanner.nextLine());
                                String ignore1 = "";
                                String ignore2 = "";
                                int ignore3 = 0;
                                int ignore4 = 0;
                                try {
                                    String message = ar.setDataOrder(codeOrder, attribute, ignore1, ignore2, codeProduct, action, amountOrdered, nitRestaurant, ignore3, ignore4);
                                    System.out.println(message);
                                } catch (NonLogicalStatusException nlse) {
                                    System.out.println();
                                    System.out.println("Exception not expected.");
                                    nlse.printStackTrace();
                                } catch (IOException ioe) {
                                    ioe.printStackTrace();
                                }
                            }
                        } else if (action == 2) {
                            System.out.println("\nWhat do you want to do?\n\n(1) To remove a whole product from the list\n(2) To remove a number of units from a product of the list\n");
                            int removeAction = Integer.parseInt(scanner.nextLine());
                            if (removeAction == 1) {
                                System.out.print("\nEnter the code of the product you want to remove: ");
                                String codeProduct = scanner.nextLine();
                                String ignore1 = "";
                                String ignore2 = "";
                                int ignore3 = 0;
                                int ignore4 = 0;
                                int ignore5 = 0;
                                try {
                                    String message = ar.setDataOrder(codeOrder, attribute, ignore1, ignore2, codeProduct, action, ignore3, nitRestaurant, ignore4, ignore5);
                                    System.out.println(message);
                                } catch (NonLogicalStatusException nlse) {
                                    System.out.println();
                                    System.out.println("Exception not expected.");
                                    nlse.printStackTrace();
                                } catch (IOException ioe) {
                                    ioe.printStackTrace();
                                }
                            }
                            else if (removeAction == 2) {
                                System.out.print("\nEnter the code of the product in question: ");
                                String codeProduct = scanner.nextLine();
                                System.out.print("\nEnter the number of units to remove from this product: ");
                                int amountToRemove = Integer.parseInt(scanner.nextLine());
                                String ignore1 = "";
                                String ignore2 = "";
                                int ignore3 = 0;
                                try {
                                    String message = ar.setDataOrder(codeOrder, attribute, ignore1, ignore2, codeProduct, action, ignore3, nitRestaurant, removeAction, amountToRemove);
                                    System.out.println(message);
                                } catch (NonLogicalStatusException nlse) {
                                    System.out.println();
                                    System.out.println("Exception not expected.");
                                    nlse.printStackTrace();
                                } catch (IOException ioe) {
                                    ioe.printStackTrace();
                                }
                            }
                        }
                    }
                    objSearch = ar.searchOrder(codeOrder);
                    if (objSearch == null) {
                        System.out.println("\nReturning to the start menu...");
                        run = false;
                    }
                    else {
                        System.out.print("\nDo you want to set another information from this order? Type 1 if yes or type 0 if not: ");
                        int answer = Integer.parseInt(scanner.nextLine());
                        while (answer != 1 && answer != 0) {
                            System.out.println("\nError. Option no available. Try again.");
                            System.out.print("Do you want to set another information from this order? Type 1 if yes or type 0 if not: ");
                            answer = Integer.parseInt(scanner.nextLine());
                        }
                        if (answer == 0) {
                            System.out.println("\nReturning to the start menu...");
                            run = false;
                        }
                    }
                } while (run);
            }
        }
    }
}