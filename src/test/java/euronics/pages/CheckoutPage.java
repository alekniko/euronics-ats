package euronics.pages;

import euronics.BaseFunctions;
import euronics.model.Client;
import org.openqa.selenium.By;

public class CheckoutPage {
    private final BaseFunctions baseFunc;

    public CheckoutPage(BaseFunctions baseFunc) {
        this.baseFunc = baseFunc;
    }

    private final By ORDER_WITHOUT_REG_BTN = By.xpath(".//span[contains(text(),'Order without registration')]/..");
    private final By FIRST_NAME_INPUT_FIELD = By.xpath(".//input[@id='Contacts_FirstName']");
    private final By LAST_NAME_INPUT_FIELD = By.xpath(".//input[@id='Contacts_LastName']");
    private final By EMAIL_INPUT_FIELD = By.xpath(".//input[@id='Contacts_Email']");
    private final By PHONE_NUMBER_INPUT_FIELD = By.xpath(".//input[@id='Contacts_Phone']");
    private final By CONTACT_INFO_NEXT_BTN = By.xpath(".//button[@id='contact-info-next']");
    private final By SHOP_DELIVERY_NEXT_BTN = By.xpath(".//button[@id='shipping-next']");
    private final By SHOP_DELIVERY_RADIO_BTN = By.xpath(".//div[@data-container-for='Shop']//span[@class='checkmark']");
    private final By ACCEPT_TERMS_CHECK_BOX = By.xpath(".//input[@id='TermsAccepted']/..");
    private final By PAY_BTN = By.xpath(".//button[@id='submit-payment']");

    public void selectOrderWithoutRegistration() {
        baseFunc.click(ORDER_WITHOUT_REG_BTN);
    }

    public void clickContactInfoNextButton() {
        baseFunc.click(CONTACT_INFO_NEXT_BTN);
    }

    public void fillClientContactInfo(Client client) {
        baseFunc.type(FIRST_NAME_INPUT_FIELD, client.getFirstName());
        baseFunc.type(LAST_NAME_INPUT_FIELD, client.getLastName());
        baseFunc.type(EMAIL_INPUT_FIELD, client.getEmail());
        baseFunc.type(PHONE_NUMBER_INPUT_FIELD, client.getPhone());
    }

    public void selectShopDelivery() {
        baseFunc.click(SHOP_DELIVERY_RADIO_BTN);
    }

    public void selectShopToDeliver(String shopName) {
        baseFunc.click(By.xpath(".//div[@id='choose-store']//label[contains(text(), '" + shopName + "')]"));
    }

    public void clickProductDeliveryNextButton() {
        baseFunc.click(SHOP_DELIVERY_NEXT_BTN);
    }

    public void selectPaymentMethod(String methodName) {
        baseFunc.click(By.xpath(".//div[@role='tablist']/label[contains(text(), '" + methodName + "')]"));
    }

    public void clickAcceptTernsCheckBox () {
        baseFunc.click(ACCEPT_TERMS_CHECK_BOX);
    }

    public void clickPayButton(){
        baseFunc.click(PAY_BTN);
    }
}
