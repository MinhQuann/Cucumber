package StepsDefinitions;

import POM.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStep {

    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void Init(){
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.loginPage = new LoginPage(this.driver);
    }

    @After
    public void After(Scenario scenario){
        final byte[] screenshot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "screenshot");

    }


    @Given("The login page page is showed1")
    public void the_login_page_page_is_showed1() {
        this.loginPage.Open();

    }
    @When("The user login with blank value for both username and password")
    public void the_user_login_with_blank_value_for_both_username_and_password() {
        this.loginPage.btnLogin.click();

    }
    @Then("The msg {string} will be showed for username and {string} for pwd")
    public void the_msg_will_be_showed_for_username_and_for_pwd(String userMess, String pwdMess) {
        assertThat(this.loginPage.get(), equalsTo());


    }
    @When("The user attempt to login with username {string} and pwd {string}")
    public void the_user_attempt_to_login_with_username_and_pwd(String username, String pwd) {
        this.loginPage.btnLogin.sendKeys(username);
        this.loginPage.tbUsername.sendKeys(pwd);
        this.loginPage.btnLogin.click();
    }
    @Then("The msg {string} should be showed")
    public void the_msg_should_be_showed(String string) {


    }
}
