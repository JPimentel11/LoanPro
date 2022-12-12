package Framework.Pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {
    
    WebDriver Driver;

    public LoginPage(WebDriver Driver)
    {
        this.Driver = Driver;
    }
    public String Url = "https://beta-loanpro.simnang.com/client/app/login.html?";
    
    By UsernameField = By.id("username");
    By PasswordField = By.id("password");
    By LoginButton = By.className("lp-login-btn");

    public void WaitForPageToBeLoaded()
    {
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(UsernameField));
    }

    public boolean IsPageLoaded()
    {
        if (Driver.findElement(UsernameField).isDisplayed() && Driver.findElement(PasswordField).isDisplayed() && Driver.findElement(LoginButton).isDisplayed())
        {
            return true;
        }
        else 
        {
            return false;
        }
    } 

    private void EnterUsername(String username)
    {
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(UsernameField));
        Driver.findElement(UsernameField).sendKeys(username);
    }

    private void EnterPassword(String password)
    {
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PasswordField));
        Driver.findElement(PasswordField).sendKeys(password);
    }

    public void Login(String username, String password) throws InterruptedException
    {
        EnterUsername(username);
        EnterPassword(password);
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(Driver.findElement(LoginButton), "disabled", "disabled")));
        Driver.findElement(LoginButton).click();
    }

    


}
