package Framework.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class DriverWrapper {
    
    public static WebDriver Driver;

    public static void StartDriver()
    {
        Driver = new ChromeDriver();
        Driver.manage().window().maximize();
    }

    public static void CloseDriver()
    {
        Driver.quit();
    }

}