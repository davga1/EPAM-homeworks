package homework16_items_shop;

import homework16_items_shop.customer.Customer;
import homework16_items_shop.exceptions.MoreGiftsThanExpectedException;
import homework16_items_shop.exceptions.NotEnoughBalanceException;

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
            throw new NotEnoughBalanceException("The provided customer balance is not enough to pay for items, please remove an Item from basket");
        }
        if (customer.getGifts().length > 1 && !customer.checkGiftsInList()) {
            throw new MoreGiftsThanExpectedException("User can take only one gift, please delete others");
        }
        customer.setBalance(balance - itemsPrice);
        System.out.println(customer.getName() + " purchased items " + customer.getBasket() + "Balance:" + balance + " - " + itemsPrice + " = " + customer.getBalance());
        System.out.println(customer.getGifts().length == 0 ? "" : "Customer also has gift:" + Arrays.toString(customer.getGifts()));
    }
}
