package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LessonWorksheetPage extends BasePage {
    private WebDriver driver;

    //Locating elements
    private By choices = By.cssSelector(".mcq_choices");

    //LessonWorksheet constructor
    public LessonWorksheetPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    //Function to get the size of a list of WebElements
    //8.Worksheet home page will open then count number of questions displayed on it and print the count.
    public int getQuestionsCount(){
      return findElements(choices).size();
    }
}
