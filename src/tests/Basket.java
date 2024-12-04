package homework16_items_shop;

import homework16_items_shop.items.*;

import java.util.Arrays;

public class Basket {
    private Item[] basket;
    private Item[] gifts;

    protected Basket() {
        this.basket = new Item[0];
        this.gifts = new Item[0];
    }

    public void addItemToBasket(Item item) {
        for (Item basketItem : basket) {
            if (basketItem == item) {
                System.out.println("Item already exists in basket");
                return;
            }
        }
        Item[] newList = new Item[basket.length + 1];
        for (int i = 0; i < basket.length; i++) {
            newList[i] = basket[i];
        }
        newList[newList.length - 1] = item;
        basket = newList;
        Item gift;
        if (item instanceof TV || item instanceof Notebook) {
            gift = item instanceof TV ? new Smartphone(85000) : new HairDryer(28000);
            addGiftToGiftList(gift, item.getId());
        }
    }

    public int getItemsPrice() {
        int price = 0;
        for (Item item : basket) {
            price += item.getPrice();
        }
        return price;
    }

    public String[] getGifts() {
        String[] giftsList = new String[gifts.length];
        for (int i = 0; i < giftsList.length; i++) {
            giftsList[i] = "[Item:" + gifts[i].getItemName() + ",ID:" + gifts[i].getId() + ",Price:" + gifts[i].getPrice() + "]";
        }
        return giftsList;
    }

    public boolean checkGiftsInList() {
        int nullCounter = 0;
        String[] gifts = getGifts();
        for (String gift : gifts) {
            if (gift == null) {
                nullCounter++;
            }
        }
        return nullCounter == gifts.length - 1;
    }

    public void addGiftToGiftList(Item gift, int id) {
        Item[] newList = new Item[gifts.length + 1];
        for (int i = 0; i < gifts.length; i++) {
            newList[i] = gifts[i];
        }
        gift.setId(id);
        newList[newList.length - 1] = gift;
        gifts = newList;
    }

    public void deleteGiftFromGiftList(int id) {
        boolean idFound = false;
        for (Item gift : gifts) {
            if (gift.getId() == id) {
                idFound = true;
                break;
            }
        }

        if (!idFound) {
            System.out.println("Error: No gift with the specified ID found.");
            return;
        }

        int index = 0;
        Item[] newList = new Item[gifts.length - 1];
        for (Item gift : gifts) {
            if (gift.getId() != id) {
                newList[index++] = gift;
            }
        }
        gifts = newList;
    }


    public void deleteItemFromBasket(int id) {
        int index = 0;
        Item[] newList = new Item[basket.length - 1];
        for (Item item : basket) {
            if (item.getId() != id) {
                if (index < newList.length) {
                    newList[index++] = item;
                }
            }
        }
        basket = newList;
    }


    public String getBasket() {
        String[] itemsList = new String[basket.length];
        for (int i = 0; i < itemsList.length; i++) {
            itemsList[i] = "[Item:" + basket[i].getItemName() + ",ID:" + basket[i].getId() + ",Price:" + basket[i].getPrice() + "]";
        }
        return Arrays.toString(itemsList);
    }
}
