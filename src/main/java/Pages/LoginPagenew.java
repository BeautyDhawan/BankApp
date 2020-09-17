package Pages;

import BaseClass.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPagenew extends TestBase {
    WebDriverWait wait;

    @FindBy(name = "uid")
    WebElement username ;
    @FindBy(name = "password")
    WebElement password ;
    @FindBy(name = "btnLogin")
    WebElement submit ;
    @FindBy(xpath = "//td[contains(text(),'Manger Id : mngr284491')]")
    WebElement LoginVarify;


    public LoginPagenew(){
        PageFactory.initElements(driver,this);
    }

    public void userlogin(String uname, String pwd){
        username.sendKeys(uname);
        password.sendKeys(pwd);
    }

    public boolean varifyLoginPage(){
        wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(LoginVarify));
        return LoginVarify.isDisplayed();

    }
    public  void submit(){
        submit.click();
    }

}
