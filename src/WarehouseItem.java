public class WarehouseItem implements Stockable {
    private final String itemId;
    private final String itemName;
    private int quantity;
    private final int restockAmount;

    public WarehouseItem(String itemId, String itemName, int quantity, int restockAmount) {
        if (itemId == null || itemId.trim().isEmpty()
                || itemName == null || itemName.trim().isEmpty()) {
            throw new IllegalArgumentException("ID and name cannot be empty.");
        }
        if (quantity < 0 || restockAmount <= 0) {
            throw new IllegalArgumentException("Invalid quantity or restock amount.");
        }
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.restockAmount = restockAmount;
    }

    @Override
    public void restock() {
        if (quantity > Integer.MAX_VALUE - restockAmount) {
            System.out.println("Cannot restock: quantity limit reached.");
            return;
        }
        quantity += restockAmount;
        System.out.println("Restocked successfully! Added " + restockAmount + " units.");
        System.out.println("Current stock: " + quantity);
    }

    public void useStock(int amount) {
        if (amount <= 0) {
            System.out.println("Enter an amount greater than zero.");
        } else if (amount > quantity) {
            System.out.println("Insufficient stock! Available units: " + quantity);
        } else {
            quantity -= amount;
            System.out.println("Issued " + amount + " units successfully.");
            System.out.println("Remaining stock: " + quantity);
        }
    }

    public void displayDetails() {
        System.out.println("\n----- ITEM DETAILS -----");
        System.out.println("Item ID        : " + itemId);
        System.out.println("Item name      : " + itemName);
        System.out.println("Available stock: " + quantity);
        System.out.println("Restock amount : " + restockAmount);
    }
}
