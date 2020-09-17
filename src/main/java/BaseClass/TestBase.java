package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public static Properties prop;
    public static WebDriver driver;

public TestBase() {
    prop = new Properties();
    FileInputStream ip = null;

    try {
        ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Config\\Config.properties");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    try {
        prop.load(ip);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public static void Initializing() throws InterruptedException {
        String browsername = prop.getProperty("browser");
        if(browsername.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Beauty\\Desktop\\New\\geckodrivernew.exe");

            driver = new FirefoxDriver();

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            Thread.sleep(5000);

            driver.get(prop.getProperty("urlforlogin"));



        }
    }


}
