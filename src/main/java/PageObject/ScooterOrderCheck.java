package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScooterOrderCheck {
    private WebDriver driver;

    private final String url = "https://qa-scooter.praktikum-services.ru";

    //Верхняя и нижняя кнопка "Заказать"
    private By topOrderButton = By.className("Button_Button__ra12g");
    private By bottomOrderButton = By.className("Home_FinishButton__1_cWm");
    private By cookieMessage = By.className("App_CookieButton__3cvqF");


    //Первая страница оформления заказа

    //Заголовок формы заказа "Для кого самокат"
    private By orderHeaderText = By.className("Order_Header__BZXOb");

    //Поля для ввода данных заказа
    private By nameInputField = By.xpath(".//input[@placeholder='* Имя']");
    private By lastNameInputField = By.xpath(".//input[@placeholder='* Фамилия']");
    private By addressInputField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By fieldForMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private By metroStationMin = By.xpath("//button[@value='141']");
    private By orderContactPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Кнопки "Далее" "Заказать" "Да"
    private By orderNextButton = By.xpath(".//button[text()='Далее']");
    private By orderConfirmationButton = By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Заказать')]");

    //Вторая страница оформления заказа
    //Заголовок формы заказа "Про аренду"
    private By orderHeaderTextSecondPage = By.className("Order_Header__BZXOb");

    //Поля для ввода данных заказа
    private By deliveryTimeField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By dateSelectionContainer = By.xpath(".//div[@aria-label='Choose среда, 30-е ноября 2022 г.']");
    private By fieldHowLong = By.className("Dropdown-placeholder");
    private By fieldHowLongSixDays = By.xpath(".//div[text()='шестеро суток']");
    private By colorSelectionField = By.xpath(".//label[@for='grey']");
    private By courierCommentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //Окно с заголовоком подтверждения оформления заказа
    private By titleOfModalWindow = By.className("Order_ModalHeader__3FDaJ");
    // Кнопка "Да"
    private By yesButton = By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Да')]");
    // "Заказ оформлен"
    private By orderDoneHeader = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");

    public  ScooterOrderCheck(WebDriver driver){
        this.driver = driver;
    }
    public ScooterOrderCheck open() {
        driver.get(url);
        return this;
    }

    public String checkOrderIsDone() {
        return driver.findElement(orderDoneHeader).getText();
    }
    //Методы кликов на кнопки
    public void clickCookieButton() {
        driver.findElement(cookieMessage).click();
    }
    //Метод клика на верхний "Заказ"
    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }
    //Метод клика на нижний "Заказ"
    public void clickBottomOrderButton() {
        driver.findElement(bottomOrderButton).click();
    }

    //Метод клика на кнопку "Далее" "Заказать" "Да"
    public void clickNextButton() {
        driver.findElement(orderNextButton).click();
    }
    public void clickConfirmationButton() {
        driver.findElement(orderConfirmationButton).click();
    }
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

    //Ввод Имени
    public void setFirstName(String firstName) {
        driver.findElement(nameInputField).sendKeys(firstName);
    }
    //Ввод Фамилии
    public void setSecondName(String secondName) {
        driver.findElement(lastNameInputField).sendKeys(secondName);
    }
    //Ввод адреса
    public void setAddressPoint(String addressPoint) {
        driver.findElement(addressInputField).sendKeys(addressPoint);
    }
    //Метод нажатия на список станций метро
    public void clickMetroStation() {
        driver.findElement(fieldForMetroStation).click();
    }
    //Выбор станции метро
    public void clickMetroMin() {
        driver.findElement(metroStationMin).click();
    }
    //Ввод номера телефона
    public void setOrderContactPhone(String contactPhone) {
        driver.findElement(orderContactPhone).sendKeys(contactPhone);
    }
    //
    public void clickWhen() {
        driver.findElement(deliveryTimeField).click();
    }
    public void clickWhenCalendar() {
        driver.findElement(dateSelectionContainer).click();
    }
    public void clickHowLong() {
        driver.findElement(fieldHowLong).click();
    }
    public void clickHowLongTwoDays() {
        driver.findElement(fieldHowLongSixDays).click();
    }
    public void clickColorBlack() {
        driver.findElement(colorSelectionField).click();
    }
    public void setCommentCour(String commentCour) {
        driver.findElement(courierCommentField).sendKeys(commentCour);
    }


    //Объединение методов
    public void fillFirstPage(String firstName, String secondName, String addressPoint, String contactPhone) {
        setFirstName(firstName);
        setSecondName(secondName);
        setAddressPoint(addressPoint);
        setOrderContactPhone(contactPhone);
        clickMetroStation();
        clickMetroMin();
        clickNextButton();
    }
    public void fillSecondPage(String commentCour) {
        clickWhen();
        clickWhenCalendar();
        clickHowLong();
        clickHowLongTwoDays();
        clickColorBlack();
        setCommentCour(commentCour);
        clickConfirmationButton();
    }
}
