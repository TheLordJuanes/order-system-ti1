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

class ProductTest {

	public final static String SEPARATOR = " ; ";

	private Product product;

	@Test
	public void testProduct() {
		String codeProduct = "101010101010";
		String nameProduct = "Edna";
		String description = "Moda";
		double cost = 2918;
		String nitRestaurant = "90909090";
		double content = 121;
		int amountOrdered = 0;
		product = new Product(codeProduct, nameProduct, description, cost, nitRestaurant, content, amountOrdered);
		assertEquals(codeProduct, product.getCodeProduct(), "Product code not created correctly.");
		assertEquals(nameProduct, product.getNameProduct(), "Product name not created correctly.");
		assertEquals(description, product.getDescription(), "Product description not created correctly.");
		assertEquals(cost, product.getCost(), "Product cost not created correctly.");
		assertEquals(nitRestaurant, product.getNitRestaurant(), "NIT of the restaurant product owner not created correctly.");
		assertEquals(content, product.getContent(), "Product content not created correctly.");
		assertEquals(amountOrdered, product.getAmountOrdered(), "Amount ordered not created correctly.");
		assertEquals(0, product.getAmountOrdered(), "Amount ordered isn't 0.");
	}

	@Test
	public void testToString() {
		String codeProduct = "101010101010";
		String nameProduct = "Edna";
		String description = "Moda";
		double cost = 2918;
		String nitRestaurant = "90909090";
		double content = 121;
		int amountOrdered = 0;
		product = new Product(codeProduct, nameProduct, description, cost, nitRestaurant, content, amountOrdered);
		assertEquals(codeProduct + SEPARATOR + nameProduct + SEPARATOR + description + SEPARATOR + cost + SEPARATOR + content + SEPARATOR + nitRestaurant + SEPARATOR + amountOrdered, product.toString(), "The product information was not displayed.");
	}
}