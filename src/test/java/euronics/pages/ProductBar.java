package euronics.pages;

import euronics.BaseFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductBar {

    private final BaseFunctions baseFunc;

    public ProductBar(BaseFunctions baseFunc) {
        this.baseFunc = baseFunc;
    }

    private final By PRODUCT_CATEGORY_ITEMS = By.xpath("//nav[@class='main-nav']//span[@class='nav-item__label-name']");
    private final By PRODUCT_TYPE_ITEMS = By.xpath("//*[@class='sub-menu__title' and text()='Phones']/..//*[@class='bottom-level__item__title']");

    public void selectProductCategory(String productCategoryName) {
        List<WebElement> menuItems = baseFunc.getElements(PRODUCT_CATEGORY_ITEMS);
        boolean isClicked = false;
        for (WebElement we : menuItems) {
            if (we.getText().equals(productCategoryName)) {
                we.click();
                isClicked = true;
                break;
            }
        }
    }

    public void selectProductType(String productTypeName) {
        List<WebElement> menuItems = baseFunc.getElements(PRODUCT_TYPE_ITEMS);
        boolean isClicked = false;
        for (WebElement we : menuItems) {
            if (we.getText().equals(productTypeName)) {
                we.click();
                isClicked = true;
                break;
            }
        }
    }
}
