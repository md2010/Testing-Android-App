import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestAddingNewShiftWithEmptyObligatoryField {
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
    }

    @Test
    public void testAddingNewShiftWithEmptyObligatoryField() throws Exception{
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAddButton();

        AddNewShiftPage addNewShiftPage = new AddNewShiftPage(driver);
        addNewShiftPage.addNewRecord("", "", "8", "", "");
        addNewShiftPage.clickAddButton();

        Assert.assertEquals(addNewShiftPage.getDateEtText(), "Date is obligatory!");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
