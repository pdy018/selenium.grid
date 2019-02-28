package org.sayem;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppIT {

    private WebDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setPlatform(Platform.LINUX);
        driver = new RemoteWebDriver(new URL("https://selenium.devops.sparkflow.top/wd/hub"), capabilities);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    @Test
    public void simpleTest() {
        driver.navigate().to("http://goodv1.us-west-2.elasticbeanstalk.com/Roo/");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/a")).getText(), "RunRestApp");
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/h1")).getText(), "RestServiceDeploy!");
    }
}
