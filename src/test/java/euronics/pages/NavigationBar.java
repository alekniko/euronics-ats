package euronics.pages;

import euronics.BaseFunctions;
import org.openqa.selenium.By;

public class NavigationBar {
    private final By CART = By.xpath(".//a[@data-panel-target='cart-panel']");
    private final By VIEW_CART_BUTTON = By.xpath(".//div[contains(@class, 'panel-right--active')]//a[contains(@class, 'button')]");
    private final BaseFunctions baseFunc;

    public NavigationBar(BaseFunctions baseFunc) {
        this.baseFunc = baseFunc;
    }

    public CartPage openShoppingCart() {
        baseFunc.click(CART);
        baseFunc.click(VIEW_CART_BUTTON);

        return new CartPage(baseFunc);
    }
}
