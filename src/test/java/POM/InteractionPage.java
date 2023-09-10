package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InteractionPage extends  PageObject{

    By tbody = By.cssSelector("tbody = [class ='table-body']");
    By tr = By.cssSelector("");



   WebDriver driver;
   TicketPage ticketPage;

    public InteractionPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }







}
