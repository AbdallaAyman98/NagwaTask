package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private WebDriver driver;

    // Locating elements
    private By languageList = By.xpath("//li[@class=\"dropdown\"][1]");
    private By searchBtn = By.xpath("//div/div[3]/button");
    private By englishLan = By.xpath("//a[@data-val=\"en\"]");
    private By spanishLan = By.xpath("//a[@data-val=\"es\"]");
    private By frenchLan = By.xpath("//a[@data-val=\"fr\"]");
    private By arabicLan = By.xpath("//a[@data-val=\"ar\"]");
    private By portLan = By.xpath("//a[@data-val=\"pr\"]");
    private By searchBox = By.id("txt_search_query");
    private By globalSearchBtn = By.id("btn_global_search");


    //HomePage constructor
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    //Function to select the language when automating the tests
    public HomePage selectLanguage(String text){
        By language = null;
        switch(text.toLowerCase()) {
            
            case "english":
            case "en":
                language = englishLan;
                break;
            case "spanish":
            case "es":
            case "español":
                language = spanishLan;
                break;
            case "french":
            case "fr":
            case "français":
                language = frenchLan;
                break;
            case "português":
            case "pr":
                language = portLan;
                break;
            case "arabic":
            case "ar":
            case "العربية":
                language = arabicLan;
                break;
            default:
                break;
        }
        click(languageList).click(language);
        System.out.println();
        return this;
    }


    //Function to click on the "magnifying glass" search button for the search input field to appear/pop
    public HomePage clickSearch(){
        click(searchBtn);
        return this;
    }

    //Function to search for the required lesson
    public SearchResultPage searchLesson(String textToSearch){
        sendKeys(textToSearch,searchBox).click(globalSearchBtn);
        return new SearchResultPage(driver);
    }

}



