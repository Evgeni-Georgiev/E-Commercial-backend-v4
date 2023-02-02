package eu.deltasource.internship.ecommerce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product productTest = new Product("Apple", 15);

    @Test
    void getProductLabelTest() {
        assertEquals("Apple", productTest.getProductLabel());
    }

    @Test
    void getProductPriceTest() {
        assertEquals(15, productTest.getProductPrice());
    }

    @Test
    void testDefaultConstructor() {
        Product myProduct = new Product();
        assertEquals("Dragon fruit", myProduct.getProductLabel());
        assertEquals(10.0, myProduct.getProductPrice());
    }

    @Test
    void runProductOutputTest() {
        assertEquals("\nLabel of the product: Apple \n" +
            "Price of the product: $15.00", productTest.toString());
    }

}