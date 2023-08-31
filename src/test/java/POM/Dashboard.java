package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
    WebDriver driver;

    @FindBy(css = "div##test1.title")

    public WebElement DashTile;



    public Dashboard(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, driver);

    }

    public String GetTitleDashBoard() throws InterruptedException {
        Thread.sleep(5000);
        return driver.getTitle();

    }

}
