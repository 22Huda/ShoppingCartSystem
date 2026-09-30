/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.Scanner;

public class StoreApp {

    private static int readInt(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim();
            try { return Integer.parseInt(s); }
            catch (NumberFormatException e) { System.out.println("⚠️ أدخلي رقم صحيح."); }
        }
    }

    private static int readChoice(Scanner in, String prompt, int min, int max) {
        while (true) {
            int v = readInt(in, prompt);
            if (v >= min && v <= max) return v;
            System.out.println("⚠️ اختاري رقم بين " + min + " و " + max + ".");
        }
    }

    private static String readNonEmpty(Scanner in, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = in.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("⚠️ الحقل لا يمكن أن يكون فارغ.");
        }
    }

    public static void main(String[] args) {

        Store store = new Store("Online Shopping Store");
        store.seedDemoProducts(); // نجهّز المنتجات للعرض المباشر

        Scanner in = new Scanner(System.in);
        System.out.println("=== Welcome to Shopping Cart System ===");

        // 1) معلومات المستخدم أولاً
        int custId   = readInt(in, "Enter your ID: ");
        String name  = readNonEmpty(in, "Enter your name: ");
        String email = readNonEmpty(in, "Enter your email: ");

        Customer current = new Customer(custId, name, email);
        store.registerCustomer(current);
        System.out.println("✅ Welcome, " + current.getName() + "!");

        // 2) عرض المنتجات مرقّمة
        store.printCatalogIndexed();

        // 3) اختيار منتج بالرقم وإضافته للسلة
        while (true) {
            int idx = readInt(in, "\nEnter product number to add (0 to stop): ");
            if (idx == 0) break;

            Product chosen = store.getProductByIndex(idx);
            if (chosen == null) {
                System.out.println(" رقم المنتج غير صحيح.");
            } else {
                current.getCart().addProduct(chosen);
            }
        }

        // 4) قائمة بسيطة لباقي العمليات
        while (true) {
            System.out.println("\n--- Actions ---");
            System.out.println("1) Add more products");
            System.out.println("2) View cart");
            System.out.println("3) Checkout");
            System.out.println("4) Exit");

            int action = readChoice(in, "Choose: ", 1, 4);

            switch (action) {
                case 1:
                    store.printCatalogIndexed();
                    int idx = readInt(in, "Enter product number to add (0 to cancel): ");
                    if (idx == 0) break;
                    Product p = store.getProductByIndex(idx);
                    if (p == null) System.out.println(" رقم غير صحيح.");
                    else current.getCart().addProduct(p);
                    break;

                case 2:
                    current.getCart().printCartDetails();
                    break;

                case 3:
                    if (current.getCart().getItems().isEmpty()) {
                        System.out.println("️ Cart is empty.");
                        break;
                    }
                    Order order = new Order();
                    order.setOrderId((int)(Math.random()*10000));
                    order.setCustomer(current);
                    order.setItems(new ArrayList<>(current.getCart().getItems()));
                    order.setStatus("PAID");
                    current.addOrder(order);
                    System.out.println(" Order created:");
                    System.out.println(order);
                    current.getCart().clearCart();
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
            }
        }
    }
}
