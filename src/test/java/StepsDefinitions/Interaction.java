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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Interaction {

    WebDriver driver;
    LoginPage loginPage;
    Dashboard dashboard;
    TicketPage ticketPage;
    InteractionPage interactionPage;

    PageObject pageObject;

    String ListViewTicketPage ="https://uat.basebs.vn/ucrm/objects/obj_ticket_60446569/default-view";

    String InteractionPage = "https://uat.basebs.vn/ucrm/objects/obj_interaction_62080277/default-view";



    @Before
    public void Init(){
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.loginPage = new LoginPage(this.driver);
        this.dashboard = new Dashboard(this.driver);
        this.ticketPage = new TicketPage(this.driver);
        this.interactionPage = new InteractionPage(this.driver);
        this.pageObject = new PageObject(this.driver);
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
    @When("Khi có Email gửi đến Mở màn hình Object Ticket")
    public void khi_có_email_gửi_đến_mở_màn_hình_object_ticket() {
        this.driver.get(ListViewTicketPage);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
    }
    @When("Status Email Ticket = {string}")
    public void status_email_ticket(String Unread) {
        assertThat(this.ticketPage.VerifyUnreadValue(), equalTo(Unread));

    }
    @When("Mở Consolidated view của record và đọc mail")
    public void mở_consolidated_view_của_record_và_đọc_mail() {
        this.ticketPage.OpenConsolidatedvied();
        this.ticketPage.ClickReadMail();

    }
    @When("Status Email Ticket = {string}  Update")
    public void status_email_ticket_update(String Read) {
        this.driver.get(ListViewTicketPage);
        try {
            Thread.sleep(4000);
            assertThat(this.ticketPage.VerifyReadValue(), equalTo(Read));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    @Then("thời gian đọc mail qua object Interaction thành ngày và giờ hiện tại")
    public void thời_gian_đọc_mail_qua_object_interaction_thành_ngày_và_giờ_hiện_tại() {
        this.driver.get(InteractionPage);
        try {
            Thread.sleep(4000);
            assertThat(this.ticketPage.ClickReadMail(), equalTo(this.interactionPage.CheckDateTime()));

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Given("Màn hình Consolidated view của record thuộc object Ticket hiển thị")
    public void màn_hình_consolidated_view_của_record_thuộc_object_ticket_hiển_thị() {
        this.ticketPage.OpenConsolidatedvied();

    }
    @When("Khi gửi Email ra từ UCRM")
    public void khi_gửi_email_ra_từ_ucrm() {
        this.ticketPage.ReplyEmailFromUCRM();
    }
    @When("field Trạng thái phản hồi sẽ được update thành Đã phản hồi")
    public void field_trạng_thái_phản_hồi_sẽ_được_update_thành_đã_phản_hồi() {
        assertThat(this.ticketPage.VerifStatusMailTicket(), equalTo("Đã phản hồi"));
    }
    @When("Trang object Interaction được mở ra")
    public void trang_object_interaction_được_mở_ra() {
        this.driver.get(InteractionPage);
    }
    @Then("Field Trạng thái phản hồi Email1 được update thành Đã phản hồi")
    public void field_trạng_thái_phản_hồi_email1_được_update_thành_đã_phản_hồi() {
        this.interactionPage.VerifStatusMailTicket();
    }
    @Given("Object Ticket Page được mở ra")
    public void object_ticket_page_được_mở_ra() {
        this.driver.get(ListViewTicketPage);
    }
    @When("Khi có Email reply vào UCRM")
    public void khi_có_email_reply_vào_ucrm() {
        this.driver.get(ListViewTicketPage);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));

    }
    @Then("Field Trạng thái phản hồi Email được update thành Chưa phản hồi")
    public void field_trạng_thái_phản_hồi_email_được_update_thành() {
        assertThat(this.ticketPage.VerifStatusMailTicket(), equalTo("Chưa phản hồi"));
    }
    @Given("Màn hình Consolidated view của Email vừa được phản hồi mở ra")
    public void màn_hình_consolidated_view_của_email_vừa_được_phản_hồi_mở_ra() {
        this.ticketPage.OpenConsolidatedvied();
    }
    @When("Trạng thái phản hồi sẽ được update thành Đã phản hồi")
    public void trạng_thái_phản_hồi_sẽ_được_update_thành_đã_phản_hồi() {
        assertThat(this.ticketPage.VerifStatusMailTicket(), equalTo("Đã phản hồi"));
    }











}
