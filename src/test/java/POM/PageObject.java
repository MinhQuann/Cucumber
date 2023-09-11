package POM;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public  String DateTime(){
        LocalDateTime currentTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return currentTime.format(formatter);
    }
    public void LoginMail(){
        this.driver.get("https://mail.google.com/mail/u/0/?pli=1#inbox");
        this.driver.findElement(By.xpath("//input[type ='email']")).sendKeys("quanbnm@basebs.com");
        this.driver.findElement(By.xpath("//")).click();
        this.driver.findElement(By.xpath("//input[type = 'password'")).sendKeys("quan081098");

        this.driver.findElement(By.cssSelector("div[class = 'T-I T-I-KE L3']")).click();
        this.driver.findElement(By.id(":sv")).sendKeys("unifycrm.test02@outlook.com", Keys.ENTER);
        this.driver.findElement(By.id(":p2")).sendKeys("Test Email");
        this.driver.findElement(By.id(":qa")).sendKeys("Đây là mail test");
        this.driver.findElement(By.id(":ós")).click();
    }



}
