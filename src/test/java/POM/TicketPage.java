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

    public boolean isValueUnReadPresent(){
        WebElement tbbody = driver.findElement(tbodyRecord);
        return tbbody.getText().contains("UnRead");

    }
    public List<String> getCurrentRecordID(){
        List<String> RecordID = new ArrayList<>();
        List<WebElement> rows = driver.findElements(rowLocator);

        for (WebElement row : rows){
            String id = row.getAttribute("id");
            RecordID.add(id);
        }
        return RecordID;
    }

    public void addNewRecord(){

    }

}
