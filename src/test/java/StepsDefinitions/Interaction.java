package StepsDefinitions;

import POM.Dashboard;
import POM.LoginPage;
import POM.TicketPage;
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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Interaction {

    WebDriver driver;
    LoginPage loginPage;
    Dashboard dashboard;
    TicketPage ticketPage;

    String ListViewTicketPage ="https://uat.basebs.vn/ucrm/objects/obj_ticket_60446569/default-view";

    String InteractionPage = "https://uat.basebs.vn/ucrm/objects/obj_interaction_62080277/default-view";



    @Before
    public void Init(){
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.loginPage = new LoginPage(this.driver);
        this.dashboard = new Dashboard(this.driver);
        this.ticketPage = new TicketPage(this.driver);
    }

    @After
    public void After(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        driver.quit();
    }

    @Given("Trang Login UAT được mở")
    public void trang_login_uat_được_mở() {
        this.loginPage.OpenUAT();
        this.loginPage.Login("testcrm05@yopmail.com","12345678x@X");
    }
    @When("Khi có Email gửi đến Status Email Ticket = {string}")
    public void khi_có_email_gửi_đến_status_email_ticket(String Unread) {
        try {
            Thread.sleep(5000);
            assertTrue(Unread, this.ticketPage.VerifyUnreadValue());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @When("Mở Consolidated view của record và đọc mail")
    public void mở_consolidated_view_của_record_và_đọc_mail() {
        this.ticketPage.OpenConsolidatedvied();

    }
    @Then("Status Email Ticket = {string}  Update thời gian đọc mail qua object Interaction thành ngày và giờ hiện tại")
    public void status_email_ticket_update_thời_gian_đọc_mail_qua_object_interaction_thành_ngày_và_giờ_hiện_tại(String Read) {
        this.driver.get(ListViewTicketPage);
        try {
            Thread.sleep(5000);
            assertTrue(Read, this.ticketPage.VerifyReadValue());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.driver.get(InteractionPage);
        try {
            Thread.sleep(5000);

        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }






    }














}
