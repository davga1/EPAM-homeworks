package homework5.pages;

public class BasePage {
    public Header header;

    public BasePage() {
        header = new Header();
    }

    public static class Header {
        public String candidateDropdown = "//div[contains(text(),\"Candidate\")]";
    }
}
