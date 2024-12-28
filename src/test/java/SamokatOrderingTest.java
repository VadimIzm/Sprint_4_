import io.github.bonigarcia.wdm.WebDriverManager;
import ru.page.objects.MainPage;
import ru.page.objects.OrderPage;
import ru.page.objects.RentPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SamokatOrderingTest extends CommonBaseTest {

    // Заказ кнопкой в хэдере
    @Test
    public void samokatOrderingByHeaderOrderButton() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickHeaderOrderButton();

        new OrderPage(driver)
                .sendClientFirstName("Геральт")
                .sendClientLastName("Ривийский")
                .sendDeliveryAddress("Москва, Амурская, 1")
                .selectMetroStation("Черкизовская")
                .sendDeliveryClientPhoneNumber("89991234567")
                .clickNextButton();

        boolean isDisplayed = new RentPage(driver)
                .sendRentalDate("05.01.2025")
                .setRentalTime()
                .clickCheckBoxColourBlackPearl()
                .sendComment("Шевелись, Плотва!")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Холера...", isDisplayed);
    }
    // Заказ кнопкой в середине страницы
    @Test
    public void samokatOrderingByMiddleOrderButton() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickMiddleOrderButton();

        new OrderPage(driver)
                .sendClientFirstName("Золтан")
                .sendClientLastName("Хивай")
                .sendDeliveryAddress("Москва, Хлобыстова, 18")
                .selectMetroStation("Выхино")
                .sendDeliveryClientPhoneNumber("89997654321")
                .clickNextButton();

        boolean isDisplayed = new RentPage(driver)
                .sendRentalDate("07.01.2025")
                .setRentalTime()
                .clickCheckBoxColourGreyDespair()
                .sendComment("Сом король Понтара")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Никак вы не научитесь", isDisplayed);
    }
}
