package StepsDefinitions;

import POM.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.security.Key;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class CallCenter {

    WebDriver driver;
    LoginPage loginPage;

    POM.CallCenter callCenter;
    PageObject pageObject;


//    String ListViewTicketPage ="https://uat.basebs.vn/ucrm/objects/obj_ticket_60446569/default-view";
//
//    String InteractionPage = "https://uat.basebs.vn/ucrm/objects/obj_interaction_62080277/default-view";



    @Before
    public void Init(){
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.loginPage = new LoginPage(this.driver);
        this.pageObject = new PageObject(this.driver);
        this.callCenter = new POM.CallCenter(this.driver);
    }

    @After
    public void After(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        driver.quit();
    }

    @Given("The login page page is showed")
    public void the_login_page_page_is_showed() {
        this.loginPage.OpenV3();
        this.loginPage.Login("vietinbank@yopmail.com","Quan0810x@X");

    }
    @When("Đợi 10s")
    public void đợi_10s() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @When("KH mới sẽ được set {string} name")
    public void kh_mới_sẽ_được_set_name(String Default) {
        Assert.assertEquals(this.callCenter.Name(), Default);


    }
    @When("Field Category được mở khi đã được setting PickList Dependency")
    public void field_được_mở_khi_đã_được_setting_pick_list_dependency() {


    }
    @When("Thực hiện chọn Category {string}")
    public void thực_hiện_chọn_category(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Thực hiện chọn Topic LV1 {string}")
    public void thực_hiện_chọn_topic_lv1(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Thực hiện chọn Topic LV2 {string}")
    public void thực_hiện_chọn_topic_lv2(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Thực hiện chọn Topic LV3 {string}")
    public void thực_hiện_chọn_topic_lv3(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Thực hiện Save")
    public void thực_hiện_save() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("{string}, {string},{string},{string} vẫn hiển thị")
    public void vẫn_hiển_thị(String string, String string2, String string3, String string4) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
