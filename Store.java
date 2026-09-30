/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Store {

    private String name;
    private ArrayList<Product> catalog;
    private TreeSet<Customer> customers;

    // No-arg constructor
    public Store() {
        this.name = "My Store";
        this.catalog = new ArrayList<>();
        this.customers = new TreeSet<>();
    }

    // Full-argument constructor
    public Store(String name) {
        this.name = name;
        this.catalog = new ArrayList<>();
        this.customers = new TreeSet<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public ArrayList<Product> getCatalog() {
        return catalog;
    }

    public TreeSet<Customer> getCustomers() {
        return customers;
    }

    // Add product
    public void addProduct(Product product) {
        if (product != null) {
            catalog.add(product);
        }
    }

    // Register customer
    public void registerCustomer(Customer customer) {
        if (customer != null) {
            customers.add(customer);
        }
    }

    // Find product by ID (throws custom + can throw NullPointerException)
    public Product findProductById(Integer productId)
            throws ProductNotFoundException, NullPointerException {

        if (productId == null) {
            throw new NullPointerException("Product ID is null.");
        }

        for (Product p : catalog) {
            if (p != null && p.getProductId() != null &&
                p.getProductId().equals(productId)) {
                return p;
            }
        }

        throw new ProductNotFoundException(
                "Product with ID " + productId + " not found in the catalog.");
    }

    // Find customer by ID (returns null if not found)
    public Customer findCustomerById(Integer customerId) {
        if (customerId == null) {
            return null;
        }

        for (Customer c : customers) {
            if (c != null && c.getCustomerId() != null &&
                c.getCustomerId().equals(customerId)) {
                return c;
            }
        }
        return null;
    }

    // Sort catalog
    public void sortCatalogByName() {
        Collections.sort(catalog);
    }

    // Print catalog
    public void printCatalog() {
        System.out.println("Catalog of " + name + ":");
        for (Product p : catalog) {
            System.out.println(p);
        }
    }

    // Compare two products using equals()
    public void compareTwoProducts(Product p1, Product p2) {
        if (p1 == null || p2 == null) {
            System.out.println("One of the products is null.");
            return;
        }
        if (p1.equals(p2)) {
            System.out.println("Products are equal (same ID).");
        } else {
            System.out.println("Products are NOT equal.");
        }
    }


  
// يعبي المتجر بمنتجات جاهزة للعرض مرة واحدة
public void seedDemoProducts() {
    if (catalog == null) return;
    if (!catalog.isEmpty()) return; // لا نكرّر لو مضافة

    addProduct(new PhysicalProduct(1, "Laptop", 3500.0, 10, "Lenovo", 2.5));
    addProduct(new PhysicalProduct(2, "Smartphone", 2500.0, 15, "Samsung", 0.5));
    addProduct(new PhysicalProduct(3, "Wireless Mouse", 80.0, 50, "Logitech", 0.2));
    addProduct(new PhysicalProduct(4, "Headphones", 180.0, 30, "Sony", 0.3));
    addProduct(new PhysicalProduct(5, "Keyboard", 120.0, 25, "Keychron", 0.7));
}

// يطبع المنتجات مرقّمة 1..n بكل الخصائص
public void printCatalogIndexed() {
    if (catalog == null || catalog.isEmpty()) {
        System.out.println("(catalog is empty)");
        return;
    }
    sortCatalogByName();
    System.out.println("\n=== Products ===");
    int i = 1;
    for (Product p : catalog) {
        String extra = "";
        if (p instanceof PhysicalProduct) {
            PhysicalProduct pp = (PhysicalProduct) p;
            extra = " | brand=" + pp.getBrand() + " | weight=" + pp.getWeight();
        }
        System.out.println((i++) + ") " + p.getName()
                + " | ID=" + p.getProductId()
                + " | price=" + p.getPrice()
                + " | stock=" + p.getStockQuantity()
                + extra);
    }
}

// يرجّع المنتج حسب ترتيبه المعروض (1-based)
public Product getProductByIndex(int indexOneBased) {
    if (catalog == null) return null;
    if (indexOneBased < 1 || indexOneBased > catalog.size()) return null;
    sortCatalogByName();
    return catalog.get(indexOneBased - 1);
}

}