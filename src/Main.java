import java.util.Scanner;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("WAREHOUSE INVENTORY SYSTEM");
            String id = readText(scanner, "Enter item ID: ");
            String name = readText(scanner, "Enter item name: ");
            int quantity = readInteger(scanner, "Enter starting quantity: ", 0);
            int restockAmount = readInteger(scanner, "Enter units added per restock: ", 1);
            WarehouseItem item = new WarehouseItem(id, name, quantity, restockAmount);
            // An interface reference demonstrates polymorphism.
            Stockable stockable = item;
            boolean running = true;
            while (running) {
                System.out.println("\n1. View item details\n2. Restock item\n3. Issue stock\n4. Exit");
                int choice = readInteger(scanner, "Enter your choice: ", 1);
                switch (choice) {
                    case 1:
                        item.displayDetails();
                        break;
                    case 2:
                        stockable.restock();
                        break;
                    case 3:
                        item.useStock(readInteger(scanner, "Enter quantity to issue: ", 1));
                        break;
                    case 4:
                        running = false;
                        System.out.println("Thank you! Program closed.");
                        break;
                    default:
                        System.out.println("Select 1, 2, 3, or 4.");
                }
            }
        } catch (NoSuchElementException exception) {
            System.out.println("\nInput closed. Program ended.");
        }
    }

    private static String readText(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) return value;
            System.out.println("Input cannot be empty.");
        }
    }

    private static int readInteger(Scanner scanner, String prompt, int minimum) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= minimum) return value;
                System.out.println("Enter a whole number >= " + minimum + ".");
            } catch (NumberFormatException exception) {
                System.out.println("Invalid input. Enter a whole number.");
            }
        }
    }
}
