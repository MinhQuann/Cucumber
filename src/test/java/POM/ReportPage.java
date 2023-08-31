package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ReportPage extends  PageObject{

    //Locator


    public ReportPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}

