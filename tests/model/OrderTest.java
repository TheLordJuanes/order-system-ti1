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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;

class OrderTest {

	public final static String SEPARATOR = " ; ";

	private int codeOrder = (int) (1000000000 * Math.random());
	private Date dateTime = new Date();
	private String idClient = "655656222";
	private String nitRestaurant = "19191928";
	private String status = Order.OrderStatus.REQUESTED.name();

	private List<Product> products;
	private Order order;

	public void setupScenario1() {
		products = new ArrayList<Product>();
	}

	@Test
	public void testOrder() {
		setupScenario1();
		Product obj = new Product("576438211-66", "Kilko", "Nice taste", 9009, nitRestaurant, 4433, 0);
		products.add(obj);
		order = new Order(codeOrder, dateTime, idClient, nitRestaurant, status, products);
		assertEquals(codeOrder, order.getCodeOrder(), "Document type of the client not created correctly.");
		assertEquals(dateTime, order.getDateTime(), "Client ID number not created correctly.");
		assertEquals(idClient, order.getIdClient(), "Client last name not created correctly.");
		assertEquals(nitRestaurant, order.getNitRestaurant(), "Client name not created correctly.");
		assertEquals(status, order.getStatus(), "Client phone not created correctly.");
		assertEquals(products, order.getProducts(), "Client address not created correctly.");
	}

	@Test
	public void testCompareTo() {
		// Example with the Restaurant NIT attribute from an order (ascending sort purposes) :

		// Expected comparation result: greater than it:

		setupScenario1();
		Product obj1 = new Product("576438211-66", "Kilko", "Nice taste", 9009, nitRestaurant, 4433, 0);
		products.add(obj1);
		Order order1 = new Order(codeOrder, dateTime, idClient, nitRestaurant, status, products);
		String exampleCurrentNit1 = "43871892";
		assertTrue(exampleCurrentNit1.compareTo(order1.getNitRestaurant()) > 0, "Lexicographically, the current attribute isn't greater than the one passed as parameter.");
		assertFalse(exampleCurrentNit1.compareTo(order1.getNitRestaurant()) < 0, "Lexicographically, the current attribute is less than the one passed as parameter.");
		assertFalse(exampleCurrentNit1.compareTo(order1.getNitRestaurant()) == 0, "Lexicographically, the current attribute is equal to the one passed as parameter.");

		/*-----------------------------------------------------------------------------------------------------------*/

		// Expected comparation result: less than it:

		setupScenario1();
		Product obj2 = new Product("576438211-66", "Kilko", "Nice taste", 9009, nitRestaurant, 4433, 0);
		products.add(obj2);
		Order order2 = new Order(codeOrder, dateTime, idClient, nitRestaurant, status, products);
		String exampleCurrentNit2 = "13765489";
		assertTrue(exampleCurrentNit2.compareTo(order2.getNitRestaurant()) < 0, "Lexicographically, the current attribute isn't less than the one passed as parameter.");
		assertFalse(exampleCurrentNit2.compareTo(order2.getNitRestaurant()) > 0, "Lexicographically, the current attribute is greater than the one passed as parameter.");
		assertFalse(exampleCurrentNit2.compareTo(order2.getNitRestaurant()) == 0, "Lexicographically, the current attribute is equal to the one passed as parameter.");

		/*-----------------------------------------------------------------------------------------------------------*/

		// Expected comparation result: equal:

		setupScenario1();
		Product obj3 = new Product("576438211-66", "Kilko", "Nice taste", 9009, nitRestaurant, 4433, 0);
		products.add(obj3);
		Order order3 = new Order(codeOrder, dateTime, idClient, nitRestaurant, status, products);
		String exampleCurrentNit3 = "19191928";
		assertTrue(exampleCurrentNit3.compareTo(order3.getNitRestaurant()) == 0, "Lexicographically, the current attribute isn't equal to the one passed as parameter.");
		assertFalse(exampleCurrentNit3.compareTo(order3.getNitRestaurant()) > 0, "Lexicographically, the current attribute is greater than the one passed as parameter.");
		assertFalse(exampleCurrentNit3.compareTo(order3.getNitRestaurant()) < 0, "Lexicographically, the current attribute is less than the one passed as parameter.");

		/*-----------------------------------------------------------------------------------------------------------*/

		// Example with the Restaurant NIT attribute from an order (descending sort purposes) :

		// Expected comparation result: greater than it:

		setupScenario1();
		Product obj4 = new Product("576438211-66", "Kilko", "Nice taste", 9009, nitRestaurant, 4433, 0);
		products.add(obj4);
		Order order4 = new Order(codeOrder, dateTime, idClient, nitRestaurant, status, products);
		String exampleCurrentNit4 = "13765489";
		assertTrue(order4.getNitRestaurant().compareTo(exampleCurrentNit4) > 0, "Lexicographically, the attribute passed as parameter isn't greater than the current one.");
		assertFalse(order4.getNitRestaurant().compareTo(exampleCurrentNit4) < 0, "Lexicographically, the attribute passed as parameter is less than the current one.");
		assertFalse(order4.getNitRestaurant().compareTo(exampleCurrentNit4) == 0, "Lexicographically, the attribute passed as parameter is equal to the current one.");

		/*-----------------------------------------------------------------------------------------------------------*/

		// Expected comparation result: less than it:

		setupScenario1();
		Product obj5 = new Product("576438211-66", "Kilko", "Nice taste", 9009, nitRestaurant, 4433, 0);
		products.add(obj5);
		Order order5 = new Order(codeOrder, dateTime, idClient, nitRestaurant, status, products);
		String exampleCurrentNit5 = "43871892";
		assertTrue(order5.getNitRestaurant().compareTo(exampleCurrentNit5) < 0, "Lexicographically, the attribute passed as parameter isn't less than the current one.");
		assertFalse(order5.getNitRestaurant().compareTo(exampleCurrentNit5) > 0, "Lexicographically, the attribute passed as parameter is greater than the current one.");
		assertFalse(order5.getNitRestaurant().compareTo(exampleCurrentNit5) == 0, "Lexicographically, the attribute passed as parameter is equal to the current one.");

		/*-----------------------------------------------------------------------------------------------------------*/

		// Expected comparation result: equal:

		setupScenario1();
		Product obj6 = new Product("576438211-66", "Kilko", "Nice taste", 9009, nitRestaurant, 4433, 0);
		products.add(obj6);
		Order order6 = new Order(codeOrder, dateTime, idClient, nitRestaurant, status, products);
		String exampleCurrentNit6 = "19191928";
		assertTrue(order6.getNitRestaurant().compareTo(exampleCurrentNit6) == 0, "Lexicographically, the attribute passed as parameter isn't equal to the current one.");
		assertFalse(order6.getNitRestaurant().compareTo(exampleCurrentNit6) > 0, "Lexicographically, the attribute passed as parameter is greater than the current one.");
		assertFalse(order6.getNitRestaurant().compareTo(exampleCurrentNit6) < 0, "Lexicographically, the attribute passed as parameter is equal to the current one.");
	}
}