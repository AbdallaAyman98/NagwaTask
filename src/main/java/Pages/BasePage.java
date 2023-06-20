package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BasePage {

// A utility class
    private WebDriverWait driverWait;
    private WebDriver driver;
    private Select select;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private BasePage waitForElementToDisappear(By by){
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        return this;
    }
    private BasePage waitForElementToBeClickable(By by){
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.elementToBeClickable(by));
        return this;
    }

    private BasePage waitForTexToBe(By by, String string){
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.textToBe(by, string));
        return this;

    }
    private BasePage waitForElementToAppear(By by){
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return this;
    }

    private BasePage waitForElementsToAppear(By by){
        driverWait = new WebDriverWait(driver,Duration.ofSeconds(20));
        driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        return this;
    }
    protected BasePage click(By by){
        waitForElementToBeClickable(by);
        driver.findElement(by).click();
        return this;
    }
    protected BasePage sendKeys(String string, By by){
        waitForElementToAppear(by);
        driver.findElement(by).sendKeys(string);
        return this;
    }

    protected String getText(By by){
        waitForElementToAppear(by);
        return driver.findElement(by).getText();
    }

    protected BasePage hoverOver(By by){
        waitForElementToAppear(by);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(by)).perform();
        return this;
    }

    protected BasePage clearField(By by){
        waitForElementToAppear(by);
        driver.findElement(by).clear();
        return this;
    }

    protected BasePage selectByText(By by, String text){
        waitForElementToAppear(by);
        select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
        return this;
    }


    //Function returns a list of WebElements, if there are no elements it returns an empty List, []
    protected List<WebElement> findElements(By by){
        waitForElementsToAppear(by);
        return driver.findElements(by);
    }

}
