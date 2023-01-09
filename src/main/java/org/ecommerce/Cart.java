package org.ecommerce;

import java.util.ArrayList;

/**
 * The Cart class is used to add delivery fee and VAT to the items from the Cart.
 *
 * @author Evgeni Georgiev
 * @version 1.0
 */
public class Cart {
	private final ArrayList<CartItem> cartItems = new ArrayList<>();
	private double deliveryFee;

	public double getDeliveryFee() {
		return this.deliveryFee;
	}

	// Method outputting details for single product(label, price, quantity, result sum for price and quantity).
	public void runProductsInCartOutput() {
		cartItems.forEach(e -> System.out.println(e.runCartItemOutput()));
	}

	// Add new product to the cart.
	public void addCartItem(CartItem cartItem) {
		cartItems.add(cartItem);
	}

	// Method decreasing the count of quantity of single product by n-count(additional functionality).
	// When the quantity is less than 1 the product is removed from the cart.
	public void decreaseQuantityForItem(CartItem cartItem, int decreaseCountBy) {
		int getQuantity = cartItem.getQuantity();
		if(decreaseCountBy > getQuantity) {
			System.out.printf("Operation cannot be performed: Decrease count is less than quantity. Item: %s's quantity stays unchanged. %n", cartItem.getProduct().getProductLabel());
		} else {
			getQuantity -= decreaseCountBy;
			cartItem.setQuantity(getQuantity);

			if (getQuantity < 1) {
				removeCartItem(cartItem);
				System.out.println("Item: " + cartItem.getProduct().getProductLabel() + " was deleted due to 0 quantity.");
			}
		}
	}

	// Method outputting in the console the balance sheet for all products in the cart:
	// Total price, VAT, Delivery Fee, The final price with Delivery fee and VAT added .
	public void runCartProcessedDataOutput() {
		System.out.printf("Total sum of all items in cart: $%.2f%n" +
			"Sum of all items + VAT: $%.2f%n" +
			"Calculation of Delivery Fee: $%.2f%n" +
			"Final price with Delivery Fee and VAT: $%.2f%n", totalSumOfAllItems(), calculateTotalSumWithVAT(), calculateDeliveryFee(), endPriceSummation());
	}

	// Method summing the price sums for all items in the cart.
	private double totalSumOfAllItems() {
		double sum = 0;
		for (CartItem element : cartItems) {
			sum += element.sumPriceAndQuantityOfSingleItemInCart();
		}
		return sum;
	}

	// Method calculating VAT according to total price summation for all items.
	private double calculateTotalSumWithVAT() {
		return totalSumOfAllItems() * 0.2;
	}

	// Method returning the Delivery Fee according to the certain conditions.
	private double calculateDeliveryFee() {
		if (totalSumOfAllItems() < 100) {
			deliveryFee = 10.0;
		} else if (totalSumOfAllItems() > 100 && totalSumOfAllItems() < 200) {
			deliveryFee = 5.0;
		} else {
			deliveryFee = 0.0;
		}
		return deliveryFee;
	}

	// Method calculating the end price of all products in the cart with Delivery Fee and VAT.
	private double endPriceSummation() {
		return (totalSumOfAllItems() + getDeliveryFee()) + calculateTotalSumWithVAT();
	}

	// Method removing existing products from the cart.
	private void removeCartItem(CartItem cartItem) {
		cartItems.remove(cartItem);
	}

}
