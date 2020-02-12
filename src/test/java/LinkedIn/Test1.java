package LinkedIn;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

@Execution(ExecutionMode.CONCURRENT)
public class Test1
{
    static String name = "Shaun Koon";
    static Person Shaun;
    static LinkedIn_Page profile;


    @BeforeAll
    public static void Setup() throws MalformedURLException
    {
        // specify the file path to the chromedriver instance
//        System.setProperty("webdriver.chrome.driver", "//Users/pdaneshyar/Documents/WebDrivers/chromedriver");
        profile = new LinkedIn_Page(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome()));
//        Shaun = new Person();
//        Shaun.setName(name);
        profile.stall();
    }

    @Test
    public void ExecuteTest()
    {
        Assert.assertEquals(profile.navBar(), "Test App");
//        profile.Search(name);
//        profile.LinkedInLink();
        //profile.Shauns();

        //Shaun.setEmployer(profile.TopCardItems().get(0).getText());
        //Shaun.setUniversity(profile.TopCardItems().get(1).getText());

        //Assert.assertEquals(Shaun.getEmployer(), "Sparta Global");
        //Assert.assertEquals(Shaun.getUniversity(), "University of Nottingham");
//        Assert.assertEquals(Shaun.getName(), "Shaun Koon");
    }

//    @Test
//    public void Test1()
//    {
//        System.out.println("Test1 Hello");
//    }
//
//    @Test
//    public void Test2()
//    {
//        System.out.println("Test1 Hey");
//    }
//
//    @Test
//    public void Test3()
//    {
//        System.out.println("Test1 Hi");
//    }

    @AfterAll
    public static void CleanUp()
    {
        profile.CloseDriver();
    }
}
