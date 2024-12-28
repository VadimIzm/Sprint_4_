import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.page.objects.MainPage;

import static org.junit.Assert.assertEquals;
import static ru.page.objects.MainPage.checkTextInOpenPanel;

//Параметризованный тест соответствия текста в выпадающем списке ожидаемому тексту
@RunWith(Parameterized.class)
public class DropDownListParamTest extends CommonBaseTest {

    //private final String questionLocator;
    private final String answer;
    private final String answerText;



    private static final String HOW_MUCH_QUESTION = "Сколько это стоит? И как оплатить?";
    private static final String MANY_SCOOTERS_QUESTION = "Хочу сразу несколько самокатов! Так можно?";
    private static final String RENTAL_TIME_QUESTION = "Как рассчитывается время аренды?";
    private static final String ORDER_TODAY_QUESTION = "Можно ли заказать самокат прямо на сегодня?";
    private static final String EXTENSION_OR_REFUND_QUESTION = "Можно ли продлить заказ или вернуть самокат раньше?";
    private static final String CHARGER_QUESTION = "Вы привозите зарядку вместе с самокатом?";
    private static final String CANCEL_ORDER_QUESTION = "Можно ли отменить заказ?";
    private static final String DELIVERY_OUTSIDE_MKAD_QUESTION = "Я жизу за МКАДом, привезёте?";

    private static final String HOW_MUCH_ANSWER = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private static final String MANY_SCOOTERS_ANSWER = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private static final String RENTAL_TIME_ANSWER  = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private static final String ORDER_TODAY_ANSWER = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private static final String EXTENSION_OR_REFUND_ANSWER = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private static final String CHARGING_ANSWER = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private static final String CANCEL_ORDER_ANSWER = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private static final String DELIVERY_OUTSIDE_MKAD_EXPECTED = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    //Конструктор класса
    public DropDownListParamTest(String answer, String answerText) {
        //this.questionLocator = questionLocator;
        this.answer = answer;
        this.answerText = answerText;
    }

    MainPage objMain = new MainPage(driver);

    //Массив с текстом ожидаемых ответов
    @Parameterized.Parameters
    public static Object[][] expectedAnswersParamList() {
        return new Object[][]{
                {HOW_MUCH_QUESTION, HOW_MUCH_ANSWER},
                {MANY_SCOOTERS_QUESTION, MANY_SCOOTERS_ANSWER},
                {RENTAL_TIME_QUESTION, RENTAL_TIME_ANSWER},
                {ORDER_TODAY_QUESTION, ORDER_TODAY_ANSWER},
                {EXTENSION_OR_REFUND_QUESTION, EXTENSION_OR_REFUND_ANSWER},
                {CHARGER_QUESTION, CHARGING_ANSWER},
                {CANCEL_ORDER_QUESTION, CANCEL_ORDER_ANSWER},
                {DELIVERY_OUTSIDE_MKAD_QUESTION, DELIVERY_OUTSIDE_MKAD_EXPECTED},
        };
    }
    //Сравнение текста ответа с эталонным текстом
    @Test
    public void dropDownListTest() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .scrollPageToEndOfList()
                .clickQuestionButton(answer);
        MainPage.checkTextInOpenPanel(answer, answerText);
    }
}