package euronics.pages;

import euronics.BaseFunctions;
import org.openqa.selenium.By;

import java.math.BigDecimal;

public class CartPage {
    private final BaseFunctions baseFunc;

    public CartPage(BaseFunctions baseFunc) {
        this.baseFunc = baseFunc;
    }

    private final By ITEM_TITLE = By.xpath(".//a[@class = 'cart-item__title']");
    private final By TOTAL_PRICE = By.xpath(".//div[contains(@class,'price')]/span[2]");
    private final By CHECKOUT_BTN = By.xpath(".//div[@class='cart-item__wrapper']//button[contains(@class,'button-checkout')]");

    public String getProductName(int index) {
        return baseFunc.getElements(ITEM_TITLE).get(index - 1).getText();
    }

    public BigDecimal getTotalPrice() {
        String total = baseFunc.getElement(TOTAL_PRICE).getText().replace("€", "").trim();
        return new BigDecimal(total);
    }

    public void continueCheckout() {
        baseFunc.click(CHECKOUT_BTN);
    }
}
