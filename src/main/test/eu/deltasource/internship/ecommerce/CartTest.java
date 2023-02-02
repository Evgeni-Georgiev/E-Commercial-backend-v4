package eu.deltasource.internship.ecommerce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CartTest {
    Product apple = new Product("Apple", 2.65);
    Product banana = new Product("Banana", 4.00);
    Product kiwi = new Product("Kiwi", 3.15);
    Product orange = new Product("Orange", 7.95);
    Cart cart = new Cart();
    CartItem appleItem = new CartItem(apple, 15);
    CartItem dragonFruitItem = new CartItem();
    CartItem bananaItem = new CartItem(banana, 50);
    CartItem kiwiItem = new CartItem(kiwi, 11);
    CartItem orangeItem = new CartItem(orange, 3);

    @Test
    void runCartProcessedDataOutputTest() {
        cart.addCartItem(appleItem);
        cart.addCartItem(bananaItem);
        cart.addCartItem(kiwiItem);
        cart.addCartItem(orangeItem);

        assertEquals("Total sum of all items in cart: $298.25\n" +
                "VAT: $59.65\n" +
                "Delivery Fee: $0.00\n" +
                "Final price with Delivery Fee and VAT: $357.90\n", cart.toString());
    }

    @Test
    void addProductAsCartItem() {
        cart.addCartItem(dragonFruitItem);
        assertEquals("Dragon fruit", dragonFruitItem.getProduct().getProductLabel());
    }

    @Test
    void removeProductAsCartItem() {
        cart.removeCartItem(appleItem);
        assertEquals("Apple", appleItem.getProduct().getProductLabel());
    }

    @Test
    void decreaseQuantityForItem() {
        cart.decreaseQuantityForItem(appleItem, 5);
        assertEquals(10, appleItem.getQuantity());
    }

    @Test
    void decreaseCountIsBiggerThanQuantity() {
        cart.decreaseQuantityForItem(appleItem, 50);
        assertEquals("Apple", appleItem.getProduct().getProductLabel());
    }

    @Test
    void ifQuantityIsLessThanOne() {
        CartItem appleItem1 = new CartItem(apple, 5);
        cart.addCartItem(appleItem1);
        cart.decreaseQuantityForItem(appleItem1, 5);
        assertEquals(0, appleItem1.getQuantity());
    }

    @Test
    void productDetailsOutputTest() {
        Product kiwi = new Product("Kiwi", 3.15);
        CartItem kiwiItem = new CartItem(kiwi, 11);
        Cart itemsInCart = new Cart();
        itemsInCart.addCartItem(kiwiItem);
        itemsInCart.productDetailsOutput();
        assertEquals("\nLabel of the product: Kiwi \n" +
            "Price of the product: $3.15 \n" +
            "Quantity of the product: 11 \n" +
            "Result sum for price and quantity of product: $34.65", kiwiItem.toString());
    }

    @Test
    void grandReturnTest() {
        cart.addCartItem(appleItem);
        cart.addCartItem(bananaItem);
        cart.addCartItem(kiwiItem);
        cart.addCartItem(orangeItem);

        cart.grandTotalOfCart();
        assertEquals("Total sum of all items in cart: $298.25\n" +
            "VAT: $59.65\n" +
            "Delivery Fee: $0.00\n" +
            "Final price with Delivery Fee and VAT: $357.90\n", cart.toString());
    }

    @Test
    void deliveryFeeLessThan100Test() {
        Product apple = new Product("Apple", 2.65);
        Product banana = new Product("Banana", 4.00);
        Product orange = new Product("Orange", 7.95);
        Cart cart = new Cart();
        CartItem appleItem = new CartItem(apple, 5);
        CartItem bananaItem = new CartItem(banana, 10);
        CartItem orangeItem = new CartItem(orange, 3);

        cart.addCartItem(appleItem);
        cart.addCartItem(bananaItem);
        cart.addCartItem(orangeItem);

        cart.grandTotalOfCart();
        assertEquals("Total sum of all items in cart: $77.10\n" +
            "VAT: $15.42\n" +
            "Delivery Fee: $10.00\n" +
            "Final price with Delivery Fee and VAT: $102.52\n", cart.toString());
    }

    @Test
    void deliveryFeeMoreThan100Test() {
        Product apple = new Product("Apple", 2.65);
        Product banana = new Product("Banana", 4.00);
        Product orange = new Product("Orange", 7.95);
        Cart cart = new Cart();
        CartItem appleItem = new CartItem(apple, 45);
        CartItem bananaItem = new CartItem(banana, 10);
        CartItem orangeItem = new CartItem(orange, 3);

        cart.addCartItem(appleItem);
        cart.addCartItem(bananaItem);
        cart.addCartItem(orangeItem);

        cart.grandTotalOfCart();
        assertEquals("Total sum of all items in cart: $183.10\n" +
            "VAT: $36.62\n" +
            "Delivery Fee: $5.00\n" +
            "Final price with Delivery Fee and VAT: $224.72\n", cart.toString());
    }

}
