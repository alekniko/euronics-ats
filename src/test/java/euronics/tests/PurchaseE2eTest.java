package euronics.tests;

import euronics.BaseFunctions;
import euronics.model.Client;
import euronics.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class PurchaseE2eTest {
    private BaseFunctions baseFunc = new BaseFunctions();

    @Test
    public void purchaseE2eTest() {
        baseFunc.openUrl("www.euronics.lv/en");

        HomePage homePage = new HomePage(baseFunc);
        homePage.closeCookiesPopUp();
        homePage.selectProductCategory("Phones");

        CatalogPage catalogPage = homePage.selectProductType("iPhone");

        ProductPage productPage = catalogPage.selectProduct("Apple iPhone 13, 128 GB, blue - Smartphone");
        String firstItemName = productPage.getProductName();
        BigDecimal firstItemPrice = productPage.getProductPrice();
        productPage.addProductToCart();
        productPage.pressContinueShoppingBtn();
        baseFunc.returnToPreviousPage();

        catalogPage.selectProduct("Apple iPhone 13, 128 GB, green - Smartphone");
        String secondItemName = productPage.getProductName();
        BigDecimal secondItemPrice = productPage.getProductPrice();
        productPage.addProductToCart();
        productPage.pressContinueShoppingBtn();

        NavigationBar navigationBar = new NavigationBar(baseFunc);

        CartPage cartPage = navigationBar.openShoppingCart();

        Assertions.assertEquals(firstItemName, cartPage.getProductName(1), "Incorrect item name");
        Assertions.assertEquals(secondItemName, cartPage.getProductName(2), "Incorrect item name");

        Assertions.assertEquals(firstItemPrice.add(secondItemPrice), cartPage.getTotalPrice(), "Incorrect total amount");

        cartPage.continueCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(baseFunc);
        checkoutPage.selectOrderWithoutRegistration();
        checkoutPage.fillClientContactInfo(new Client(true));
        checkoutPage.clickContactInfoNextButton();

        checkoutPage.selectShopDelivery();
        checkoutPage.selectShopToDeliver("Mols");
        checkoutPage.clickProductDeliveryNextButton();

        checkoutPage.selectPaymentMethod("Credit card");
        checkoutPage.clickAcceptTernsCheckBox();
        checkoutPage.clickPayButton();
    }

    @AfterEach
    public void after() {
        baseFunc.closeBrowser();
    }
}