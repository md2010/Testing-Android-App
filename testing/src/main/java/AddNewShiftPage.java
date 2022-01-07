import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddNewShiftPage {

    private AndroidDriver<AndroidElement> driver;

    public AddNewShiftPage() {
    }

    public AddNewShiftPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.example.studentworkhourscalculator:id/date_et_id")
    private AndroidElement dateEt;

    @AndroidFindBy(id = "com.example.studentworkhourscalculator:id/perHour_et_id")
    private AndroidElement perHourEt;

    @AndroidFindBy(id = "com.example.studentworkhourscalculator:id/workinghours_et_id")
    private AndroidElement workingHoursEt;

    @AndroidFindBy(id = "com.example.studentworkhourscalculator:id/shift_et_id")
    private AndroidElement shiftEt;

    @AndroidFindBy(id = "com.example.studentworkhourscalculator:id/money_et_id")
    private AndroidElement moneyEt;

    @AndroidFindBy(id = "com.example.studentworkhourscalculator:id/add_btn")
    private AndroidElement addBtn;

    public void typeDate(String date){
        dateEt.sendKeys(date);
    }

    public String getDateEtText(){
        return dateEt.getText();
    }

    public void typePerHour(String perHour){
        perHourEt.sendKeys(perHour);
    }

    public void typeWorkingHours(String workingHours){
        workingHoursEt.sendKeys(workingHours);
    }

    public  void typeShift(String shift){
        shiftEt.sendKeys(shift);
    }

    public void typeMoney(String money){
        moneyEt.sendKeys(money);
    }

    public void clickAddButton() {
        addBtn.click();
    }

    public void addNewRecord(String date, String perHour, String workingHours, String shift, String money){
        typeDate(date);
        typePerHour(perHour);
        typeWorkingHours(workingHours);
        typeShift(shift);
        typeMoney(money);
    }
}

