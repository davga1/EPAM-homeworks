package homework16_items_shop;

import homework16_items_shop.customer.Customer;
import homework16_items_shop.items.*;

public class Main {
    public static void main(String[] args) {
        TV tv = new TV(15000);
        Notebook notebook = new Notebook(35000);
        Smartphone smartphone = new Smartphone(45000);
        Customer a = new Customer("name", 150000, "Amex");
        Notebook notebook2 = new Notebook(10000);
        a.addItemToBasket(tv);
        a.addItemToBasket(tv);
        a.addItemToBasket(notebook);
        a.addItemToBasket(smartphone);
        a.addItemToBasket(notebook2);
        ItemsShop shop = new ItemsShop(a);
        a.deleteGiftFromGiftList(tv.getId());
        a.deleteGiftFromGiftList(notebook2.getId());
        shop.purchaseItems();
    }
}
