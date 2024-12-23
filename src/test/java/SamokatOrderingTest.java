import pageObjects.MainPage;
import pageObjects.OrderPage;
import pageObjects.RentPage;
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
                .sendClientFirstName("Геральт")
                .sendClientLastName("Ривийский")
                .sendDeliveryAddress("Москва, Амурская, 1")
                .selectMetroStation("Черкизовская")
                .sendDeliveryClientPhoneNumber("89991234567")
                .clickNextButton();

        boolean isDisplayed = new RentPage(driver)
                .sendRentalDate("07.01.2025")
                .setRentalTime()
                .clickCheckBoxColourGreyDespair()
                .sendComment("И колоду для гвинта возьмите")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Никак вы не научитесь", isDisplayed);
    }
}
