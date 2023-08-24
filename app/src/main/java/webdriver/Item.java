package webdriver;

public class Item {
    private String title;
    private String description;
    private String url;
    private String price;

    public Item(String title, String description, String url, String price) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getPrice() {
        return price;
    }
}
