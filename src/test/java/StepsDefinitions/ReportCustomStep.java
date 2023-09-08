package StepsDefinitions;

import POM.Dashboard;
import POM.LoginPage;
import POM.ReportPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ReportCustomStep {
    WebDriver driver;
    LoginPage loginPage;
    Dashboard dashboard;
    ReportPage reportPage;


    @Given("Log in to the UCRM with a valid user account")
    public void log_in_to_the_ucrm_with_a_valid_user_account() {
        this.loginPage.Open();
        this.loginPage.Login("quanbnm@basebs.com", "12345678x@X");
    }
    @When("The user attempt to create Report")
    public void the_user_attempt_to_create_report() {
        this.reportPage.CreateReport();

    }
    @Then("{string} name is showed, {string} btn, {string} btn")
    public void name_is_showed_btn_btn(String NameReport, String Save, String RunReport) {
        assertThat(this.reportPage.getText(), equalTo(NameReport));
    }
    @When("The custom report page is displayed")
    public void the_custom_report_page_is_displayed() {
        this.reportPage.OpenCustomReport();
    }
    @When("Apply filter conditions to limit data in the report.")
    public void apply_filter_conditions_to_limit_data_in_the_report() {

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

    @When("I Add ten key with Static, RollUp")
    public void i_add_key_with_static_roll_up() {

    }
    @When("I Add five Key with Related Type")
    public void i_add_key_with_related_type() {
    }

    @Then("The Result is displays")
    public void the_result_is_displays() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }








}