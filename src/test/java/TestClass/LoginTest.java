package TestClass;

import BaseClass.TestBase;
import Pages.LoginPagenew;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends TestBase {

    public static LoginPagenew page;


    public LoginTest() {
        super();
    }

    @BeforeMethod
    public static void setup() throws InterruptedException {
        Initializing();
        page = new LoginPagenew();
        Thread.sleep(3000);
    }

    @Test
    public void userlogin() throws InterruptedException {
        page.userlogin(prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(5000);
        page.submit();
        page.varifyLoginPage();
        System.out.println("hi");
    }

    @Test
    public void userlogin2() throws InterruptedException {
        page.userlogin(prop.getProperty("username1"), prop.getProperty("password1"));
        page.submit();
       String st =  driver.switchTo().alert().getText();
        System.out.println(st);
       Assert.assertEquals(st,"User or Password is not valid");
       driver.switchTo().alert().accept();
    }
        @AfterMethod
        public void teardown () throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }
    }

