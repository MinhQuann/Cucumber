package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDateTime;
import java.util.List;

import java.time.format.DateTimeFormatter;

public class TicketPage extends PageObject {


    //Locator
    By tbodyRecord = By.cssSelector("tbody.table-body tr td.sc-huFNyZ");
    By rowLocator = By.xpath("/html/body/div[1]/section/section/main/div[3]/div[1]/div/table/tbody/tr");
    By Emailboxp = By.cssSelector("div[class = 'Email2__WrapEmail-sc-pji6uc-6 hGbKff']");



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
        WebElement latestRecord = records.get(records.size()-1);
        return latestRecord.getAttribute("id");
    }

    public String VerifyUnreadValue() {
        String LastedID = getLatestRecordId();
        return driver.findElement(By.id("ucrm_"+LastedID+"_3")).getText();
    }

    public String VerifyReadValue() {
        String LastedID = getLatestRecordId();
        return driver.findElement(By.id("ucrm_"+LastedID+"_3")).getText();
    }


    public void OpenConsolidatedvied() throws InterruptedException {
        String lastesID = getLatestRecordId();
        this.driver.get("https://uat.basebs.vn/ucrm/consolidated-view/obj_ticket_60446569/"+lastesID);
        this.getDynamicElement(Emailboxp).click();
        Thread.sleep(6000);

    }

    public void ReplyEmailFromUCRM(){

    }


//    public String LatestID(){
//        List<WebElement> rows = driver.findElements(tr);
//        String lastedId = "";
//        for (WebElement row : rows){
//            String rowID = row.getAttribute("id");
//
//            if (rowID.compareTo(lastedId) > 0){
//                lastedId = rowID;
//            }
//        }
//        return lastedId;
//    }



}
