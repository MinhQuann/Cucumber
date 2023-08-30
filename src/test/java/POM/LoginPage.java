package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    @FindBy(css = "input#auth-block")
    public WebElement tbUsername;
    @FindBy(css = "")
    public WebElement tbPassword;
    @FindBy(css = "")
    public WebElement btnLogin;
    @FindBy(css = "")
    public WebElement lbUserNameErr;
    @FindBy(css = "")
    public WebElement lbPWdErr;
    @FindBy(css = "")
    By locErr = By.cssSelector("");


    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;

    }

    public void Open(){
        this.driver.get("https://fado.vn/dang-nhap?redirect=https%3A%2F%2Ffado.vn%2F%3Futm_source%3Dgoogle%26utm_medium%3Dcpc%26ref_id%3Dgooglebrand%26gclid%3DCj0KCQjw0bunBhD9ARIsAAZl0E2hAzEUVld8t5mKB9SQr5lkgT-Sl7mfnhVGTW1jYZWjd-u_mKX2xfAaAm7QEALw_wcB");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        this.driver.manage().window().maximize();

        PageFactory.initElements(this.driver, this);
    }


}
