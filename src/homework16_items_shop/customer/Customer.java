package homework16_items_shop.customer;

import homework16_items_shop.Items;
import homework16_items_shop.exceptions.MoreGiftsThanExpectedException;
import homework16_items_shop.exceptions.NotEnoughBalanceException;

import java.util.Arrays;

public class Customer {
    private final String name;
    private int balance;
    private final String cardType;
    private Items[] basket;
    private Items[] gifts;

    public Customer(String name, int balance, String cardType) {
        this.name = name;
        this.balance = balance;
        this.cardType = cardType;
        basket = new Items[0];
        gifts = new Items[0];
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

    public void addItemToBasket(Items item) {
        for (Items basketItem : basket) {
            if (basketItem.getID() == item.getID()) {
                System.out.println("Item already exists in the basket.");
                return;
            }
        }
        Items[] newList = new Items[basket.length + 1];
        for (int i = 0; i < basket.length; i++) {
            newList[i] = basket[i];
        }
        newList[newList.length - 1] = item;
        basket = newList;

        // Add gift logic
        if (item == Items.TV || item == Items.Laptop) {
            Items gift = (item == Items.TV) ? Items.Smartphone : Items.HairDryer;
            addGiftToGiftList(gift);
        }
    }

    private void addGiftToGiftList(Items gift) {
        Items[] newList = new Items[gifts.length + 1];
        for (int i = 0; i < gifts.length; i++) {
            newList[i] = gifts[i];
        }
        newList[newList.length - 1] = gift;
        gifts = newList;
    }

    public Items[] getBasket() {
        return basket;
    }

    public Items[] getGifts() {
        return gifts;
    }

    public int getItemsPrice(Items[] basket) {
        int price = 0;
        for (Items item : basket) {
            price += item.getPRICE();
        }
        return price;
    }

    public void deleteItemFromBasket(int id) {
        if (basket.length == 0) {
            System.out.println("Error: No items in the basket to delete.");
            return;
        }

        boolean itemFound = false;
        int index = 0;
        Items[] newList = new Items[basket.length - 1];

        for (Items item : basket) {
            if (item.getID() == id) {
                itemFound = true;
                if (item == Items.TV || item == Items.Laptop) {
                    deleteGiftFromGiftList((item == Items.TV) ? Items.Smartphone.getID() : Items.HairDryer.getID());
                }
            } else if (index < newList.length) {
                newList[index++] = item;
            }
        }

        if (!itemFound) {
            System.out.println("Error: No item with the specified ID found in the basket.");
            return;
        }

        basket = newList;
        System.out.println("Item with ID " + id + " deleted successfully from the basket.");
    }

    public void deleteGiftFromGiftList(int id) {
        if (gifts.length == 0) {
            System.out.println("Error: No gifts to delete.");
            return;
        }

        boolean idFound = false;
        int index = 0;
        Items[] newList = new Items[gifts.length - 1];

        for (Items gift : gifts) {
            if (gift != null && gift.getID() == id) {
                idFound = true;
            } else if (index < newList.length) {
                newList[index++] = gift;
            }
        }

        if (!idFound) {
            System.out.println("Error: No gift with the specified ID found.");
            return;
        }

        gifts = newList;
        System.out.println("Gift with ID " + id + " deleted successfully.");
    }


    public void purchaseItems() {
        int balance = getBalance();
        int itemsPrice = getItemsPrice(basket);
        if (balance - itemsPrice < 0) {
            throw new NotEnoughBalanceException("The provided customer balance is not enough to pay for items, please remove an Item from basket");
        }
        if (getGifts().length > 1) {
            throw new MoreGiftsThanExpectedException("User can take only one gift, please delete others");
        }
        setBalance(balance - itemsPrice);
        System.out.println((name + " purchased items " + Arrays.toString(basket) + "Balance:" + balance + " - " + itemsPrice + " = " + getBalance()));
        System.out.println(gifts.length == 0 ? "" : "Customer also has gift:" + Arrays.toString(gifts));
    }
}

