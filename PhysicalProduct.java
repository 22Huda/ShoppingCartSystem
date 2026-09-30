/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class PhysicalProduct extends Product {

    private String brand;
    private Double weight; // in kg

    // No-arg constructor
    public PhysicalProduct() {
        super();
        this.brand = "Unknown";
        this.weight = 0.0;
    }

    // Full-argument constructor
    public PhysicalProduct(Integer productId, String name, Double price,
                           Integer stockQuantity, String brand, Double weight) {
        super(productId, name, price, stockQuantity);
        this.brand = brand;
        this.weight = weight;
    }

    // Getters and Setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "PhysicalProduct{" +
                "productId=" + getProductId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", stockQuantity=" + getStockQuantity() +
                ", available=" + isAvailable() +
                ", brand='" + brand + '\'' +
                ", weight=" + weight +
                '}';
    }
}
