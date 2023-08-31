package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage  extends  PageObject{

    By clickBtnLoginOutSidePage = By.cssSelector("button.ant-btn-primary");

    @FindBy(id = "basic_email")
    public WebElement EmailLgn;

    @FindBy(id = "basic_pass")
    public WebElement Pwdlgn;

    @FindBy(css = "button[type = 'submit']")
    public WebElement ClickBtnLoginPage;

    By LockMsgWithIncorrectUserName_pwd = By.cssSelector("div.ant-notification-notice-description");

    By InputUserNoti = By.cssSelector("div.ant-form-item-explain-error");

    By InputPwdNoti = By.cssSelector("div.ant-form-item-explain-error");

    @FindBy(xpath = "//div[@class = 'forgot-password']")
    public WebElement ClickForgotPass;

    @FindBy(css = "input[type = 'email']")
    public  WebElement ForgotEmailPage;

    @FindBy(xpath = "//button[@class = 'ant-btn-default']")
    public  WebElement ClickRestorePwd;

    @FindBy(xpath = "//div[@class = 'backToLogin custom-cursor-on-hover']")
    public WebElement ClickBacktoLoginPage;



    WebDriver driver;
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);

    }

    public void Open(){
        this.driver.get("https://lab.connect247.vn/ucrm-sso/");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        this.getDynamicElement(clickBtnLoginOutSidePage).click();

    }
    public void LoginPass_Fail(String userN, String PWD){
        this.EmailLgn.sendKeys(userN);
        this.Pwdlgn.sendKeys(PWD);
        this.ClickBtnLoginPage.click();
    }


    public String ErrMsg(){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(40));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(LockMsgWithIncorrectUserName_pwd)).getText();

    }

    public String ErrMsgInput(){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(40));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(InputUserNoti)).getText();

    }

    public String ErrMsgPwdInput(){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(40));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(InputPwdNoti)).getText();
    }


}
