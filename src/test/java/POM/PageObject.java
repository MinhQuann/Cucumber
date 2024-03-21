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

    CallCenter CallCenter;

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
//    public void LoginMail() throws InterruptedException {
//        this.driver.get("https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ifkv=AYZoVhe_AUR3LnZDQ7_QQYmDuPk2tbRo5ScSwF7mNCSnNeqWZJtLzfCWYxjFkETtPTRDJ3Rquo9sXw&rip=1&sacu=1&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S-905116890%3A1694756607960598&theme=glif");
//        this.driver.findElement(By.cssSelector("div.Xb9hP input[ type = 'email']")).sendKeys("quanbnm@basebs.com", Keys.ENTER);
////        this.driver.findElement(By.xpath("//span[@jsname = 'V67aGc']")).click();
//        Thread.sleep(3000);
//        this.driver.findElement(By.cssSelector("div.Xb9hP input[type = 'password']")).sendKeys("Quan081098", Keys.ENTER);
//        Thread.sleep(5000);
////        this.driver.findElement(By.xpath("//span[@jsname = 'V67aGc']")).click();
//        this.driver.findElement(By.cssSelector("button[class = 'by7 T-I']")).click();
//        this.driver.findElement(By.cssSelector("div[class = 'z0'] div[class = 'T-I T-I-KE L3']")).click();
//        Thread.sleep(4000);
//        //Email
//        this.driver.findElement(By.cssSelector("input[class ='agP aFw']")).sendKeys("unifycrm.test02@outlook.com");
//        // Subject
//        this.driver.findElement(By.cssSelector("input[name = 'subjectbox']")).sendKeys("Test Email");
//        //Body
//        this.driver.findElement(By.id(":qa")).sendKeys("Đây là mail test");
//        this.driver.findElement(By.id(":ós")).click();
//    }



}
