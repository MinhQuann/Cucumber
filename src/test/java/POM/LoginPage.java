package POM;

import io.cucumber.java.sl.Ce;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;
import java.time.Duration;


public class LoginPage  extends  PageObject {


    By clickBtnLoginOutSidePage = By.cssSelector("button.ant-btn-primary");

    @FindBy(css = "div.sc-hknOHE")
    public WebElement Profile;

    By LogOut = By.id("ucrm_sign_out");

    @FindBy(id = "basic_email")
    public WebElement EmailLgn;

    @FindBy(id = "basic_pass")
    public WebElement Pwdlgn;

    @FindBy(css = "button[type = 'submit']")
    public WebElement ClickBtnLoginPage;

    By LockMsgWithIncorrectUserName_pwd = By.cssSelector("div.ant-notification-notice-description");

    By InputUserNoti = By.id("basic_email_help");

    By InputPwdNoti = By.id("basic_pass_help");

    @FindBy(xpath = "//div[@class = 'forgot-password']")
    public WebElement ClickForgotPass;

    @FindBy(css = "input[type = 'email']")
    public WebElement ForgotEmailPage;

    @FindBy(xpath = "//button[@class = 'ant-btn-default']")
    public WebElement ClickRestorePwd;

    @FindBy(xpath = "//div[@class = 'backToLogin custom-cursor-on-hover']")
    public WebElement ClickBacktoLoginPage;


    WebDriver driver;
    Dashboard dashboard;

    public void ClickOutSide(){
        this.getDynamicElement(clickBtnLoginOutSidePage).click();

    }

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);

    }

    public void Open() {
        this.driver.get("https://lab.connect247.vn/ucrm-sso/");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        this.getDynamicElement(clickBtnLoginOutSidePage).click();
    }

    public void Login(String userN, String PWD) {
        this.EmailLgn.sendKeys(userN);
        this.Pwdlgn.sendKeys(PWD);
        this.ClickBtnLoginPage.click();
    }

    public void LogOut(){
        this.Profile.click();
        this.getDynamicElement(LogOut).click();

    }

    public String ErrMsg() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(40));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(LockMsgWithIncorrectUserName_pwd)).getText();
    }

    public String ErrMsgInput() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(40));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(InputUserNoti)).getText();

    }

    public String ErrMsgPwdInput() {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(40));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(InputPwdNoti)).getText();
    }

//    public void LoginTest() throws IOException {
//        //Specify the Path to your Excel file and sheet name
//        String filePath = "C:\\Users\\Admin\\Downloads\\LoginFile.xlsx";
//        String sheetName = "Sheet1";
//
//        //Open the Excelfile
//        FileInputStream excelFile = new FileInputStream(filePath);
//        Workbook workbook = new XSSFWorkbook(excelFile);
//        Sheet sheet = workbook.getSheet(sheetName);
//
//        //Iterate through rows and columns to read data
//        for (int i = 1; i <= sheet.getLastRowNum(); i++){
//
//
//            Row row = sheet.getRow(i);
//            String username = row.getCell(0).getStringCellValue();
//            String password = row.getCell(1).getStringCellValue();
//
//            //Use username and password oin your test
//
//            this.EmailLgn.sendKeys(username);
//            this.Pwdlgn.sendKeys(password);
//            this.ClickBtnLoginPage.click();
//        }
//    }
//
//    public void ReadnWrite() throws IOException, InterruptedException {
//        String filePath = "C:\\Users\\Bui Nguyen Minh Quan\\Desktop\\Scritp\\LoginFile.xlsx";
//        String sheetName = "Sheet1";
//
//        //Open the Excelfile
//        FileInputStream excelFile = new FileInputStream(filePath);
//        Workbook workbook = new XSSFWorkbook(excelFile);
//        Sheet sheet = workbook.getSheet(sheetName);
//
//        for (int i = 1; i <= sheet.getLastRowNum(); i++){
//
//            Row row = sheet.getRow(i);
//            String username = row.getCell(0).getStringCellValue();
//            String password = row.getCell(1).getStringCellValue();
//
//
//            Open();
//            performLogin(username,password);
//
//            if (loginPage.performLogin(username,password)){
//                Cell resultCell = row.createCell(2);
//                resultCell.setCellValue("pass");
//            }else {
//                row.createCell(2).setCellValue("fail");
//            }
//        }
//        FileOutputStream outputStream = new FileOutputStream(filePath);
//        workbook.write(outputStream);
//        outputStream.close();
//        workbook.close();
//        excelFile.close();
//    }

//    public boolean performLogin(String username, String password)  {
//        this.Login(username,password);
//         return true;
//    }
    public static void writeResultToExcel (String filePath, String sheetName, int rowNum, int Column, String result) throws IOException {

        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.createCell(Column);
            cell.setCellValue(result);
            FileOutputStream fos = new FileOutputStream(filePath);
            wb.write(fos);
            fos.close();
            fis.close();
        } catch (IOException e){
                e.printStackTrace();
            }
        }
   }



//    public static String readExcel(String filePath, String sheetName, int rowNum, int colNum) throws IOException {
//        FileInputStream fís = new FileInputStream(filePath);
//        Workbook wb = new XSSFWorkbook(fís);
//        Sheet sheet = wb.getSheet(sheetName);
//        Row row = sheet.getRow(rowNum);
//        Cell cell  = row.getCell(colNum);
//        String cellValue = cell.getStringCellValue();
//
//        fís.close();
//        return cellValue;
//    }







