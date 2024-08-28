import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Test15 {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mts.by");
    }

    @Test
    public void testBlockTitle() {
        WebElement blockTitle = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/h2"));
        assertEquals("Онлайн пополнение\nбез комиссии", blockTitle.getText());
    }

    @Test
    public void testPaymentSystemLogos() {
        
        assertTrue(driver.findElements(By.xpath("//img[contains(@src, 'logo')]")).size() > 0, "Логотипы платежных систем не найдены");
    }

    @Test
    public void testMoreInfoLink() {
        WebElement moreInfoLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        assertTrue(moreInfoLink.isDisplayed());
        moreInfoLink.click(); 
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl()); 
    }

    @Test
    public void testContinueButton() {
        

        WebElement phoneField = driver.findElement(By.id("connection-phone"));
        phoneField.sendKeys("297777777"); 

        WebElement sumField = driver.findElement(By.id("connection-sum")); 
        sumField.sendKeys("1000"); 

        WebElement continueButton = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        continueButton.click();

        String expectedTitle = "МТС – мобильный оператор в Беларуси";
        assertEquals(expectedTitle, driver.getTitle());
    }

     @AfterEach
         public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}