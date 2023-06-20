package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LessonPage extends BasePage {
    private WebDriver driver;

    //Locating elements
    private By lessonWorksheet = By.xpath("//div[@class=\"components\"]/ul/li[4]");

    //LessonPage constructor
    public LessonPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //Function to click on the worksheet link
    public LessonWorksheetPage clickWorksheet(){
        click(lessonWorksheet);
        return new LessonWorksheetPage(driver);
    }



}
