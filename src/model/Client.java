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

public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    public enum DocumentType {

        CITIZENSHIP_CARD, IDENTITY_CARD, PASSPORT, FOREIGNER_CARD;
    }

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    public final static String SEPARATOR = " ; ";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    private String typeDocument;
    private String idClient;
    private String lastNameClient;
    private String nameClient;
    private String phone;
    private String address;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
	 * Name: Client
	 * Constructor method of a client. <br>
	 * @param typeDocument - Client document type - typeDocument = String, typeDocument != null, typeDocument != ""
     * @param idClient - Client ID number - idClient = String, idClient != null, idClient != ""
     * @param lastNameClient - Client last name - lastNameClient = String, lastNameClient != null, lastNameClient != ""
     * @param nameClient - Client name - nameClient = String, nameClient != null, nameClient != ""
     * @param phone - Client phone - phone = String, phone != null, phone != ""
     * @param address - Client address - address = String, address != null, address != ""
	*/
    public Client(String typeDocument, String idClient, String lastNameClient, String nameClient, String phone, String address) {
        this.typeDocument = typeDocument;
        this.idClient = idClient;
        this.lastNameClient = lastNameClient;
        this.nameClient = nameClient;
        this.phone = phone;
        this.address = address;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getLastNameClient() {
        return lastNameClient;
    }

    public void setLastNameClient(String lastNameClient) {
        this.lastNameClient = lastNameClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /** Name: toString
	 * Method used to print a String that textually represents an object from the Client class with its elements.
	 * @return A String representing the information of a client.
  	*/
    @Override
    public String toString() {
        return lastNameClient + SEPARATOR + nameClient + SEPARATOR + typeDocument + SEPARATOR + idClient + SEPARATOR + phone + SEPARATOR + address;
    }
}