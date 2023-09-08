package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class TicketPage extends PageObject {

    //Locator
    By tbodyRecord = By.cssSelector("tbody.table-body");
    By rowLocator = By.xpath("/html/body/div[1]/section/section/main/div[3]/div[1]/div/table/tbody/tr");


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
        WebElement latestRecord = records.get(records.size() -1);
        return latestRecord.getAttribute("id");
    }

    public String getUnreadValueForLatestRecord(){
        // Lấy ID mới nhất
        String latestId = getLatestRecordId();

        //Xác định field Unread tồn tại trong record mới nhất
        By UnreadLocator = By.xpath("//*[@id="+latestId+"]");

        //Lấy giá trị Unread
        WebElement unread = driver.findElement(UnreadLocator);
        return unread.getText();
    }

    public void ClickNewRecordToOpenConsolidatedView(){
    }





}
