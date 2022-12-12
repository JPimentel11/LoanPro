package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import Framework.Pages.*;
import Framework.Utilities.*;

public class LoginTest {
    
    @Before
    public void Init()
    {
        DriverWrapper.StartDriver();
    }

    @Test
    public void TestLogin() throws InterruptedException
    {
        //Load pages
        LoginPage loginPage = new LoginPage(DriverWrapper.Driver);
        LoanManagerPage loanManagerPage = new LoanManagerPage(DriverWrapper.Driver);
        
        //Test Instructions
        DriverWrapper.Driver.get(loginPage.Url);
        loginPage.WaitForPageToBeLoaded();
        assert loginPage.IsPageLoaded();
        loginPage.Login("loanproqaautomatedapitesting+atestpractice@gmail.com", "%Wd5u50Q1?121");
        loanManagerPage.DismissPasswordChangeModal();
        loanManagerPage.WaitForPageToBeLoaded();
        assert loanManagerPage.IsPageLoaded();
        loanManagerPage.SearchForApprovedLoans();
        System.out.println(loanManagerPage.AccountNumber());
        assert loanManagerPage.AccountNumber() == 5;
        System.out.println(loanManagerPage.StatusOfFirstLoan());
        assertEquals(loanManagerPage.StatusOfFirstLoan(), "Approved");

        //Logout
        loanManagerPage.Logout();
    }

    @After
    public void Teardown()
    {
        DriverWrapper.Driver.quit();
    }

}
