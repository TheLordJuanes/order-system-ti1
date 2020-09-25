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

class RestaurantTest {

	public final static String SEPARATOR = " ; ";

	private Restaurant restaurant;

	@Test
	public void testRestaurant() {
		String nameRestaurant = "CarbsPlus";
		String nitRestaurant = "76767667676";
		String nameCeo = "Yuluka";
		String operator = "Sasuke";
		restaurant = new Restaurant(nameRestaurant, nitRestaurant, nameCeo, operator);
		assertEquals(nameRestaurant, restaurant.getNameRestaurant(), "Restaurant name not created correctly.");
		assertEquals(nitRestaurant, restaurant.getNitRestaurant(), "Restaurant NIT not created correctly.");
		assertEquals(nameCeo, restaurant.getNameCeo(), "Restaurant administrator not created correctly.");
		assertEquals(operator, restaurant.getOperator(), "Restaurant operator not created correctly.");
	}

	@Test
	public void testToString() {
		String nameRestaurant = "CarbsPlus";
		String nitRestaurant = "76767667676";
		String nameCeo = "Yuluka";
		String operator = "Sasuke";
		restaurant = new Restaurant(nameRestaurant, nitRestaurant, nameCeo, operator);
		assertEquals(nameRestaurant + SEPARATOR + nitRestaurant + SEPARATOR + nameCeo + SEPARATOR + operator, restaurant.toString(), "The restaurant information was not displayed.");
	}
}