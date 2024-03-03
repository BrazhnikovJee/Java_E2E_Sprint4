package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class MainPage {
    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //Кнопка "да все привыкли"
    public final By getCookiesButton = By.id("rcc-confirm-button");
    //Текст "Вопросы о важном"
    private final By getNameQuestionsMenu = By.xpath(".//div[text()='Вопросы о важном']");
    //Вопрос и ответ
    private final By getListMenu = By.xpath(".//div[@class='accordion__item']");
    //Кнопка "Заказать
    private final By getOrderButtons = By.xpath(".//*[contains(@class,'ra12g') and text()='Заказать']");
    //Принять куки
    public void acceptByCookies() {
        driver.findElement(getCookiesButton).click();
    }
    public void scrollToByHeader() {
        WebElement element = driver.findElement(getNameQuestionsMenu);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public List<WebElement> getElementsHeaderBy() {
        return driver.findElements(getListMenu);
    }
    public List<WebElement> getElementsBy() {
        return driver.findElements(By.xpath(".//div[@class='accordion__item']//p"));
    }
    public void scrollToByOrder(int number) {
        WebElement element = driver.findElements(getOrderButtons).get(number);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public List<WebElement> getOrderButtons() {
        return driver.findElements(getOrderButtons);
    }
}
