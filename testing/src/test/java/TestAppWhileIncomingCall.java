import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.GsmCallActions;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestAppWhileIncomingCall {

    private AndroidDriver driver;
    private String PHONE_NUMBER = "5551237890";

    @Before
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

    }

    @Test
    public void testPhoneCall() throws InterruptedException {
        // do something in our app
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAddButton();

        // receive and accept a call
        driver.makeGsmCall(PHONE_NUMBER, GsmCallActions.CALL);
        Thread.sleep(2000); // pause just for effect
        driver.makeGsmCall(PHONE_NUMBER, GsmCallActions.ACCEPT);

        // continue to do something in our app
        AddNewShiftPage addNewShiftPage = new AddNewShiftPage(driver);
        addNewShiftPage.addNewRecord("1.2", "28","4.5", "", "");
        addNewShiftPage.clickAddButton();
        Thread.sleep(2000); // pause just for effect

        // end the call
        driver.makeGsmCall(PHONE_NUMBER, GsmCallActions.CANCEL);
        Thread.sleep(2000); // pause just for effect
    }

    @After
    public void teardown() {
        driver.quit();
    }
}