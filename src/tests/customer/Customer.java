package homework16_items_shop.customer;

import homework16_items_shop.Basket;

public class Customer extends Basket {
    private final String name;
    private int balance;
    private final String cardType;

    public Customer(String name, int balance, String cardType) {
        super();
        this.name = name;
        this.balance = balance;
        this.cardType = cardType;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public String getCardType() {
        return cardType;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
