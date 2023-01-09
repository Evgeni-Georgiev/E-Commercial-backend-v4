package eu.delta_source.internship;

public class Application {
	public static void main(String[] args) {

		// Creating products, adding labels and prices.
		Product apple = new Product("Apple", 2.65);
		Product carrot = new Product("Carrot", 7.65);
		// Product dragonFruit = new Product();
		Product banana = new Product("Banana", 4.00);
		Product kiwi = new Product("Kiwi", 3.15);
		Product orange = new Product("Orange", 7.95);

		// Wrapping the products as cart items and adding quantity to them.
		CartItem appleItem = new CartItem(apple, 15);
		CartItem carrotItem = new CartItem(carrot, 17);
		CartItem dragonFruitItem = new CartItem();
		CartItem bananaItem = new CartItem(banana, 10);
		CartItem kiwiItem = new CartItem(kiwi, 11);
		CartItem orangeItem = new CartItem(orange, 3);

		Cart itemsInCart = new Cart();

		// Adding the items to a cart where they will be processed.
		itemsInCart.addCartItem(appleItem);
		itemsInCart.addCartItem(carrotItem);
		itemsInCart.addCartItem(dragonFruitItem);
		itemsInCart.addCartItem(bananaItem);
		itemsInCart.addCartItem(kiwiItem);
		itemsInCart.addCartItem(orangeItem);

		// (Optional) Decrease the count of quantity by n-count to a single product.
		itemsInCart.decreaseQuantityForItem(appleItem, 2);

		// Remove item from cart
		itemsInCart.removeCartItem(carrotItem);

		// Output Label and Price of product, Quantity and Result sum for price and quantity of single product.
		itemsInCart.runProductsInCartOutput();

		System.out.println("------------------------------");

		// Output Total summation all items in cart, Summation + VAT, Delivery Fee, End Summation
		itemsInCart.runCartProcessedDataOutput();

	}
}
