package Tests;

import PageObject.ScooterOrderCheck;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.containsString;

public class ScooterOrderCheckTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        //Выбоp драйвера для браузера
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test

    public void createOrder1() {



        ScooterOrderCheck objScooterOrderCheck = new ScooterOrderCheck(driver);
        objScooterOrderCheck.open();
        objScooterOrderCheck.clickCookieButton();
//Клик на кнопку "Заказать"
        objScooterOrderCheck.clickTopOrderButton();
//Заполнение формы первого заказа
        objScooterOrderCheck.fillFirstPage(
                "Нинель",
                "Кобзон",
                "Баковка 1, 2",
                "+79099999933");
//Заполнение формы второго заказа
        objScooterOrderCheck.fillSecondPage(
                "Сдача с 5000$");
//Подтверждение оформления заказа
        objScooterOrderCheck.clickYesButton();
        String actualOrderText = objScooterOrderCheck.checkOrderIsDone();
        String exceptedOrderText = "Заказ оформлен";
        MatcherAssert.assertThat(actualOrderText, containsString(exceptedOrderText));
    }
    @Test

    public void createOrder2() {
        ScooterOrderCheck objScooterOrderCheck = new ScooterOrderCheck(driver);
        objScooterOrderCheck.open();
        objScooterOrderCheck.clickCookieButton();
//Прокрутка вниз
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
//Оформление заказа через нижнюю кнопку "Заказать"
        objScooterOrderCheck.clickBottomOrderButton();
        objScooterOrderCheck.fillFirstPage(
                "Иосиф",
                "Кобзон",
                "Баковка 1, 1",
                "+79999999999");
        objScooterOrderCheck.fillSecondPage(
                "Позвоните за 10мин до приезда");
        objScooterOrderCheck.clickYesButton();
        String actualOrderText = objScooterOrderCheck.checkOrderIsDone();
        String exceptedOrderText = "Заказ оформлен";
        MatcherAssert.assertThat(actualOrderText, containsString(exceptedOrderText));
    }

    @After
    public void teardown() {
        //Закрытие браузера
        driver.quit();
    }
}