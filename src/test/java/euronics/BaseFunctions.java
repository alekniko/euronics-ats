package euronics;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseFunctions {
    private WebDriver driver;
    private WebDriverWait wait;
    private ChromeOptions options;
    public Actions actions;
    public JavascriptExecutor js;

    public BaseFunctions() {
        options = new ChromeOptions();
//        options.addArguments("--disable-notifications");
//        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    public void openUrl(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public WebElement getElement(By locator) {
        waitElementDisplayed(locator);
        return driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        waitElementDisplayed(locator);
        return driver.findElements(locator);
    }

    public void waitElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitElementDisplayed(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
//        WebElement element = driver.findElement(locator);
//        try {
//            waitElementDisplayed(locator);
//            waitElementToBeClickable(locator);
//            element.click();
//        } catch (ElementClickInterceptedException e) {
//            System.out.println("Can't click on element on a first try");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                throw new RuntimeException(ex);
//            }
//            element.click();
//        }
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void type(By locator, String value) {
        WebElement e = getElement(locator);
        e.clear();
        e.sendKeys(value);
    }

    public void pressKey(By locator, Keys key) {
        getElement(locator).sendKeys(key);
    }

    public void scrollToElement (WebElement we) {
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", we);

       wait.until(ExpectedConditions.elementToBeClickable(we));
    }

    public void returnToPreviousPage (){
        driver.navigate().back();
    }
}
