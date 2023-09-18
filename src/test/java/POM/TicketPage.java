package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDateTime;
import java.util.List;

import java.time.format.DateTimeFormatter;

public class TicketPage extends PageObject {


    //Locator
    By tbodyRecord = By.cssSelector("tbody.table-body");
    By rowLocator = By.xpath("/html/body/div[1]/section/section/main/div[3]/div[1]/div/table/tbody/tr");
    By Emailboxp = By.cssSelector("div[class = 'Email2__WrapEmail-sc-pji6uc-6 hGbKff']");

    By Reply = By.cssSelector("button[class = 'ant-btn ant-btn-default Email2__Reply-sc-pji6uc-24 cxGUgT']");

    By BodyRepmail = By.cssSelector("div.jodit-wysiwyg");

    By SendEmail = By.cssSelector("button[class = 'ant-btn ant-btn-primary Email2__SendEmail-sc-pji6uc-29 bMIhLb']");

    WebDriver driver;

    InteractionPage interactionPage;



    public TicketPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public List<WebElement> getCurrentRecord(){
        WebElement tbody = driver.findElement(tbodyRecord);
        return tbody.findElements(rowLocator);
    }
    public String getLatestRecordId(){
        // lấy danh sách các record hiện tại
         List<WebElement> records = getCurrentRecord();

         // Lấy ID mới nhất bảng
        WebElement latestRecord = records.get(0);
        return latestRecord.getAttribute("id");

    }

    public String VerifyUnreadValue() {

        return driver.findElement(By.id("ucrm_"+getLatestRecordId()+"_4")).getText();
    }

    public String VerifyReadValue() {

        return driver.findElement(By.id("ucrm_"+getLatestRecordId()+"_4")).getText();
    }


    public void OpenConsolidatedvied()  {
        String lastesID = getLatestRecordId();
        this.driver.get("https://uat.basebs.vn/ucrm/consolidated-view/obj_ticket_60446569/"+lastesID);
    }

    public String ClickReadMail(){
        this.getDynamicElement(Emailboxp).click();
        LocalDateTime currentTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        return formattedTime;
    }
//    public String Timereadmail(){
//        LocalDateTime currentTime = LocalDateTime.now();
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String formattedTime = currentTime.format(formatter);
//
//        return formattedTime;
//
//    }



    public void ReplyEmailFromUCRM(){
        this.getDynamicElement(Emailboxp).click();
        this.driver.findElement(Reply).click();
        this.driver.findElement(BodyRepmail).sendKeys("xin chào mail test");
        this.driver.findElement(SendEmail).click();

    }

    public String VerifStatusMailTicket(){
        return driver.findElement(By.id("ucrm_"+getLatestRecordId()+"_9")).getText();
    }




}
