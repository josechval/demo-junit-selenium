package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    public static void main(String[] args) {
        // Establece la ruta al ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/home/josech/Descargas/chromedriver_linux64/chromedriver");

        // Opciones para configurar el navegador
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); // Iniciar maximizado
        chromeOptions.addArguments("--disable-extensions"); // Deshabilitar extensiones

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.ebay.com/");

        EbaySearchPage ebaySearchPage = new EbaySearchPage(driver);
        ebaySearchPage.searchForTerm("laptop");
        ebaySearchPage.clickSearchButton();

        List<Item> items = new ArrayList<>();
        List<WebElement> searchResults = ebaySearchPage.getSearchResults();

        for (WebElement result : searchResults) {
            String title = result.findElement(By.cssSelector(".s-item__title")).getText();
            String description = result.findElement(By.cssSelector(".s-item__subtitle")).getText();
            String url = result.findElement(By.cssSelector(".s-item__info > a")).getAttribute("href");
            String price = result.findElement(By.cssSelector(".s-item__price")).getText();
            items.add(new Item(title, description, url, price));
        }

        // Specify the CSV file path
        String csvFilePath = "items.csv";
        CsvUtil.writeItemsToCsv(items, csvFilePath);

        // Adding two items to the cart
        ebaySearchPage.clickAddToCartButton(0); // Add the first item to the cart
        ebaySearchPage.clickAddToCartButton(1); // Add the second item to the cart

        // Assert your conditions here
        assertEquals(2, 2); // Example assertion, modify as needed

        driver.quit();
    }
}
