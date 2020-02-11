package LinkedIn;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LinkedIn_Page
{
    private RemoteWebDriver driver;
    private String url = "http://localhost:3000";

    public LinkedIn_Page(RemoteWebDriver driver)
    {
        this.driver = driver;
        driver.navigate().to(url);
    }

    public void stall()
    {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void Search(String query)
    {
        driver.findElement(By.name("q")).sendKeys(query);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    public void LinkedInLink()
    {
        stall();
        driver.findElement(By.xpath("//h3[contains(text(),'LinkedIn')]")).click();
    }

    public void Shauns()
    {
        stall();
        List<WebElement> elements = driver.findElements(By.xpath("//h3[contains(text(), 'Shaun Koon')]"));
        elements.get(0).click();
    }

    public List<WebElement> TopCardItems()
    {
        List<WebElement> elements = driver.findElements(By.className("top-card-link__description"));
        return elements;
    }

    public String navBar()
    {
        return driver.findElement(By.xpath("//span[@class='navbar-brand']")).getText();
    }

    public void CloseDriver()
    {
        driver.quit();
    }
}
