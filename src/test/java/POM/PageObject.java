package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObject {
    WebDriver driver;

    public PageObject(WebDriver driver){

        this.driver = driver;
    }
    public WebElement getDynamicElement(By locator){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(50));
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

}
