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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertTrue;

public class Interaction {

    WebDriver driver;
    LoginPage loginPage;
    Dashboard dashboard;
    TicketPage ticketPage;
    private List<String> initialRecordIds;

    @Before
    public void Init(){
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.loginPage = new LoginPage(this.driver);
        this.dashboard = new Dashboard(this.driver);
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
    @When("Khi có Email gửi đến Status Email Ticket = Unread")
    public void khi_có_email_gửi_đến_status_email_ticket() {
        initialRecordIds = this.ticketPage.getCurrentRecordID();

        boolean isValueUnReadPresent = this.ticketPage.isValueUnReadPresent();
        assertTrue("Unread", isValueUnReadPresent);
    }
    @When("Mở Consolidated view của record và đọc mail")
    public void mở_consolidated_view_của_record_và_đọc_mail() {


    }
    @Then("Status Email Ticket = Read và Update thời gian đọc mail qua object Interaction thành ngày và giờ hiện tại")
    public void status_email_ticket_và_update_thời_gian_đọc_mail_qua_object_interaction_thành_ngày_và_giờ_hiện_tại(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Màn hình Consolidated view của record thuộc object Ticket hiển thị")
    public void màn_hình_consolidated_view_của_record_thuộc_object_ticket_hiển_thị() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Khi gửi Email ra từ UCRM field Trạng thái phản hồi sẽ được update thành {string}")
    public void khi_gửi_email_ra_từ_ucrm_field_trạng_thái_phản_hồi_sẽ_được_update_thành(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Trang object Interaction được mở ra")
    public void trang_object_interaction_được_mở_ra() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Field Trạng thái phản hồi Email1 được update thành {string}")
    public void field_trạng_thái_phản_hồi_email1_được_update_thành(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Khi có Email reply vào UCRM => Status của ticket sẽ được update về {string}")
    public void khi_có_email_reply_vào_ucrm_status_của_ticket_sẽ_được_update_về(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Field Trạng thái phản hồi Email2 được update thành {string}")
    public void field_trạng_thái_phản_hồi_email2_được_update_thành(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }








}
