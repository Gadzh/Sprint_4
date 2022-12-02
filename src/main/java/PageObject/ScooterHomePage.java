package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScooterHomePage {
    private WebDriver driver;

    private final String url = "https://qa-scooter.praktikum-services.ru";

    //локаторы для вопросов
    private By accordionButton_0 = By.id("accordion__heading-0");
    private By accordionButton_1 = By.id("accordion__heading-1");
    private By accordionButton_2 = By.id("accordion__heading-2");
    private By accordionButton_3 = By.id("accordion__heading-3");
    private By accordionButton_4 = By.id("accordion__heading-4");
    private By accordionButton_5 = By.id("accordion__heading-5");
    private By accordionButton_6 = By.id("accordion__heading-6");
    private By accordionButton_7 = By.id("accordion__heading-7");

    //локаторы для текстов под вопросами
    private By accordionPanel_0 = By.id("accordion__panel-0");

    private By accordionPanel_1 = By.id("accordion__panel-1");

    private By accordionPanel_2 = By.id("accordion__panel-2");

    private By accordionPanel_3 = By.id("accordion__panel-3");

    private By accordionPanel_4 = By.id("accordion__panel-4");

    private By accordionPanel_5 = By.id("accordion__panel-5");

    private By accordionPanel_6 = By.id("accordion__panel-6");

    private By accordionPanel_7 = By.id("accordion__panel-7");

    public ScooterHomePage(WebDriver driver) {

        this.driver = driver;
    }

    public ScooterHomePage open() {
        driver.get(url);
        return this;
    }

    //Прокрутка страницы
    public void scrollPageDown() {
        WebElement element = driver.findElement(By.id("accordion__heading-7"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Методы нажатия на заголовки вопросов
    public void pressButtonWithFirstQuestion(){

        driver.findElement(accordionButton_0).click();

    }


    public void pressButtonWithSecondQuestion(){

        driver.findElement(accordionButton_1).click();

    }

    public void pressButtonWithThirdQuestion(){

        driver.findElement(accordionButton_2).click();

    }

    public void pressButtonWithFourQuestion(){

        driver.findElement(accordionButton_3).click();

    }

    public void pressButtonWithFiveQuestion(){

        driver.findElement(accordionButton_4).click();

    }

    public void pressButtonWithSixthQuestion(){

        driver.findElement(accordionButton_5).click();

    }

    public void pressButtonWithSeventhQuestion(){

        driver.findElement(accordionButton_6).click();

    }

    public void pressButtonWithEighthQuestion(){

        driver.findElement(accordionButton_7).click();

    }

    //Методы для получения ответов
    public String firstTextFromResponsePanel(){
        return driver.findElement(By.id("accordion__panel-0")).getText();

    }

    public String secondTextFromResponsePanel(){
        return driver.findElement(By.id("accordion__panel-1")).getText();
    }

    public String thirdTextFromResponsePanel(){

        return driver.findElement(By.id("accordion__panel-2")).getText();
    }

    public String fourthTextFromResponsePanel(){
        return driver.findElement(By.id("accordion__panel-3")).getText();
    }

    public String fifthTextFromResponsePanel(){
        return driver.findElement(By.id("accordion__panel-4")).getText();
    }

    public String sixthTextFromResponsePanel(){
        return driver.findElement(By.id("accordion__panel-5")).getText();
    }

    public String seventhTextFromResponsePanel(){
        return driver.findElement(By.id("accordion__panel-6")).getText();
    }

    public String eighthTextFromResponsePanel(){
        return driver.findElement(By.id("accordion__panel-7")).getText();
    }


}
