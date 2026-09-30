/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
public class ProductNotFoundException extends Exception {

    public ProductNotFoundException() {
        super("Product not found in the catalog.");
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
