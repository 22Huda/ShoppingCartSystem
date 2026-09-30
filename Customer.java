/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;

public class Customer implements Comparable<Customer>, Cloneable {

    private Integer customerId;
    private String name;
    private String email;

    // Composition: each customer has a shopping cart
    private ShoppingCart cart;

    // Composition: customer holds their orders
    private ArrayList<Order> orders;

    // No-arg constructor
    public Customer() {
        this.customerId = 0;
        this.name = "Unknown";
        this.email = "unknown@example.com";
        this.cart = new ShoppingCart(this);
        this.orders = new ArrayList<>();
    }

    // Full-argument constructor
    public Customer(Integer customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.cart = new ShoppingCart(this);
        this.orders = new ArrayList<>();
    }

    // Getters and Setters
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        if (order != null) {
            this.orders.add(order);
        }
    }

    // Comparable<Customer> - sort by name
    @Override
    public int compareTo(Customer other) {
        if (other == null || other.getName() == null) {
            return 1;
        }
        if (this.name == null) {
            return -1;
        }
        return this.name.compareToIgnoreCase(other.getName());
    }

    // equals based on customerId
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Customer other = (Customer) obj;
        if (this.customerId == null || other.customerId == null) return false;
        return this.customerId.equals(other.customerId);
    }

    @Override
    public int hashCode() {
        return (customerId == null) ? 0 : customerId.hashCode();
    }

    // clone() - copy basic info, new cart and empty orders list
    @Override
    public Object clone() throws CloneNotSupportedException {
        Customer cloned = (Customer) super.clone();
        cloned.cart = new ShoppingCart(cloned);
        cloned.orders = new ArrayList<>();
        return cloned;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    boolean hasActiveOrders() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
