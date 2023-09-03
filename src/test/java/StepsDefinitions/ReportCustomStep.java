package StepsDefinitions;

import POM.Dashboard;
import POM.LoginPage;
import POM.ReportPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ReportCustomStep {
    WebDriver driver;
    LoginPage loginPage;
    Dashboard dashboard;

    ReportPage reportPage;


    @Given("Log in to the UCRM with a valid user account")
    public void log_in_to_the_ucrm_with_a_valid_user_account() {
        this.loginPage.Open();
        this.loginPage.Login("quanbnm@basbes.com", "12345678x@X");
        this.reportPage.OpenReportPage();
    }

    @When("The custom report page is displayed")
    public void the_custom_report_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Apply filter conditions to limit data in the report.")
    public void apply_filter_conditions_to_limit_data_in_the_report() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click Save Report and Noti {string}")
    public void i_click_save_report_and_noti(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I Click RunReport Btn")
    public void i_click_run_report_btn() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I see Expected Result and Noti {string}")
    public void i_see_expected_result_and_noti(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I Click Del btn")
    public void i_click_del_btn() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The Key is deleted")
    public void the_key_is_deleted() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I Add {int} key with Static, RollUp")
    public void i_add_key_with_static_roll_up(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I Add {int} Key with Related Type")
    public void i_add_key_with_related_type(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("The Result is displays")
    public void the_result_is_displays() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }






}
