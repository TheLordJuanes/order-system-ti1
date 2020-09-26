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

public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    public final static String SEPARATOR = ",";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    private String codeProduct;
    private String nameProduct;
    private String description;
    private double cost;
    private String nitRestaurant;
    private double content;
    private int amountOrdered;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
	 * Name: Product
	 * Constructor method of a product. <br>
	 * @param codeProduct - Product code - codeProduct = String, codeProduct != null, codeProduct != ""
     * @param nameProduct - Product name - nameProduct = String, nameProduct != null, nameProduct != ""
     * @param description - Product description - description = String, description != null, description != ""
     * @param cost - Product cost - cost = double, cost != null, cost != 0
     * @param nitRestaurant - NIT of the restaurant product owner - nitRestaurant = String, nitRestaurant != null, nitRestaurant != ""
     * @param content - Product content - content = double, content != null, content != 0
     * @param amountOrdered - Ordered units of the product when an order is going to be placed - amountOrdered = int, amountOrdered != null
	*/
    public Product(String codeProduct, String nameProduct, String description, double cost, String nitRestaurant, double content, int amountOrdered) {
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.description = description;
        this.cost = cost;
        this.nitRestaurant = nitRestaurant;
        this.content = content;
        this.amountOrdered = amountOrdered;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getNitRestaurant() {
        return nitRestaurant;
    }

    public void setNitRestaurant(String nitRestaurant) {
        this.nitRestaurant = nitRestaurant;
    }

    public double getContent() {
        return content;
    }

    public void setContent(double content) {
        this.content = content;
    }

    public int getAmountOrdered() {
        return amountOrdered;
    }

    public void setAmountOrdered(int amountOrdered) {
        this.amountOrdered = amountOrdered;
    }

    /** Name: getProductInfoToExport
	 * Method used to print a String that textually represents an object of from Product class with its elements, for files exporting purposes.
	 * @return A String representing the information of a product, without the restaurant NIT attribute.
  	*/
    public String getProductInfoToExport(){
        return codeProduct + SEPARATOR + nameProduct + SEPARATOR + description + SEPARATOR + cost + SEPARATOR + content + SEPARATOR + amountOrdered;
    }

    /** Name: toString
	 * Method used to print a String that textually represents an object from the Product class with its elements.
	 * @return A String representing the information of a product.
  	*/
    @Override
    public String toString() {
        return codeProduct + SEPARATOR + nameProduct + SEPARATOR + description + SEPARATOR + cost + SEPARATOR + content + SEPARATOR + nitRestaurant + SEPARATOR + amountOrdered;
    }
}