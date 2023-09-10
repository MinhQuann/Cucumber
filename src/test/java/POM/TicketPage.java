package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import java.time.format.DateTimeFormatter;

public class TicketPage extends PageObject {

    //Locator
    By tbodyRecord = By.cssSelector("tbody.table-body tr td.sc-huFNyZ");
    By rowLocator = By.xpath("/html/body/div[1]/section/section/main/div[3]/div[1]/div/table/tbody/tr");
    By Emailboxp = By.cssSelector("div[class = 'Email2__WrapEmail-sc-pji6uc-6 hGbKff']");



    WebDriver driver;



    public TicketPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public List<WebElement> getCurrentRecord(){
        WebElement tbody = driver.findElement(tbodyRecord);
        List<WebElement> records = tbody.findElements(rowLocator);
        return records;
    }


    public String getLatestRecordId(){
        // lấy danh sách các record hiện tại
         List<WebElement> records = getCurrentRecord();

         // Lấy ID mới nhất bảng
        WebElement latestRecord = records.get(records.size()-1);
        return latestRecord.getAttribute("id");
    }

    public boolean VerifyUnreadValue() {
        List<WebElement> rows = driver.findElements(rowLocator);
        boolean unreadText = false;
        for (WebElement row : rows) {
            unreadText = row.getText().contains("Unread");
        }
        return unreadText;


    }

    public boolean VerifyReadValue() {
        List<WebElement> rows = driver.findElements(rowLocator);
        boolean ReadText = false;
        for (WebElement row : rows) {
            ReadText = row.getText().contains("Read");
        }
        return ReadText;
    }

    public void LoginMail(){
        //        this.driver.get("https://mail.google.com/mail/u/0/?pli=1#inbox");
//        this.driver.findElement(By.cssSelector("div[class = 'T-I T-I-KE L3']")).click();
//        this.driver.findElement(By.id(":sv")).sendKeys("unifycrm.test02@outlook.com", Keys.ENTER);
//        this.driver.findElement(By.id(":p2")).sendKeys("Test Email");
//        this.driver.findElement(By.id(":qa")).sendKeys("Đây là mail test");
//        this.driver.findElement(By.id(":ós")).click();
    }



    public void OpenConsolidatedvied(){
        String lastesID = getLatestRecordId();
        this.driver.get("https://uat.basebs.vn/ucrm/consolidated-view/obj_ticket_60446569/"+lastesID);
        this.getDynamicElement(Emailboxp).click();


    }
    public  String DateTime(){
       LocalDateTime currentTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = currentTime.format(formatter);

        return formattedTime;
    }


}
