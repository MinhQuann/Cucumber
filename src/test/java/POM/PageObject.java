package POM;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

public class PageObject {
    WebDriver driver;
    Dashboard dashboard;

    LoginPage loginPage;

    public PageObject(WebDriver driver){

        this.driver = driver;
    }
    public WebElement getDynamicElement(By locator){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(50));
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }



}
