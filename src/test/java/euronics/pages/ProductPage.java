package euronics.pages;

import euronics.BaseFunctions;
import org.openqa.selenium.By;

import java.math.BigDecimal;

public class ProductPage {
    private final BaseFunctions baseFunc;

    public ProductPage(BaseFunctions baseFunc) {
        this.baseFunc = baseFunc;
    }

    private final By PRODUCT_NAME = By.xpath("//div[@class='container']//*[@id='product-description']");
    private final By PRODUCT_PRICE = By.xpath("//div[@class='pricing-block__bottom']//span[@class='price__original']");
    private final By ADD_TO_CART = By.xpath("//button[@data-target='added-cart-panel']");
    private final By CONTINUE_SHOPPING_BTN = By.xpath("//button[@ id='continue-button']");

    public String getProductName() {
        return baseFunc.getElement(PRODUCT_NAME).getText();
    }

    public BigDecimal getProductPrice() {
        String text = baseFunc.getElement(PRODUCT_PRICE).getText();
        return new BigDecimal(text.replace("€", "").trim());
    }

    public void addProductToCart() {
        baseFunc.click(ADD_TO_CART);
    }

    public void pressContinueShoppingBtn() {
        baseFunc.click(CONTINUE_SHOPPING_BTN);
    }
}
