package homework16_items_shop;

public enum Items {
    Smartphone(1, 150_000), Laptop(2, 250_000), TV(3, 400_000), HairDryer(4, 55_000);
    private int ID;
    private final int PRICE;

    Items(int ID, int PRICE) {
        this.ID = ID;
        this.PRICE = PRICE;
    }

    public int getID() {
        return ID;
    }

    public int getPRICE() {
        return PRICE;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
