import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;
import io.qameta.allure.*;

public class Test16 {
    private WebDriver driver;
    private MainPage mainPage;
    

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        mainPage = new MainPage(driver);
        
    }

    @Test
    @Owner("Попович Евгений")
    @AllureId("001-1")
    @DisplayName("Плейсхолдеры - Услуги связи")
    @Description("Проверяет наличие надписей в незаполненных полях в разделе: Пополнение баланса - Услуги связи")
    @Severity(SeverityLevel.NORMAL)

    public void testPlaceholdersUsligi() {
        // Ожидаемые надписи для незаполненных полей
        String expectedPhonePlaceholder = "Номер телефона";          
        String expectedSumPlaceholder = "Сумма";
        String expectedEmailPlaceholder = "E-mail для отправки чека"; 

        // Получаем надписи из полей на странице
        String actualPhonePlaceholder = mainPage.uslugiPhone.getAttribute("placeholder");
        String actualSumPlaceholder = mainPage.usligiSum.getAttribute("placeholder");
        String actualEmailPlaceholder = mainPage.uslugiEmail.getAttribute("placeholder");

        // Проверка соответствия ожидаемых и фактических надписей
        assertEquals(expectedPhonePlaceholder, actualPhonePlaceholder, "Надпись поля телефона не соответствует ожиданиям.");        
        assertEquals(expectedSumPlaceholder, actualSumPlaceholder, "Надпись поля суммы не соответствует ожиданиям.");
        assertEquals(expectedEmailPlaceholder, actualEmailPlaceholder, "Надпись поля email не соответствует ожиданиям.");
    }

    @Test
    @Owner("Попович Евгений")
    @AllureId("001-2")
    @DisplayName("Плейсхолдеры - Домашний интернет")
    @Description("Проверяет наличие надписей в незаполненных полях в разделе: Пополнение баланса - Домашний интернет")
    @Severity(SeverityLevel.NORMAL)

    public void testPlaceholdersInternet() {
        
        String expectedPhonePlaceholder = "Номер абонента";          
        String expectedSumPlaceholder = "Сумма";
        String expectedEmailPlaceholder = "E-mail для отправки чека"; 

      
        String actualPhonePlaceholder = mainPage.internetPhone.getAttribute("placeholder");
        String actualSumPlaceholder = mainPage.internetSum.getAttribute("placeholder");
        String actualEmailPlaceholder = mainPage.internetEmail.getAttribute("placeholder");

        
        assertEquals(expectedPhonePlaceholder, actualPhonePlaceholder, "Надпись поля телефона не соответствует ожиданиям.");        
        assertEquals(expectedSumPlaceholder, actualSumPlaceholder, "Надпись поля суммы не соответствует ожиданиям.");
        assertEquals(expectedEmailPlaceholder, actualEmailPlaceholder, "Надпись поля email не соответствует ожиданиям.");
    }

    @Test
    @Owner("Попович Евгений")
    @AllureId("001-3")
    @DisplayName("Плейсхолдеры - Рассрочка")
    @Description("Проверяет наличие надписей в незаполненных полях в разделе: Пополнение баланса - Рассрочка")
    @Severity(SeverityLevel.NORMAL)

    public void testPlaceholdersInstalment() {
        
        String expectedPhonePlaceholder = "Номер счета на 44";          
        String expectedSumPlaceholder = "Сумма";
        String expectedEmailPlaceholder = "E-mail для отправки чека"; 

      
        String actualPhonePlaceholder = mainPage.instalmentScore.getAttribute("placeholder");
        String actualSumPlaceholder = mainPage.instalmentSum.getAttribute("placeholder");
        String actualEmailPlaceholder = mainPage.instalmentEmail.getAttribute("placeholder");

        
        assertEquals(expectedPhonePlaceholder, actualPhonePlaceholder, "Надпись поля телефона не соответствует ожиданиям.");        
        assertEquals(expectedSumPlaceholder, actualSumPlaceholder, "Надпись поля суммы не соответствует ожиданиям.");
        assertEquals(expectedEmailPlaceholder, actualEmailPlaceholder, "Надпись поля email не соответствует ожиданиям.");
    }

    @Test
    @Owner("Попович Евгений")
    @AllureId("001-4")
    @DisplayName("Плейсхолдеры - Задолженность")
    @Description("Проверяет наличие надписей в незаполненных полях в разделе: Пополнение баланса-Задолженность")
    @Severity(SeverityLevel.NORMAL)

    public void testPlaceholdersArrears() {
        
        String expectedPhonePlaceholder = "Номер счета на 2073";          
        String expectedSumPlaceholder = "Сумма";
        String expectedEmailPlaceholder = "E-mail для отправки чека"; 

      
        String actualPhonePlaceholder = mainPage.arrearsScore.getAttribute("placeholder");
        String actualSumPlaceholder = mainPage.arrearsSum.getAttribute("placeholder");
        String actualEmailPlaceholder = mainPage.arrearsEmail.getAttribute("placeholder");

        
        assertEquals(expectedPhonePlaceholder, actualPhonePlaceholder, "Надпись поля телефона не соответствует ожиданиям.");        
        assertEquals(expectedSumPlaceholder, actualSumPlaceholder, "Надпись поля суммы не соответствует ожиданиям.");
        assertEquals(expectedEmailPlaceholder, actualEmailPlaceholder, "Надпись поля email не соответствует ожиданиям.");
    }

    @Test
    @Owner("Попович Евгений")
    @AllureId("002-1")
    @DisplayName("Проверка всплывающего окна для оплаты услуг")
    @Description("Вызов всплывающего окна для введения платежной информации и проверка основных его элементов")
    @Severity(SeverityLevel.NORMAL)

    public void testPaymentProcess() {
        // Заполнение полей
        mainPage.uslugiPhone.sendKeys("297777777");
        mainPage.usligiSum.sendKeys("100");
        
        // Нажатие кнопки "Продолжить"
        mainPage.continueButton.click();
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.switchTo().frame(0);
    
        // Проверка отображения суммы
        assertEquals("100.00 BYN", mainPage.payDescriptionCost.getText());
        assertEquals("Оплатить 100.00 BYN", mainPage.payButton.getText());
        
        // Проверка отображения номера телефона
        assertEquals("Оплата: Услуги связи Номер:375297777777", mainPage.payDescriptionText.getText());
    
        // Проверка надписей в незаполненных полях
        assertEquals("Номер карты", mainPage.cardNumber.getText());
        assertEquals("Срок действия", mainPage.cardPeriod.getText());
        assertEquals("CVC", mainPage.cardCvc.getText());
        assertEquals("Имя держателя (как на карте)", mainPage.cardName.getText());
    
        // Проверка наличия иконок платежных систем
        assertTrue(mainPage.gpayButton.isDisplayed());
        assertTrue(mainPage.yandexButton.isDisplayed());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
