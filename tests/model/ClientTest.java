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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClientTest {

	public final static String SEPARATOR = " ; ";

	private Client client;

	@Test
	public void testClient() {
		String typeDocument = Client.DocumentType.CITIZENSHIP_CARD.name();
		String idClient = "677676111";
		String lastNameClient = "lalalalala";
		String nameClient = "ioioioioioio";
		String phone = "233287-8710";
		String address = "mnghfdrwejkjkjk";
		client = new Client(typeDocument, idClient, lastNameClient, nameClient, phone, address);
		assertEquals(typeDocument, client.getTypeDocument(), "Document type of the client not created correctly.");
		assertEquals(idClient, client.getIdClient(), "Client ID number not created correctly.");
		assertEquals(lastNameClient, client.getLastNameClient(), "Client last name not created correctly.");
		assertEquals(nameClient, client.getNameClient(), "Client name not created correctly.");
		assertEquals(phone, client.getPhone(), "Client phone not created correctly.");
		assertEquals(address, client.getAddress(), "Client address not created correctly.");
	}

	@Test
	public void testToString() {
		String typeDocument = Client.DocumentType.CITIZENSHIP_CARD.name();
		String idClient = "677676111";
		String lastNameClient = "lalalalala";
		String nameClient = "ioioioioioio";
		String phone = "233287-8710";
		String address = "mnghfdrwejkjkjk";
		client = new Client(typeDocument, idClient, lastNameClient, nameClient, phone, address);
		assertEquals(lastNameClient + SEPARATOR + nameClient + SEPARATOR + typeDocument + SEPARATOR + idClient + SEPARATOR + phone + SEPARATOR + address, client.toString(), "The client information was not displayed.");
	}
}