package Framework.Pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoanManagerPage {

    WebDriver Driver;

    public LoanManagerPage(WebDriver Driver)
    {
        this.Driver = Driver;
    }
    
    public String Url = "https://beta-loanpro.simnang.com/client/app/index.php#/t_/797/loan/menu";

    By ModalNoButton = By.xpath("/html/body/div[8]/md-dialog/form/md-dialog-actions/button[1]");
    By TenantTitle = By.xpath("//*[@id='headerSection']/div[1]/div[1]");
    By NavigationTab = By.xpath("//*[@id='navigationLeft']/ul/li");
    By UserProfilePicture = By.xpath("//*[@id='headerSection']/div[2]/md-menu/div[1]/a/img[1]");
    By NewLoanButton = By.className("loan-manager-button");
    By ExcelReportsIcon = By.className("new-lp-icon-excel-reports");
    By LoanStatusDropdown = By.id("loanStatus");
    By ApprovedSelection = By.id("select_option_214");
    By NumberOfAccounts = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[1]/div/div[1]/md-whiteframe/div/div/md-content/div[1]/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div/md-whiteframe[2]/div[2]/div[1]");
    By FirstLoanStatus = By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[1]/div/div[1]/md-whiteframe/div/div/md-content/div[2]/table/tbody/tr[1]/td[25]");    
    By UserProfileMenuContainer = By.className("user-profile-menu-container");
    By LogoutButton = By.xpath("//*[@id='menu_container_3']/md-menu-content/md-menu-item[6]/a");



    public void WaitForPageToBeLoaded()
    {
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FirstLoanStatus));
    }

    public boolean IsPageLoaded()
    {
        if (Driver.findElement(TenantTitle).isDisplayed() 
            && Driver.findElement(NavigationTab).isDisplayed() 
            && Driver.findElement(UserProfilePicture).isDisplayed()
            && Driver.findElement(NewLoanButton).isDisplayed())
            //&& Driver.findElement(ExcelReportsIcon).isDisplayed())
        {
            return true;
        }
        else 
        {
            return false;
        }
    } 
    
    public void DismissPasswordChangeModal()
    {
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ModalNoButton));
        Driver.findElement(ModalNoButton).click();
    }

    public void SearchForApprovedLoans() throws InterruptedException
    {
        Driver.findElement(LoanStatusDropdown).click();
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ApprovedSelection));
        Driver.findElement(ApprovedSelection).click();
        Thread.sleep(3000);
    }

    public int AccountNumber()
    {
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FirstLoanStatus));

        return Integer.parseInt(Driver.findElement(NumberOfAccounts).getText().toString());

    }

    public String StatusOfFirstLoan()
    {
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FirstLoanStatus));

        return Driver.findElement(FirstLoanStatus).getText().toString();
    }

    public void Logout()
    {
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(UserProfileMenuContainer));

        Driver.findElement(UserProfileMenuContainer).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(LogoutButton));
        Driver.findElement(LogoutButton).click();
    }

    
}

