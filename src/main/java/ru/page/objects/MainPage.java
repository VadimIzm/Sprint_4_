package ru.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

import static org.junit.Assert.assertEquals;

// Элементы главной страницы сайта
public class MainPage {
    public MainPage(WebDriver driver) {
        MainPage.driver = driver;
    }

    private static WebDriver driver;

    //Локатор кнопки "да все привыкли"
    private final By cookieButton = By.id("rcc-confirm-button");

    //Локатор Кнопки заказа в хэдере сайта
    private final By headerOrderButton = By.className("Button_Button__ra12g");

    //Локатор кнопки заказа в середине сайта
    private final By middleOrderButton = By.className("Button_Middle__1CSJM");

    //Массив локаторов кнопок с вопросами
    private static final String[] dropDownQuestionsArray = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"};

    //Локаторы панелей с текстом ответов
    private static final String[] dropDownAnswersArray = new String[]{
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"};

    //Локаторы кнопок вопросов
    //Кнопка "Сколько это стоит? И как оплатить?"
    private static final By HOW_MUCH_BUTTON = By.id("accordion__heading-0");
    //Содержимое "Сколько это стоит? И как оплатить?"
    private static final By HOW_MUCH_CONTENT = By.xpath(".//div[@id='accordion__panel-0']/p");

    //Кнопка "Хочу сразу несколько самокатов! Так можно?"
    private static final By SOME_SCOOTERS_BUTTON = By.id("accordion__heading-1");
    //Содержимое "Хочу сразу несколько самокатов! Так можно?"
    private static final By SOME_SCOOTERS_TEXT = By.xpath(".//div[@id='accordion__panel-1']/p");

    //Кнопка "Как рассчитывается время аренды?"
    private static final By RENTAL_TIME_BUTTON = By.id("accordion__heading-2");
    //Кнопка "Как рассчитывается время аренды?"
    private static final By RENTAL_TIME_TEXT = By.xpath(".//div[@id='accordion__panel-2']/p");

    //Кнопка "Можно ли заказать самокат прямо на сегодня?"
    private static final By ORDER_TODAY_BUTTON = By.id("accordion__heading-3");
    //Кнопка "Можно ли заказать самокат прямо на сегодня?"
    private static final By ORDER_TODAY_TEXT = By.xpath(".//div[@id='accordion__panel-3']/p");

    //Кнопка "Можно ли продлить заказ или вернуть самокат раньше?"
    private static final By EXTENSION_OR_REFUND_BUTTON = By.id("accordion__heading-4");
    //Кнопка "Можно ли продлить заказ или вернуть самокат раньше?"
    private static final By EXTENSION_OR_REFUND_TEXT = By.xpath(".//div[@id='accordion__panel-4']/p");

    //Кнопка "Вы привозите зарядку вместе с самокатом?"
    private static final By CHARGING_SCOOTER_BUTTON = By.id("accordion__heading-5");
    //Кнопка "Вы привозите зарядку вместе с самокатом?"
    private static final By CHARGING_SCOOTER_TEXT = By.xpath(".//div[@id='accordion__panel-5']/p");

    //Кнопка "Можно ли отменить заказ?"
    private static final By CANCEL_ORDER_BUTTON = By.id("accordion__heading-6");
    //Содержимое "Можно ли отменить заказ?"
    private static final By CANCEL_ORDER_TEXT = By.xpath(".//div[@id='accordion__panel-6']/p");

    //Кнопка "Я жизу за МКАДом, привезёте?"
    private static final By DELIVERY_OUTSIDE_MKAD_BUTTON = By.id("accordion__heading-7");
    //Содержимое "Я жизу за МКАДом, привезёте?"
    private static final By DELIVERY_OUTSIDE_MKAD_TEXT = By.xpath(".//div[@id='accordion__panel-7']/p");



    //Методы для работы с элементами главной страницы
// Открыть сайт
    public final MainPage openSite() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        return this;
    }

    //Клик по кнопке "да все привыкли"
    public MainPage clickCookieButton() {
        driver.findElement(cookieButton).click();
        return this;
    }

    //Клик по кнопке заказа в хэдере сайта
    public MainPage clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
        return this;
    }

    //Клик по кнопке заказа в середине сайта
    public MainPage clickMiddleOrderButton() {
        driver.findElement(middleOrderButton).click();
        return this;
    }

    //Прокрутка главной страницы до последнего элемента списка
    public MainPage scrollPageToEndOfList() {
        WebElement lastQuestionArrow = driver.findElement(By.id(dropDownQuestionsArray[7]));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lastQuestionArrow);
        return this;
    }

    //Клик по стрелке выпадающего списка
    public static void clickQuestionArrow(int questionNumber) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id(dropDownQuestionsArray[questionNumber])));
        driver.findElement(By.id(dropDownQuestionsArray[questionNumber])).click();
    }

    //Проверка текста в открытой панели
    public static void checkTextInOpenPanel(String answer, String answerText) {
        if (Objects.equals(answer, driver.findElement(HOW_MUCH_BUTTON).getText())) {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.elementToBeClickable(HOW_MUCH_BUTTON));
            assertEquals("Текст в ответе не соответствует ожидаемому тексту.", answerText, driver.findElement(HOW_MUCH_CONTENT).getText());
        } else if (Objects.equals(answer, driver.findElement(SOME_SCOOTERS_BUTTON).getText())) {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.elementToBeClickable(SOME_SCOOTERS_BUTTON));
            assertEquals("Текст в ответе не соответствует ожидаемому тексту.", answerText, driver.findElement(SOME_SCOOTERS_TEXT).getText());
        } else if (Objects.equals(answer, driver.findElement(RENTAL_TIME_BUTTON).getText())) {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.elementToBeClickable(RENTAL_TIME_BUTTON));
            assertEquals("Текст в ответе не соответствует ожидаемому тексту.", answerText, driver.findElement(RENTAL_TIME_TEXT).getText());
        } else if (Objects.equals(answer, driver.findElement(ORDER_TODAY_BUTTON).getText())) {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.elementToBeClickable(ORDER_TODAY_BUTTON));
            assertEquals("Текст в ответе не соответствует ожидаемому тексту.", answerText, driver.findElement(ORDER_TODAY_TEXT).getText());
        } else if (Objects.equals(answer, driver.findElement(EXTENSION_OR_REFUND_BUTTON).getText())) {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.elementToBeClickable(EXTENSION_OR_REFUND_BUTTON));
            assertEquals("Текст в ответе не соответствует ожидаемому тексту.", answerText, driver.findElement(EXTENSION_OR_REFUND_TEXT).getText());
        } else if (Objects.equals(answer, driver.findElement(CHARGING_SCOOTER_BUTTON).getText())) {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.elementToBeClickable(CHARGING_SCOOTER_BUTTON));
            assertEquals("Текст в ответе не соответствует ожидаемому тексту.", answerText, driver.findElement(CHARGING_SCOOTER_TEXT).getText());
        } else if (Objects.equals(answer, driver.findElement(CANCEL_ORDER_BUTTON).getText())) {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.elementToBeClickable(CANCEL_ORDER_BUTTON));
            assertEquals("Текст в ответе не соответствует ожидаемому тексту.", answerText, driver.findElement(CANCEL_ORDER_TEXT).getText());
        } else if (Objects.equals(answer, driver.findElement(DELIVERY_OUTSIDE_MKAD_BUTTON).getText())) {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.elementToBeClickable(DELIVERY_OUTSIDE_MKAD_BUTTON));
            assertEquals("Текст в ответе не соответствует ожидаемому тексту.", answerText, driver.findElement(DELIVERY_OUTSIDE_MKAD_TEXT).getText());
        }
    }

    //Клик по кнопке вопроса
    public MainPage clickQuestionButton(String answer) {
        if (Objects.equals(answer, driver.findElement(HOW_MUCH_BUTTON).getText())) {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.elementToBeClickable(HOW_MUCH_BUTTON));
            driver.findElement(HOW_MUCH_BUTTON).click();
        } else if (Objects.equals(answer, driver.findElement(SOME_SCOOTERS_BUTTON).getText())) {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.elementToBeClickable(SOME_SCOOTERS_BUTTON));
            driver.findElement(SOME_SCOOTERS_BUTTON).click();
        } else if (Objects.equals(answer, driver.findElement(RENTAL_TIME_BUTTON).getText())) {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.elementToBeClickable(RENTAL_TIME_BUTTON));
            driver.findElement(RENTAL_TIME_BUTTON).click();
        } else if (Objects.equals(answer, driver.findElement(ORDER_TODAY_BUTTON).getText())) {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.elementToBeClickable(ORDER_TODAY_BUTTON));
            driver.findElement(ORDER_TODAY_BUTTON).click();
        } else if (Objects.equals(answer, driver.findElement(EXTENSION_OR_REFUND_BUTTON).getText())) {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.elementToBeClickable(EXTENSION_OR_REFUND_BUTTON));
            driver.findElement(EXTENSION_OR_REFUND_BUTTON).click();
        } else if (Objects.equals(answer, driver.findElement(CHARGING_SCOOTER_BUTTON).getText())) {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.elementToBeClickable(CHARGING_SCOOTER_BUTTON));
            driver.findElement(CHARGING_SCOOTER_BUTTON).click();
        } else if (Objects.equals(answer, driver.findElement(CANCEL_ORDER_BUTTON).getText())) {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.elementToBeClickable(CANCEL_ORDER_BUTTON));
            driver.findElement(CANCEL_ORDER_BUTTON).click();
        } else if (Objects.equals(answer, driver.findElement(DELIVERY_OUTSIDE_MKAD_BUTTON).getText())) {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.elementToBeClickable(DELIVERY_OUTSIDE_MKAD_BUTTON));
            driver.findElement(DELIVERY_OUTSIDE_MKAD_BUTTON).click();
        }
        return null;
    }
}

