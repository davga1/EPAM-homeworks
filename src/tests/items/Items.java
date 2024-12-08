package homework16_items_shop.items;

public enum Items {
    Smartphone(150_000, 1), Notebook(250_000, 2), HairDryer(55_000, 3), TV(300_000, 4);
    private final int PRICE;
    private final int ID;

    Items(int price, int id) {
        PRICE = price;
        ID = id;
    }

    public int getPRICE() {
        return PRICE;
    }

    public int getID() {
        return ID;
    }
}
