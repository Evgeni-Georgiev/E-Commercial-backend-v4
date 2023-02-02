package eu.deltasource.internship.ecommerce;

/**
 * The Product class describes the characteristics of a product
 * that can be instantiated as an object.
 *
 * @author Evgeni Georgiev
 * @version 1.0
 */
public class Product {

	private final String productLabel;

	private final double productPrice;

	// Constructor with default values.
	public Product() {
		productLabel = "Dragon fruit";
		productPrice = 10.0;
	}

	public Product(String productLabel, double productPrice) {
		this.productLabel = productLabel;
		this.productPrice = productPrice;
	}

	public String getProductLabel() {
		return productLabel;
	}

	public double getProductPrice() {
		return productPrice;
	}

	// Method is returning a String containing the details that describe the product(label, price).
	@Override
	public String toString() {
		return String.format("\nLabel of the product: %s \nPrice of the product: $%,.2f", getProductLabel(), getProductPrice());
	}
}
