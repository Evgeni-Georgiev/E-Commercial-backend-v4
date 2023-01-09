package eu.delta_source.internship;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * The Cart class is used to add delivery fee and VAT to the items from the Cart.
 *
 * @author Evgeni Georgiev
 * @version 1.0
 */
public class Cart {

	private final ArrayList<CartItem> cartItems = new ArrayList<>();

	private double deliveryFee;

	NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);

	// Method outputting details for single product(label, price, quantity, result sum for price and quantity).
	public void productDetailsOutput() {
		cartItems.forEach(product -> System.out.println(product.returnCartItemDetails()));
	}

	// Add new product to the cart.
	public void addCartItem(CartItem cartItem) {
		cartItems.add(cartItem);
	}

	// Method decreasing the count of quantity of single product by n-count(additional functionality).
	// When the quantity is less than 1 the product is removed from the cart.
	public void decreaseQuantityForItem(CartItem cartItem, int decreaseCountBy) {
		int quantity = cartItem.getQuantity();
		if(decreaseCountBy > quantity) {
			System.out.printf("Operation cannot be performed: Decrease count is less than quantity. Item: %s's quantity stays unchanged. %n", cartItem.getProduct().getProductLabel());
		} else {
			quantity -= decreaseCountBy;
			cartItem.setQuantity(quantity);
			if (quantity < 1) {
				removeCartItem(cartItem);
				System.out.println("Item: " + cartItem.getProduct().getProductLabel() + " was deleted due to 0 quantity.");
			}
		}
	}

	// Method removing existing cart item from the cart.
	public void removeCartItem(CartItem cartItem) {
		cartItems.remove(cartItem);
	}

	// Method outputting in the console the balance sheet for all products in the cart:
	// Total price, VAT, Delivery Fee, The final price with Delivery fee and VAT added .
	public void grandTotalOfCart() {
		System.out.printf("Total sum of all items in cart: %s%n" +
			"VAT: %s%n" +
			"Calculation of Delivery Fee: %s%n" +
			"Final price with Delivery Fee and VAT: %s%n", currencyFormat.format(totalSumOfAllItems()), currencyFormat.format(calculateVAT()), currencyFormat.format(calculateDeliveryFee()), currencyFormat.format(calculateEndPrice()));
	}

	// Method summing the price sums for all items in the cart.
	private double totalSumOfAllItems() {
		double sum = 0;
		for (CartItem cartItem : cartItems) {
			sum += cartItem.sumTotalPriceOfItem();
		}
		return sum;
	}

	// Method calculating VAT according to total price summation for all items.
	private double calculateVAT() {
		return totalSumOfAllItems() * 0.2;
	}

	// Method returning the Delivery Fee depending on the total sum.
	private double calculateDeliveryFee() {
		var totalSum = totalSumOfAllItems();
		if (totalSum < 100) {
			deliveryFee = 10.0;
		} else if (totalSum > 100 && totalSum < 200) {
			deliveryFee = 5.0;
		} else {
			deliveryFee = 0.0;
		}
		return deliveryFee;
	}

	// Method calculating the end price of all products in the cart with Delivery Fee and VAT.
	private double calculateEndPrice() {
		return totalSumOfAllItems() + deliveryFee + calculateVAT();
	}
}
