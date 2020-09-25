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

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable, Comparable<Order> {

    public enum OrderStatus {

        REQUESTED, IN_PROCESS, SENT, DELIVERED;
    }

    private static final long serialVersionUID = 1L;

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    public final static String SEPARATOR = " ; ";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    private int codeOrder;
    private Date dateTime;
    private String idClient;
    private String nitRestaurant;
    private String status;

    // -----------------------------------------------------------------
    // Relations
    // -----------------------------------------------------------------

    private List<Product> products;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
	 * Name: Order
	 * Constructor method of an order. <br>
	 * @param codeOrder - Order code - codeOrder = int, codeOrder != null, codeOrder != 0
     * @param dateTime - Date and time of order creation - dateTime = Date, dateTime != null
     * @param idClient - Client ID number - idClient = String, idClient != null, idClient != ""
     * @param nitRestaurant - Restaurant NIT - nitRestaurant = String, nitRestaurant != null, nitRestaurant != ""
     * @param status - Order status - status = String, status != null, status != ""
     * @param productsOrdered - List of products from the order - productsOrdered = List<Product>, productsOrdered != null
	*/
    public Order(int codeOrder, Date dateTime, String idClient, String nitRestaurant, String status, List<Product> products) {
        this.codeOrder = codeOrder;
        this.dateTime = dateTime;
        this.idClient = idClient;
        this.nitRestaurant = nitRestaurant;
        this.status = status;
        this.products = products;
    }

    public int getCodeOrder() {
        return codeOrder;
    }

    public void setCodeOrder(int codeOrder) {
        this.codeOrder = codeOrder;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getNitRestaurant() {
        return nitRestaurant;
    }

    public void setNitRestaurant(String nitRestaurant) {
        this.nitRestaurant = nitRestaurant;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /** Name: compareTo
	 * Method used to compare lexicographically String attributes from an order.
     * <b>pre: </b> List of products from the order already exists and has at least one product registered in it. <br>
     * <b>post: </b> Comparison result obtained of the degree of lexicographicity between the String attributes compared. <br>
     * @param order - An Order object - order != null
	 * @return An int representing the comparsion result, be it positive, negative or equal to 0.
  	*/
      @Override
      public int compareTo(Order order) {
          int result = nitRestaurant.compareTo(order.getNitRestaurant());
          if (result == 0) {
              result = order.getIdClient().compareTo(idClient);
              if (result == 0) {
                  result = dateTime.compareTo(order.getDateTime());
                  if (result == 0) {
                      for (int i = 0; i < products.size(); i++) {
                          if (products.get(i) != null)
                              result = products.get(i).getCodeProduct().compareTo(order.getProducts().get(i).getCodeProduct());
                      }
                  }
              }
          }
          return result;
      }

    /** Name: toString
	 * Method used to print a String that textually represents an object from the Order class with its elements.
	 * @return A String representing the information of an order.
  	*/
    @Override
    public String toString() {
        String message = codeOrder + SEPARATOR + dateTime + SEPARATOR + idClient + SEPARATOR + nitRestaurant + SEPARATOR + status;
        int x = 1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) != null) {
                message += "\n\nProduct " + x + ":\nProduct code" + SEPARATOR + "Product name" + SEPARATOR + "Product cost" + SEPARATOR + "Product description" + SEPARATOR + "Product content" + SEPARATOR + "Restaurant owner NIT" + SEPARATOR + "Amount ordered\n" + products.get(i).toString();
                x++;
            }
        }
        return message;
    }
}