package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportPage extends  PageObject{

    LoginPage loginPage;


    //Locator
    @FindBy(css = "ant-btn-default")
    public WebElement bbtnAddnew;

    @FindBy(id = "report_name")
    public WebElement inputReportName;

    @FindBy(id = "description")
    public WebElement Descripton;


    public WebElement Pagination;

    public WebElement Detail;

    public WebElement Summary;

    public WebElement Custom;

    public WebElement mainObject;

    public WebElement ShareToGroup;

    public WebElement btnNext;



    //CustomReport

    public WebElement btnSave;
    @FindBy(css = "div.sc-bkEOxz")
    public WebElement btnADDKEY;

    public WebElement CHECKBOXHIDEN;

    public WebElement btnRunReport;

    WebDriver driver;
    public ReportPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void OpenReportPage(){

    }




}

