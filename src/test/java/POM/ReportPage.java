package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportPage extends  PageObject{

    LoginPage loginPage;


    //Locator
//    @FindBy
//    public WebElement ReportFunction;
    @FindBy(css = "ant-btn-default")
    public WebElement bbtnAddnew;

    @FindBy(id = "report_name")
    public WebElement inputReportName;

    @FindBy(id = "description")
    public WebElement Descripton;

    @FindBy(id = "report_type_0")
    public WebElement Pagination;

    @FindBy(id = "report_type_1")
    public WebElement Detail;

    @FindBy(id = "report_type_2")
    public WebElement Summary;

    @FindBy(id = "report_type_custom")
    public WebElement Custom;

    @FindBy(id = "main_object")
    public WebElement mainObject;

    @FindBy(id = "share_group")
    public WebElement ShareToGroup;

    @FindBy(css = "button.ant-btn-primary")
    public WebElement btnNext;

    By DelbtnReport  = By.cssSelector("div.sc-lmUcrn img[alt = \"delete\"]");

    //CustomReport

    By Name = By.cssSelector("div.sc-pKqro");

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

    public void CreateReport(){
        this.driver.get("https://lab.connect247.vn/ucrm-sso/report#my_folders");
        this.bbtnAddnew.click();
        this.inputReportName.sendKeys("Automation Test CustomReport");
        this.Descripton.sendKeys("Test Custom Report");
        this.Custom.click();
        this.btnNext.click();
    }

    public WebElement getText(){
        return this.getDynamicElement(Name);
    }


    public void OpenCustomReport(){
        this.driver.get("https://lab.connect247.vn/ucrm-sso/custom-report/64f499b154fe4c0a7eaafd12");
    }
//    public List<String> Name(){
//
//         //return  this.getDynamicElement(Name).getText();
//
////        this.getDynamicElement(btnSave).getText();
////        this.getDynamicElement(btnRunReport).getText();
//
//        return
//    }




}

