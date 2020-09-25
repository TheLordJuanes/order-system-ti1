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
import java.io.IOException;
import org.junit.jupiter.api.Test;

class AssociationRestaurantTest {

	private AssociationRestaurant ar;

	public void setupScenary1() {
		try {
			ar = new AssociationRestaurant("Restaurant Association®");
			ar.addRestaurantForTest("El Corral", "109238-32111", "Fernando", "Manuel");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void setupScenary2() {
		try {
			ar = new AssociationRestaurant("Restaurant Association®");
			ar.addRestaurantForTest("Karens", "109238-32111", "Fernando", "Manuel");
			ar.addProductForTest("67v", "Pizza", "Good", 20000, "109238-32111", 10, 0);
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@Test
	public void testSearchRestaurant() {
		setupScenary1();
		String nitRestaurant1 = "109238-32111";
		Restaurant objSearch1 = ar.searchRestaurant(nitRestaurant1);
		assertNotNull(objSearch1);
		setupScenary1();
		String nitRestaurant2 = "1881881818818";
		Restaurant objSearch2 = ar.searchRestaurant(nitRestaurant2);
		assertNull(objSearch2);
	}

	@Test
	public void testSearchProductWithCodeAndNit() {
		setupScenary2();
		String codeProduct1 = "67v";
		String nitRestaurant1 = "109238-32111";
		Product objSearch1 = ar.searchProductWithCodeAndNit(codeProduct1, nitRestaurant1);
		assertNotNull(objSearch1);
		setupScenary2();
		String codeProduct2 = "54zx";
		String nitRestaurant2 = "109238-32111";
		Product objSearch2 = ar.searchProductWithCodeAndNit(codeProduct2, nitRestaurant2);
		assertNull(objSearch2);
	}
}