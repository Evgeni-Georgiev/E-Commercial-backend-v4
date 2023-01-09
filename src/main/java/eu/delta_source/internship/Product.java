package eu.delta_source.internship;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * The Product class describes the characteristics of a product
 * that can be made as an object and outputs the data
 * to the console.
 *
 * @author Evgeni Georgiev
 * @version 1.0
 */
public class Product {

	private final String productLabel;

	private final double productPrice;

	NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);

	// Constructor with default values.
	public Product() {
		this.productLabel = "Dragon fruit";
		this.productPrice = 10.0;
	}

	public Product(String productLabel, double productPrice) {
		this.productLabel = productLabel;
		this.productPrice = productPrice;
	}

	public String getProductLabel() {
		return this.productLabel;
	}

	public double getProductPrice() {
		return this.productPrice;
	}

	// Method is returning a String containing the details that describe the product(label, price).
	public String returnProductDetails() {
		return String.format("\nLabel of the product: %s \nPrice of the product: %s", getProductLabel(), currencyFormat.format(getProductPrice()));
	}
}
