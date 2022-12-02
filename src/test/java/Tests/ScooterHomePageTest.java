package Tests;

import PageObject.ScooterHomePage;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;

public class ScooterHomePageTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        //Выбор драйвера для браузера
        //  driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    //тесты для проверки текста после нажатия на стрелочкии
    @Test
    public void checkQuestions1(){

        ScooterHomePage objHomePage = new ScooterHomePage(driver);
        objHomePage.open();
        objHomePage.scrollPageDown();
        objHomePage.pressButtonWithFirstQuestion();
        String actualQuestionText = objHomePage.firstTextFromResponsePanel();
        String expectedQuestionText = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        MatcherAssert.assertThat(actualQuestionText,  is(expectedQuestionText));

    }

    @Test
    public void checkQuestions2(){

        ScooterHomePage objHomePage = new ScooterHomePage(driver);
        objHomePage.open();
        objHomePage.scrollPageDown();
        objHomePage.pressButtonWithSecondQuestion();
        String actualQuestionText = objHomePage.secondTextFromResponsePanel();
        String expectedQuestionText = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        MatcherAssert.assertThat(actualQuestionText, is(expectedQuestionText));

    }

    @Test
    public void checkQuestions3(){

        ScooterHomePage objHomePage = new ScooterHomePage(driver);
        objHomePage.open();
        objHomePage.scrollPageDown();
        objHomePage.pressButtonWithThirdQuestion();
        String actualQuestionText = objHomePage.thirdTextFromResponsePanel();
        String expectedQuestionText = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        MatcherAssert.assertThat(actualQuestionText, is(expectedQuestionText));

    }

    @Test
    public void checkQuestions4(){

        ScooterHomePage objHomePage = new ScooterHomePage(driver);
        objHomePage.open();
        objHomePage.scrollPageDown();
        objHomePage.pressButtonWithFourQuestion();
        String actualQuestionText = objHomePage.fourthTextFromResponsePanel();
        String expectedQuestionText = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        MatcherAssert.assertThat(actualQuestionText, is(expectedQuestionText));

    }

    @Test
    public void checkQuestions5(){

        ScooterHomePage objHomePage = new ScooterHomePage(driver);
        objHomePage.open();
        objHomePage.scrollPageDown();
        objHomePage.pressButtonWithFiveQuestion();
        String actualQuestionText = objHomePage.fifthTextFromResponsePanel();
        String expectedQuestionText = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        MatcherAssert.assertThat(actualQuestionText, is(expectedQuestionText));

    }

    @Test
    public void checkQuestions6(){

        ScooterHomePage objHomePage = new ScooterHomePage(driver);
        objHomePage.open();
        objHomePage.scrollPageDown();
        objHomePage.pressButtonWithSixthQuestion();
        String actualQuestionText = objHomePage.sixthTextFromResponsePanel();
        String expectedQuestionText = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        MatcherAssert.assertThat(actualQuestionText, is(expectedQuestionText));

    }

    @Test
    public void checkQuestions7(){

        ScooterHomePage objHomePage = new ScooterHomePage(driver);
        objHomePage.open();
        objHomePage.scrollPageDown();
        objHomePage.pressButtonWithSeventhQuestion();
        String actualQuestionText = objHomePage.seventhTextFromResponsePanel();
        String expectedQuestionText = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        MatcherAssert.assertThat(actualQuestionText, is(expectedQuestionText));

    }

    @Test
    public void checkQuestions8(){


        ScooterHomePage objHomePage = new ScooterHomePage(driver);
        objHomePage.open();
        objHomePage.scrollPageDown();
        objHomePage.pressButtonWithEighthQuestion();
        String actualQuestionText = objHomePage.eighthTextFromResponsePanel();
        String expectedQuestionText = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        MatcherAssert.assertThat(actualQuestionText, is(expectedQuestionText));

    }

    @After
    public void teardown() {
        //Закрытие браузера
        driver.quit();
    }

}