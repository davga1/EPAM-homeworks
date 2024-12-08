package homework16_items_shop;

import homework16_items_shop.customer.Customer;
import tests.exceptions.MoreGiftsThanExpectedException;
import tests.exceptions.NotEnoughBalanceException;

import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer("ADds", 450000, "amex");
        customer.addItemToBasket(Items.Smartphone);
        customer.addItemToBasket(Items.Laptop);
        customer.addItemToBasket(Items.TV);
        System.out.println(Arrays.toString(customer.getBasket()));
        System.out.println(customer.getItemsPrice(customer.getBasket()));
        System.out.println(Arrays.toString(customer.getGifts()));
        boolean purchaseSuccessful = false;
        while (!purchaseSuccessful) {
            try {
                customer.purchaseItems();
                purchaseSuccessful = true;
                System.out.println("Purchase successful!");
            } catch (MoreGiftsThanExpectedException e) {
                if (customer.getGifts().length == 0) {
                    System.out.println("No more gifts to delete.");
                    break;
                }
                System.out.println("There is more than one gift, please enter the ID of an item whose gift you want to delete:");
                int id = scanner.nextInt();
                customer.deleteGiftFromGiftList(id);
            } catch (NotEnoughBalanceException e) {
                if (customer.getBasket().length == 0) {
                    System.out.println("No more items in the basket to delete.");
                    break;
                }
                System.out.println("Customer's balance is not enough to purchase items. Please enter the ID of an item you want to delete:");
                int id = scanner.nextInt();
                customer.deleteItemFromBasket(id);
            }
        }
    }
}