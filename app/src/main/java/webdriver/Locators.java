package webdriver;

import org.openqa.selenium.By;

public class Locators {
    public final By SEARCH_INPUT = By.name("_nkw");
    public final By SEARCH_BUTTON = By.id("gh-btn");
    public final By SEARCH_RESULTS = By.cssSelector(".s-item");
    public final By ADD_TO_CART_BUTTON = By.xpath("//span[text()='Add to cart']");
}
