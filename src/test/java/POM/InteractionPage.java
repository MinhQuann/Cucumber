package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InteractionPage extends  PageObject{

    By tbody = By.cssSelector("tbody = [class ='table-body']");
    By tr = By.xpath("//tr[@id]");


   WebDriver driver;
   TicketPage ticketPage;

    public InteractionPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String LatestID(){
        List<WebElement> rows = driver.findElements(tr);
        String lastedId = "";
        for (WebElement row : rows){
            String rowID = row.getAttribute("id");

            if (rowID.compareTo(lastedId) > 0){
                lastedId = rowID;
            }
        }
        return lastedId;
    }
    public WebElement newID(){

        return driver.findElement(By.id(LatestID()));
    }

    public String CheckDateTime(){
        String LastestID = this.ticketPage.getLatestRecordId();
        return driver.findElement(By.id("ucrm_"+LastestID+"_8")).getText();

    }
    public String VerifStatusMailTicket(){
        String LastestID =  this.ticketPage.getLatestRecordId();
        return driver.findElement(By.id("ucrm_"+LastestID+"_7")).getText();
    }




















}
