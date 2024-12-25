import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.page.objects.MainPage;

import static org.junit.Assert.assertEquals;

//Параметризованный тест соответствия текста в выпадающем списке ожидаемому тексту
@RunWith(Parameterized.class)
public class DropDownListParamTest extends CommonBaseTest {

    private final String questionLocator;
    private final String answerLocator;
    private final String answerText;

    private static final String accordionHeading0 = "accordion__heading-0";
    private static final String accordionHeading1 = "accordion__heading-1";
    private static final String accordionHeading2 = "accordion__heading-2";
    private static final String accordionHeading3 = "accordion__heading-3";
    private static final String accordionHeading4 = "accordion__heading-4";
    private static final String accordionHeading5 = "accordion__heading-5";
    private static final String accordionHeading6 = "accordion__heading-6";
    private static final String accordionHeading7 = "accordion__heading-7";

    private static final String accordionPanel0 = "accordion__panel-0";
    private static final String accordionPanel1 = "accordion__panel-1";
    private static final String accordionPanel2 = "accordion__panel-2";
    private static final String accordionPanel3 = "accordion__panel-3";
    private static final String accordionPanel4 = "accordion__panel-4";
    private static final String accordionPanel5 = "accordion__panel-5";
    private static final String accordionPanel6 = "accordion__panel-6";
    private static final String accordionPanel7 = "accordion__panel-7";

    //Конструктор класса
    public DropDownListParamTest(String questionLocator, String answerLocator, String answerText) {
        this.questionLocator = questionLocator;
        this.answerLocator = answerLocator;
        this.answerText = answerText;
    }

    MainPage objMain = new MainPage(driver);

    //Массив с текстом ожидаемых ответов
    @Parameterized.Parameters
    public static Object[][] expectedAnswersParamList() {
        return new Object[][]{
                {accordionHeading0, accordionPanel0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {accordionHeading1, accordionPanel1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {accordionHeading2, accordionPanel2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {accordionHeading3, accordionPanel3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {accordionHeading4, accordionPanel4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {accordionHeading5, accordionPanel5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {accordionHeading6, accordionPanel6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {accordionHeading7, accordionPanel7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }
    //Сравнение текста ответа с эталонным текстом
    @Test
    public void dropDownListTest() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .scrollPageToEndOfList()
                .clickQuestionButton(questionLocator);

        new MainPage(driver);
        String ActualAnswerText = driver.findElement(By.id(answerLocator)).getText();
        assertEquals("Текст в ответе не соответствует ожидаемому тексту.", answerText, ActualAnswerText);
    }
}