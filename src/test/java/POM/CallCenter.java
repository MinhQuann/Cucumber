package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CallCenter {


    WebDriver driver;

    By Name = By.id("ucrm_callcenter_0");


    public CallCenter(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String Name() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(40));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Name)).getText();
    }


}

