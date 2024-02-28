package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderPage {
    private final WebDriver driver;
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By getNameField = By.xpath(".//input[@placeholder='* Имя']");
    private final By getSurnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By getAddressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By getMetroField = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By getPhoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    private final By getDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By getRentalPeriod = By.xpath(".//div[@class='Dropdown-placeholder']");
    private final By getBlackScooter = By.id("black");

    private final By getNextButton = By.xpath(".//button[text()='Далее']");
    //кнопка Заказать
    private final By getOrderFinalButton = By.xpath(".//button[text()='Назад']/parent::div/button[text()='Заказать']");
    //кнопка Да - в модальном окне
    private final By getOkButton = By.xpath(".//button[text()='Да']");

    private final By getOrderIsProcessed = By.xpath(".//div[text()='Заказ оформлен']");
    public void clickNextButton() {
        driver.findElement(getNextButton).click();
    }
    public void clickOkButton() {
        driver.findElement(getOkButton).click();
    }
    public void clickOrderButton() {
        driver.findElement(getOrderFinalButton).click();
    }
    public void setName(String name) {
        driver.findElement(this.getNameField).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(this.getSurnameField).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(this.getAddressField).sendKeys(address);
    }

    public void setStationMetro(String station) {
        driver.findElement(getMetroField).sendKeys(station);
        waitMetroIsVisible(station);
        containsText(station).click();
    }

    public void setPhone(String phone) {
        driver.findElement(this.getPhoneField).sendKeys(phone);
    }

    public void setDate(String date) {
        driver.findElement(this.getDateField).sendKeys(date);
        containsText("5").click();
    }

    public void setRentalPeriod(String period) {
        driver.findElement(getRentalPeriod).click();
        containsText(period).click();
    }
    private void waitMetroIsVisible(String station) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains(text(),'" + station + "')]")));
    }
    private WebElement containsText(String text) {
        return driver.findElement(By.xpath(".//*[contains(text(),'" + text + "')]"));
    }
    public void checkBoxBlackScooter() {
        driver.findElement(getBlackScooter).click();
    }

    public boolean orderIsProcessedIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(getOrderIsProcessed));
        return driver.findElement(getOrderIsProcessed).isDisplayed();
    }

}
