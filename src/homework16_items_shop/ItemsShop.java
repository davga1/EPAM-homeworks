package homework16_items_shop;

import homework16_items_shop.customer.Customer;

import java.util.Arrays;

public class ItemsShop {
    private final Customer customer;

    public ItemsShop(Customer customer) {
        this.customer = customer;
    }

    public void purchaseItems() {
        int balance = customer.getBalance();
        int itemsPrice = customer.getItemsPrice();
        if (balance - itemsPrice < 0) {
            throw new RuntimeException("Balance is not enough to buy items");
        }
        if (customer.getGifts().length > 1 && !customer.checkGiftsInList()) {
            throw new RuntimeException("Customer can have only one gift");
        }
        customer.setBalance(balance - itemsPrice);
        System.out.println(customer.getName() + " purchased items " + customer.getBasket() + "Balance:" + balance + " - " + itemsPrice + " = " + customer.getBalance());
        System.out.println("Customer also has gift:" + Arrays.toString(customer.getGifts()));
    }


}
