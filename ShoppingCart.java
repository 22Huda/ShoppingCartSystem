/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;

public class ShoppingCart {

    private Customer owner;
    private ArrayList<Product> items;

    // No-arg constructor
    public ShoppingCart() {
        this.owner = null;
        this.items = new ArrayList<>();
    }

    // Constructor with owner
    public ShoppingCart(Customer owner) {
        this.owner = owner;
        this.items = new ArrayList<>();
    }

    // Getters and Setters
    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    // Add one unit of product to cart
    public void addProduct(Product product) {
        if (product == null) {
            System.out.println("Cannot add null product to cart.");
            return;
        }
        if (product.getStockQuantity() != null && product.getStockQuantity() <= 0) {
            System.out.println("Product \"" + product.getName() + "\" is out of stock.");
            return;
        }
        items.add(product);
        System.out.println("Added product to cart: " + product.getName());
    }

    // Remove first occurrence of product with given ID
    public void removeProductById(Integer productId) {
        if (productId == null) {
            System.out.println("Product ID cannot be null.");
            return;
        }
        Product toRemove = null;
        for (Product p : items) {
            if (p != null && p.getProductId() != null &&
                p.getProductId().equals(productId)) {
                toRemove = p;
                break;
            }
        }

        if (toRemove != null) {
            items.remove(toRemove);
            System.out.println("Removed product with ID " + productId + " from cart.");
        } else {
            System.out.println("Product with ID " + productId + " not found in cart.");
        }
    }

    // Calculate total price
    public Double calculateTotal() {
        Double total = 0.0;
        for (Product p : items) {
            if (p != null && p.getPrice() != null) {
                total += p.getPrice();
            }
        }
        return total;
    }

    // Clear cart
    public void clearCart() {
        items.clear();
        System.out.println("Cart cleared.");
    }

    // Print details
    public void printCartDetails() {
        System.out.println("Shopping Cart for: " +
                (owner != null ? owner.getName() : "Unknown customer"));
        for (Product p : items) {
            System.out.println(p);
        }
        System.out.println("Total: " + calculateTotal());
    }
}
