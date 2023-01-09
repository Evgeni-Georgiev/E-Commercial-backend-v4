package eu.delta_source.internship;

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
	public CartItem() {
		this.product = new Product();
		this.quantity = 4;
	}

	public CartItem(Product product, int quantity) {
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

	// Method for calculating the total sum of item.
	public double sumTotalPriceOfItem() {
		return product.getProductPrice() * quantity;
	}

	// Method returning String with details that describe the class details.
	public String returnCartItemDetails() {
		return String.format("%s \nQuantity of the product: %s \nResult sum for price and quantity of product: $%,.2f", product.returnProductDetails(), getQuantity(), sumTotalPriceOfItem());
	}
}
