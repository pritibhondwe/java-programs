import java.util.*;

class CoffeeItem {
    String name;
    double price;

    CoffeeItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class CoffeeShop {
    private static List<CoffeeItem> menu = new ArrayList<>();
    private static List<CoffeeItem> cart = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadMenu();
        boolean running = true;

        while (running) {
            System.out.println("\n☕==== Welcome to Java Coffee Shop ====");
            System.out.println("1. View Menu");
            System.out.println("2. View Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    showMenu();
                    break;
                case 2:
                    showCart();
                    break;
                case 3:
                    checkout();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you! Visit Again ☕");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void loadMenu() {
        menu.add(new CoffeeItem("Espresso", 120));
        menu.add(new CoffeeItem("Cappuccino", 150));
        menu.add(new CoffeeItem("Latte", 170));
        menu.add(new CoffeeItem("Mocha", 180));
    }

    private static void showMenu() {
        System.out.println("\n--- Coffee Menu ---");
        for (int i = 0; i < menu.size(); i++) {
            System.out.printf("%d. %s - ₹%.2f%n", i + 1, menu.get(i).name, menu.get(i).price);
        }
        System.out.print("Select coffee number to add to cart (0 to go back): ");
        int choice = sc.nextInt();

        if (choice > 0 && choice <= menu.size()) {
            cart.add(menu.get(choice - 1));
            System.out.println(menu.get(choice - 1).name + " added to cart!");
        }
    }

    private static void showCart() {
        if (cart.isEmpty()) {
            System.out.println("\nYour cart is empty.");
            return;
        }

        System.out.println("\n--- Your Cart ---");
        double total = 0;
        for (int i = 0; i < cart.size(); i++) {
            System.out.printf("%d. %s - ₹%.2f%n", i + 1, cart.get(i).name, cart.get(i).price);
            total += cart.get(i).price;
        }
        System.out.printf("Total: ₹%.2f%n", total);

        System.out.print("Enter item number to remove (0 to go back): ");
        int choice = sc.nextInt();
        if (choice > 0 && choice <= cart.size()) {
            System.out.println(cart.get(choice - 1).name + " removed from cart.");
            cart.remove(choice - 1);
        }
    }

    private static void checkout() {
        if (cart.isEmpty()) {
            System.out.println("\nYour cart is empty!");
            return;
        }
        double total = 0;
        for (CoffeeItem item : cart) {
            total += item.price;
        }
        System.out.printf("\nThank you for your order! ☕ Total Amount: ₹%.2f%n", total);
        cart.clear();
    }
}
