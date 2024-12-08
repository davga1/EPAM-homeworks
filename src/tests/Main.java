package homework16_items_shop;

import homework16_items_shop.customer.Customer;
import homework16_items_shop.exceptions.MoreGiftsThanExpectedException;
import homework16_items_shop.exceptions.NotEnoughBalanceException;
import homework16_items_shop.items.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TV tv = new TV(15000);
        Notebook notebook = new Notebook(35000);
        Smartphone smartphone = new Smartphone(45000);
        Customer customer = new Customer("Armen", 150000, "Amex");
        Notebook notebook2 = new Notebook(10000);
        customer.addItemToBasket(tv);
        customer.addItemToBasket(tv);
        customer.addItemToBasket(notebook);
        customer.addItemToBasket(smartphone);
        customer.addItemToBasket(notebook2);
        ItemsShop shop = new ItemsShop(customer);

        Scanner scanner = new Scanner(System.in);

        boolean purchaseSuccessful = false;
        while (!purchaseSuccessful) {
            try {
                shop.purchaseItems();
                purchaseSuccessful = true;
                System.out.println("Purchase successful!");
            } catch (MoreGiftsThanExpectedException e) {
                System.out.println("There is more than one gift, please enter the ID of an item whose gift you want to delete:");
                System.out.println(Arrays.toString(customer.getGifts()) + "132131");
                int id = scanner.nextInt();
                customer.deleteGiftFromGiftList(id);
            } catch (NotEnoughBalanceException e) {
                System.out.println("Customer's balance is not enough to purchase items. Please enter the ID of an item you want to delete:");
                int id = scanner.nextInt();
                customer.deleteItemFromBasket(id);
                customer.deleteGiftFromGiftList(id);
            }
        }
    }
}