public class ConstantValues {
    static final String PATH_TO_PRODUCTS_LIST_ITEM_SELECTOR = "./div[2]/a/dl/";
    static final String LOCATOR_SELECTOR = "a[href='/c/bags']";
    static final String WEBSITE_LINK = "https://6pm.com";
    static final String LUGGAGE_LOCATOR_SELECTOR = "//a[text()='Luggage']";
    static final String PRODUCTS_LIST_SELECTOR = "//div[@id='products']/article";
    static final String ITEM_STANDARD = "//div[@itemtype=\"http://schema.org/Product\"]/div/div/div/div[2]/div";
    static final String LUGGAGE_NAME = ITEM_STANDARD + "/div/div/h1/div/span[2]";
    static final String LUGGAGE_PRICE = ITEM_STANDARD + "/div[1]/div[2]/div/div/span/span[1]";
    static final String ADD_TO_CART_BUTTON_SELECTOR = "//*[@id=\"add-to-cart-button\"]";
    static final String REMOVE_ITEM_SELECTOR = "//div[5]/div/div[2]/div/div[2]/div[2]/button";
    static final String SIGN_IN_BUTTON_SELECTOR = "//div[5]/div/div[2]/div[2]/a";
}

