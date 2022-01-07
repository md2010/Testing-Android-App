import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class MainPage
{
    private AndroidDriver<AndroidElement> driver;

    public MainPage() {}

    public MainPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.example.studentworkhourscalculator:id/calculate_btn_id")
    private AndroidElement calculateBtn;

    @AndroidFindBy(id = "com.example.studentworkhourscalculator:id/add_btn")
    private AndroidElement addBtn;

    @AndroidFindBy(id = "com.example.studentworkhourscalculator:id/et_month")
    private AndroidElement monthEt;

    @AndroidFindBy(id = "com.example.studentworkhourscalculator:id/tableLayout1")
    private MobileElement table;

    //since rows are added dinamiclly in table, rows can't be found by id so xpath is used
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget." +
            "ScrollView/android.widget.TableLayout/android.widget.TableRow[2]")
    private WebElement row;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
            "android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget." +
            "ScrollView/android.widget.TableLayout/android.widget.TableRow[2]/android.widget.TextView[4]") //second row, first is header
    private AndroidElement sumField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget." +
            "LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/" +
            "android.widget.ScrollView/android.widget.TableLayout/android.widget.TableRow[4]/android.widget.TextView[4]") //fourth row will hold the data with monthly income
    private AndroidElement monthlySumField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget." +
            "FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.TableLayout/android.widget.TableRow[2]/android.widget.TextView[1]")
    private AndroidElement dateField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget." +
            "FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.TableLayout/android.widget.TableRow[2]/android.widget.TextView[2]")
    private AndroidElement shiftField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget." +
            "FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.TableLayout/android.widget.TableRow[2]/android.widget.TextView[3]")
    private AndroidElement perHourField;

    public void typeMonth(String month) {
        monthEt.sendKeys(month);
    }

    public String getMonthEtText() {
        return monthEt.getText();
    }

    public void clickCalculateButton() {
        calculateBtn.click();
    }

    public void clickAddButton() {
        addBtn.click();
    }

    public int getTableSize() {
        return driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                "android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget." +
                "TableLayout")).size();
    }

    public void longPressRow() {
        TouchAction action = new TouchAction(driver).
                longPress(longPressOptions().withElement(element(row)).
                withDuration(Duration.ofMillis(10000))).
                release().
                perform();
    }

    public String getSumFieldValue(){
        return sumField.getText();
    }

    public String getMonthlySumValue() {
        return monthlySumField.getText();
    }
}
