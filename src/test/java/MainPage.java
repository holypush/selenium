import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mts.by");
    }

    @FindBy(xpath = "//*[@id=\"pay-connection\"]/button") WebElement continueButton;
   
    @FindBy(id = "connection-phone") WebElement uslugiPhone;

    @FindBy(id = "connection-sum") WebElement usligiSum;

    @FindBy(id = "connection-email") WebElement uslugiEmail;

    @FindBy(id = "internet-phone") WebElement internetPhone;

    @FindBy(id = "internet-sum") WebElement internetSum;

    @FindBy(id = "internet-email") WebElement internetEmail;

    @FindBy(id = "score-instalment") WebElement instalmentScore;

    @FindBy(id = "instalment-sum") WebElement instalmentSum;
    
    @FindBy(id = "instalment-email") WebElement instalmentEmail;

    @FindBy(id = "score-arrears") WebElement arrearsScore;

    @FindBy(id = "arrears-sum") WebElement arrearsSum;

    @FindBy(id = "arrears-email") WebElement arrearsEmail;

    @FindBy(xpath = "//button[@aria-label='Google Pay']") WebElement gpayButton;

    @FindBy(xpath = "//button[@aria-label='Yandex Pay']") WebElement yandexButton;

    @FindBy(xpath = "//span[text()='100.00 BYN']") WebElement payDescriptionCost;

    @FindBy(xpath = "//span[contains(text(), 'Оплата: Услуги связи')]") WebElement payDescriptionText;

    @FindBy(xpath = "//label[contains(text(), 'Номер карты')]") WebElement cardNumber;

    @FindBy(xpath = "//label[contains(text(), 'Срок действия')]") WebElement cardPeriod;

    @FindBy(xpath = "//label[contains(text(), 'CVC')]") WebElement cardCvc;

    @FindBy(xpath = "//label[contains(text(), 'Имя держателя (как на карте)')]") WebElement cardName;

    @FindBy(className = "colored") WebElement payButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

//