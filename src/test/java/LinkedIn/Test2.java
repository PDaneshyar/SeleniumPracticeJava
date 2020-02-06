package LinkedIn;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


@Execution(ExecutionMode.CONCURRENT)
public class Test2
{
    static String name = "Sam Radage";
    static Person Sam;
    static LinkedIn_Page profile;


    @BeforeAll
    public static void Setup() throws MalformedURLException
    {
        FirefoxOptions options = new FirefoxOptions();
        System.setProperty("webdriver.gecko.driver", "//Users/pdaneshyar/Documents/WebDrivers/geckodriver");
        profile = new LinkedIn_Page(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options));
        Sam = new Person();
        Sam.setName(name);
    }

    @Test
    public void ExecuteTest()
    {
        profile.Search(name);
        profile.LinkedInLink();

        //Sam.setEmployer(profile.TopCardItems().get(0).getText());
        //Sam.setUniversity(profile.TopCardItems().get(1).getText());

        //Assert.assertEquals(Sam.getEmployer(), "Deloitte");
        //Assert.assertEquals(Sam.getUniversity(), "University of Southampton");
        Assert.assertEquals(Sam.getName(), "Sam Radage");
    }

//    @Test
//    public void Test1()
//    {
//        System.out.println("Test2 Hello");
//    }
//
//    @Test
//    public void Test2()
//    {
//        System.out.println("Test2 Hey");
//    }
//
//    @Test
//    public void Test3()
//    {
//        System.out.println("Test2 hi");
//    }

    @AfterAll
    public static void CleanUp()
    {
        profile.CloseDriver();
    }
}
