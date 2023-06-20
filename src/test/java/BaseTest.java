import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    private WebDriver driver;
    String Url = "https://www.nagwa.com/en/";
    HomePage homePage;


    @BeforeTest
    public void setDriver(){
//        if(browserName.equalsIgnoreCase("edge")){
//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();
//
//        } else if (browserName.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        }
//        else{
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
        driver.get(Url);
    }


    @AfterTest
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
