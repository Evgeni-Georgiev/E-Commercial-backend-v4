package eu.deltasource.internship.ecommerce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartItemTest {

    Product productTest = new Product("Dragon Fruit", 15);

    CartItem cartItem = new CartItem(productTest, 14);

    @Test
    void getProductFromCart() {

        assertEquals(productTest, cartItem.getProduct());
        assertEquals(14, cartItem.getQuantity());
    }

    @Test
    void setQuantityTest() {

        cartItem.setQuantity(20);
        assertEquals(20, cartItem.getQuantity());
    }

    @Test
    void sumPriceAndQuantityTest() {

        assertEquals(210, cartItem.sumTotalPriceOfItem());
    }

    @Test
    void runCartItemOutput() {

        assertEquals("\nLabel of the product: Dragon Fruit \n" +
                "Price of the product: $15.00 \n" +
                "Quantity of the product: 14 \n" +
                "Result sum for price and quantity of product: $210.00", cartItem.toString());
    }

    @Test
    void testDefaultConstructor() {

        CartItem myCartItem = new CartItem();
        assertEquals(new Product().getProductLabel(), myCartItem.getProduct().getProductLabel());
        assertEquals(4, myCartItem.getQuantity());
    }
}
