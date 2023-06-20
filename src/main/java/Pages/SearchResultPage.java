package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {
    private WebDriver driver;

    //Locating elements
    private By searchItem;

    //SearchResultPage Constructor
    public SearchResultPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    //Function to click on the lesson from the search result page by index [1/2/3/4]
    public LessonPage clickLesson(int lessonIndex){
        searchItem = By.xpath("//ul/li["+lessonIndex+"]/div/a");
        click(searchItem);
        return new LessonPage(driver);
    }
}
