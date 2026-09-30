/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public abstract class Product implements Comparable<Product>, Borrowable {

    private Integer productId;
    private String name;
    private Double price;
    private Integer stockQuantity;

    private boolean available = true; // for Borrowable

    // No-arg constructor
    public Product() {
        this.productId = 0;
        this.name = "Unknown";
        this.price = 0.0;
        this.stockQuantity = 0;
        this.available = true;
    }

    // Full-argument constructor
    public Product(Integer productId, String name, Double price, Integer stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.available = true;
    }

    // Getters and Setters
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    // Borrowable implementation
    @Override
    public void checkOut() throws IllegalStateException {
        if (!available) {
            throw new IllegalStateException("Item is already checked out.");
        }
        this.available = false;
    }

    @Override
    public void checkIn() throws IllegalStateException {
        if (available) {
            throw new IllegalStateException("Item is already available.");
        }
        this.available = true;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    // Comparable<Product> - sort by name
    @Override
    public int compareTo(Product other) {
        if (other == null || other.getName() == null) {
            return 1;
        }
        if (this.name == null) {
            return -1;
        }
        return this.name.compareToIgnoreCase(other.getName());
    }

    // equals() based on productId
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Product other = (Product) obj;
        if (this.productId == null || other.productId == null) return false;
        return this.productId.equals(other.productId);
    }

    @Override
    public int hashCode() {
        return (productId == null) ? 0 : productId.hashCode();
    }

    // toString()
    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", available=" + available +
                '}';
    }
}
