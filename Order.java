/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.Date;

public class Order {

    private Integer orderId;
    private Customer customer;
    private ArrayList<Product> items;
    private Date orderDate;
    private String status; // e.g. "PENDING", "PAID", "CANCELLED"

    // No-arg constructor
    public Order() {
        this.orderId = 0;
        this.customer = null;
        this.items = new ArrayList<>();
        this.orderDate = new Date();
        this.status = "PENDING";
    }

    // Full-argument constructor
    public Order(Integer orderId, Customer customer, ArrayList<Product> items,
                 Date orderDate, String status) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = items;
        this.orderDate = orderDate;
        this.status = status;
    }

    // Getters and Setters
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public void setItems(ArrayList<Product> items) {
        this.items = items;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Calculate total
    public Double getOrderTotal() {
        Double total = 0.0;
        if (items == null) return total;
        for (Product p : items) {
            if (p != null && p.getPrice() != null) {
                total += p.getPrice();
            }
        }
        return total;
    }

    @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Order Details:\n");
    sb.append("Order ID: ").append(orderId).append("\n");
    sb.append("Customer: ").append(customer.getName())
      .append(" (ID: ").append(customer.getCustomerId())
      .append(", Email: ").append(customer.getEmail()).append(")\n");
    sb.append("Date: ").append(orderDate).append("\n");
    sb.append("Status: ").append(status).append("\n");
    sb.append("Total: ").append(getOrderTotal()).append("\n");
    sb.append("Items:\n");

    for (Product p : items) {
        sb.append(" - ").append(p.getName())
          .append(" (ID: ").append(p.getProductId())
          .append(", Price: ").append(p.getPrice())
          .append(")\n");
    }

    return sb.toString();
}
}
