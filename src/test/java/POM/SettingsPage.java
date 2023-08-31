package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {
        WebDriver driver;

        @FindBy(css = "div#ucrm_setting_0_0")
        public WebElement User;

        @FindBy(css = "div#ucrm_setting_0_1")
        public WebElement Role;

        @FindBy(css = "div#ucrm_setting_0_2")
        public WebElement Profiles;

        @FindBy(css = "div#ucrm_setting_0_3")
        public WebElement Group;

        @FindBy(css = "div#ucrm_setting_0_4")
        public WebElement Sharing;

        @FindBy(css = "div#ucrm_setting_0_5")
        public WebElement CiteriaSharing;

        @FindBy(css = "div#ucrm_setting_0_6")
        public WebElement BrandName;

        @FindBy(css = "div#ucrm_setting_0_7")
        public WebElement AssignmentRule;

        @FindBy(css = "div#ucrm_setting_0_8")
        public WebElement AgentsMonitor;

        @FindBy(css = "div#ucrm_setting_1_0")
        public WebElement ObjectManagement;

        @FindBy(css = "div#ucrm_setting_1_1")
        public WebElement Object_Layout;

        @FindBy(css = "div#ucrm_setting_1_2")
        public WebElement CreateTemplateRecord;

        @FindBy(css = "div#ucrm_setting_1_3")
        public WebElement FormSetting;
        @FindBy(css = "div#ucrm_setting_1_4")
        public WebElement RelatedObject;

        @FindBy(css = "div#ucrm_setting_1_5")
        public WebElement PicklistDependency;

        @FindBy(css = "div#ucrm_setting_1_10")
        public WebElement DuplicatesRules;

        @FindBy(css = "div#ucrm_setting_1_12")
        public WebElement InteractionSetting;

        @FindBy(css = "div#ucrm_setting_1_14")
        public WebElement QM;

        @FindBy(css = "div#ucrm_setting_2_0")
        public WebElement WorkFlow;

        @FindBy(css = "div#ucrm_setting_2_1")
        public WebElement SLA;

        @FindBy(css = "div#ucrm_setting_2_2")
        public WebElement DynamicButton;

        @FindBy(css = "div#ucrm_setting_3_0")
        public WebElement EmailTemplate;

        @FindBy(css = "div#ucrm_setting_3_1")
        public WebElement EmailIncoming;

        @FindBy(css = "div#ucrm_setting_3_2")
        public WebElement EmailOutgoing;

        @FindBy(css = "div#ucrm_setting_4_0")
        public WebElement SMSTemplate;

        @FindBy(css = "div#ucrm_setting_4_1")
        public WebElement SMSOutgoing;

        @FindBy(css = "div#ucrm_setting_6_4")
        public WebElement URLPopSetting;

        @FindBy(css = "div#ucrm_setting_6_7")
        public WebElement ExposeAPI_Check;

        @FindBy(css = "div#ucrm_setting_6_8")
        public WebElement ExposeAPI_Create;

        @FindBy(css = "div#ucrm_setting_6_9")
        public WebElement ExposeAPI_Update;

        @FindBy(css = "div#ucrm_setting_6_10")
        public WebElement ExposeAPI_DeleteFile;

        @FindBy(css = "div#ucrm_setting_6_11")
        public WebElement ExposeAPI_ViewFile;

        @FindBy(css = "div#ucrm_setting_6_12")
        public WebElement ExposeAPI_UploadFile;

        @FindBy(css = "div#ucrm_setting_6_13")
        public WebElement ExternalAppIntegration;

        @FindBy(css = "div#ucrm_setting_6_14")
        public WebElement ICIntegration;


        public SettingsPage(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(this.driver, this);
        }
}
