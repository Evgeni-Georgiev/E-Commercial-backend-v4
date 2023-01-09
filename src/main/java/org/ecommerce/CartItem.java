package org.ecommerce;

/**
 * The CartItem class wraps existing product as an item from cart.
 * It can be used to set quantity to that product and sum the total price.
 *
 * @author Evgeni Georgiev
 * @version 1.0
 */
public class CartItem {
	private final Product product;
	private int quantity;

	// Constructor with default values.
	CartItem() {
		this.product = new Product();
		this.quantity = 4;
	}

	CartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return this.product;
	}

	public int getQuantity() {
		return this.quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// Method for calculating the total sum for single product of price and quantity.
	public double sumPriceAndQuantityOfSingleItemInCart() {
		return product.getProductPrice() * quantity;
	}

	// Method for outputting the quantity of single product, and it's result summation by price and quantity.
	public String runCartItemOutput() {
		return String.format("%s \nQuantity of the product: %s \nResult sum for price and quantity of product: $%.2f", product.runProductOutput(), getQuantity(), sumPriceAndQuantityOfSingleItemInCart());
	}

}
