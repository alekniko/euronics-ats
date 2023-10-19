package euronics.pages;

import euronics.BaseFunctions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListPage {

    private final BaseFunctions baseFunc;

    public ProductListPage(BaseFunctions baseFunc) {
        this.baseFunc = baseFunc;
    }

    private final By PRODUCT_CARD = By.xpath("//*[@class='product-card vertical   ']//a[@class='product_name']");

    public ProductPage selectProduct(String productName) {
        List<WebElement> productList = baseFunc.getElements(PRODUCT_CARD);
        boolean isClicked = false;
        for (WebElement we : productList) {
            if (we.getText().equals(productName)) {
                baseFunc.scrollToElement(we);
                we.click();
                isClicked = true;
                break;
            }
        }
        Assertions.assertTrue(isClicked, "Not possible to click on product card");

        return new ProductPage(baseFunc);
    }
}
