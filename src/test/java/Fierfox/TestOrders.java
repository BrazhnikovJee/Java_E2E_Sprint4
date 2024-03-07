package Fierfox;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.MainPage;
import page.OrderPage;
import page.constants;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TestOrders {
    private final String url = constants.URL;
    private final WebDriver driver = new ChromeDriver();
    MainPage mainPage = new MainPage(driver);
    OrderPage orderPage = new OrderPage(driver);
    private final int number;
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String period;

    public TestOrders(int number, String name, String surname, String address, String metro, String phone, String date, String period) {
        this.number = number;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.period = period;
    }

    @Parameterized.Parameters
    public static Object[][] getQuest() {
        return new Object[][]{
                {0, "Вадим", "Бражников", "Москва, ул. Маршала Конева, 23",
                        "Варшавская", "+79774038436", "01.09.2023", "сутки"},
                {1, "Олеся", "Киселева", "Тула, ул. Ленина, 24",
                        "Чеховская", "+79774038495", "06.09.2023", "трое суток"}
        };
    }

    @Test
    public void orderTest() {
        driver.get(url);
        mainPage.acceptByCookies();
        mainPage.scrollToByOrder(number);
        mainPage.getOrderButtons().get(number).click();
        orderPage.setName(name);
        orderPage.setSurname(surname);
        orderPage.setAddress(address);
        orderPage.setStationMetro(metro);
        orderPage.setPhone(phone);
        orderPage.clickNextButton();
        orderPage.setDate(date);
        orderPage.setRentalPeriod(period);
        orderPage.checkBoxBlackScooter();
        orderPage.clickOrderButton();
        orderPage.clickOkButton();
        assertTrue("Заказ не оформлен", orderPage.orderIsProcessedIsVisible());
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }
}
