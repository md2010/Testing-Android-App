import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;

import java.util.concurrent.TimeUnit;

public class TestDeletingRecord {
    AndroidDriver driver;

    @BeforeClass()
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(
                "app",
                "C:\\Users\\Martina\\AndroidStudioProjects\\StudentWorkhoursCalculator\\app\\build\\outputs\\apk\\debug\\app-debug.apk"
        );
        capabilities.setCapability("VERSION", "9.0");
        capabilities.setCapability("deviceName", "emulator");
        capabilities.setCapability("platformName", "Android");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        addData();
    }

    private void addData()
    {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAddButton();

        AddNewShiftPage addNewShiftPage = new AddNewShiftPage(driver);
        addNewShiftPage.addNewRecord("15.12", "", "8", "", "240");
        addNewShiftPage.clickAddButton();
    }

    @Test
    public void testDeletingRecord() throws Exception {

        MainPage mainPage = new MainPage(driver);
        mainPage.longPressRow();
        Thread.sleep(5000);

        if(mainPage.getTableSize() > 1) // 1 for the first row (header)
        {
            Assert.assertTrue(false);
        }
        else
        {
            Assert.assertTrue(true);
        }
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}