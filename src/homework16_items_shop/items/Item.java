package homework16_items_shop.items;

public abstract class Item {
    private int id;
    private final int price;
    private static int idCounter = 1;
    private final String itemName;

    public Item(int price, String itemName) {
        this.id = idCounter++;
        this.price = price;
        this.itemName = itemName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id; // Allow explicit setting of ID
    }

    public int getPrice() {
        return price;
    }

    public String getItemName() {
        return itemName;
    }
}
