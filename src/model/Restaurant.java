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

public class Restaurant implements Serializable {

    private static final long serialVersionUID = 1L;

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    public final static String SEPARATOR = " ; ";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    private String nameRestaurant;
    private String nitRestaurant;
    private String nameCeo;
    private String operator;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
	 * Name: Restaurant
	 * Constructor method of a restaurant. <br>
	 * @param nameRestaurant - Restaurant name - nameRestaurant = String, nameRestaurant != null, nameRestaurant != ""
     * @param nitRestaurant - Restaurant NIT - nitRestaurant = String, nitRestaurant != null, nitRestaurant != ""
     * @param nameCeo - Restaurant administrator - nameCeo = String, nameCeo != null, nameCeo != ""
     * @param operator - Restaurant operator - operator = String, operator != null, operator != ""
	*/
    public Restaurant(String nameRestaurant, String nitRestaurant, String nameCeo, String operator) {
        this.nameRestaurant = nameRestaurant;
        this.nitRestaurant = nitRestaurant;
        this.nameCeo = nameCeo;
        this.operator = operator;
    }

    public String getNameRestaurant() {
        return nameRestaurant;
    }

    public void setNameRestaurant(String nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
    }

    public String getNitRestaurant() {
        return nitRestaurant;
    }

    public void setNitRestaurant(String nitRestaurant) {
        this.nitRestaurant = nitRestaurant;
    }

    public String getNameCeo() {
        return nameCeo;
    }

    public void setNameCeo(String nameCeo) {
        this.nameCeo = nameCeo;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    /** Name: toString
	 * Method used to print a String that textually represents an object from the Restaurant class with its elements.
	 * @return A String representing the information of a restaurant.
  	*/
    @Override
    public String toString() {
        return nameRestaurant + SEPARATOR + nitRestaurant + SEPARATOR + nameCeo + SEPARATOR + operator;
    }
}
