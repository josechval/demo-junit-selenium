package webdriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EbaySearchPage {
    private WebDriver driver;
    private Locators locators;

    public EbaySearchPage(WebDriver driver) {
        this.driver = driver;
        this.locators = new Locators();
    }

    public void searchForTerm(String term) {
        WebElement searchInputElem = driver.findElement(locators.SEARCH_INPUT);
        searchInputElem.sendKeys(term);
    }

    public void clickSearchButton() {
        WebElement searchButtonElem = driver.findElement(locators.SEARCH_BUTTON);
        searchButtonElem.click();
    }

    public List<WebElement> getSearchResults() {
        return driver.findElements(locators.SEARCH_RESULTS);
    }

    public void clickAddToCartButton(int itemIndex) {
        List<WebElement> addToCartButtons = driver.findElements(locators.ADD_TO_CART_BUTTON);
        if (itemIndex >= 0 && itemIndex < addToCartButtons.size()) {
            addToCartButtons.get(itemIndex).click();
        }
    }
}
