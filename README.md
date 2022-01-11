# Testing Android App

## 1. Introduction 
In order to carry out automation testing for Android application, I developed an app "Student Workhours Calculator".
It's used for tracking workhours and calculating sum of money that is earned in a month. 

## 2. How app works?
There's two screens (Activities), main which holds table with data and second for adding shift.  

**Adding new shift**

User needs to click on button Add and another Activity opens with 5 fields.
First option is that user enters field per hour and working hours and then application calculates earned money by multiplying values of those fields. 
Second option is that user enters sum and then app won't calculate earned money for that shift but use the entered value. 
Fields date and working hours are obilagtory in both cases. 

**Deleting shift**

After user added shifts, they're shown on main screen in a table. Long press click on row deletes that row and record
itself from the database.

**Calculating montly income**

On the main screen, there is field in right up corner where user needs to enter the number of month (i.e. 1, 3, 11) for which he/she wants to caluclate income. Then user needs to press button Calculate. New row will be added, which will contain the number of month which was entered, 
total of worked hours for that month and summed up income for that month. 

## Software Requirments 
● Android SDK (Android Studio) 

● JDK (Java Development Kit) [install instructions](https://codenotfound.com/java-download-install-jdk-8-windows.html)

● IDE - IntelliJ

● Test Framework - TestNG

● Selenium-Java 

● Node.js 

● Appium 1.18.3 [zip file](Appium-windows-1.18.3.zip)

● APK App (available in this repository)

● Add enviorment variables: 

**User variable**

ANDROID_HOME = C:\Users\ *user_name* \AppData\Local\Android\Sdk

**System variable** (PATH):

C:\Users\ <*user_name*> \AppData\Local\Android\Sdk\tools

C:\Users\ <*user_name*> \AppData\Local\Android\Sdk\emulator

## 3. Available Tests 
There are 6 JUnit tests written using POM (*Page Object Model*).

a) **TestCalculatingMonthlyIncome** - checking if sum is correct	

b) **TestDeletingRecord** - checking if record is deleted after long press on it	

c) **TestAddingNewShiftWithEmptyObligatoryField** - checking if message would show that field is obligatory

d) **TestCalculatingShiftSum**- adding wnew shift without sum, so calculatingsum for shift can be tested

e) **TestAddingNewShift** - testing funcionality of adding a record to table (checking only for sum column value in table row)	

f) **TestAppWhileIncomingCall** - testing how app works if someone calls the user and how it works while in a call	

g) **TestCalculateMonthlyIncomeWithoutData** - checking if message is shown (no data for chosen month)

## 4. Steps to run test
**1.Clone this repository.**

**2. Install emulator.**

If you don't have emulator **Nexus 5X API 28**, install it following [instrunctions](https://developer.android.com/studio/run/managing-avds).

**3. Start CMD and type:**
>cd C:\Users\ <*user_name*> \AppData\Local\Android\Sdk\emulator

>emulator -avd -list-avds 

Nexus_5X_API_28 should be in list of emulators.

Then start emulator with this command:
>emulator -avd Nexus_5X_API_28
 
**4.Open new CMD and type:**
>cd C:\Users\ <*user_name*> \AppData\Local\Android\Sdk\platform-tools

>adb devices

Result should be:

*List of devices attached*

*emulator-5554 device*

Install the app on emulator with command:
>adb -s emulator-5554 install C:\ <*path_to_app*>\ <*appName*>.apk

Then type:
>adb start-server

**5. Start Appium**

Click on *Start Server* and then go to *File->New Session Window*

In *JSON Representation* write following:

    {

       "app": "C:\\ <path_to_app> \\ <appName>.apk",

       "VERSION": "9.0",

       "deviceName": "emulator",

       "platformName": "Android"
 
    }
and click on *Start Session*.

Now we can inspect elements, for more about inspector [click here](https://blog.knoldus.com/finding-elements-using-appium-inspector/).

**6. Open IntelliJ**

Open folder *testing* (which is cloned) in IntelliJ.

**7. Change path to APK**

In test classes, path to APK needs to be changed, more precisely, in *setup()* method.

**8. Run test**

If you want to run a single test, just right click on any test class (that can be found in *src->main->test->java*) and *Run*.

If you want to get a report on whole test suite, then write in *Terminal*:
>mvn test 

and run command with *Ctrl+Enter*. 

In folder *target->surfire-reports* you can find generated test report.

## 5. Adding new test
If you would like to add new test, right click on *java* folder *New->Java Class* and type the name of test. Code including steps of test can be generated in *Appium* by recording those steps.

Also, you need to add test method name and the name of the test class in *testNG.xml* like this:

    <test name=<"test_method_name">>
          <classes>
              <class name=<"test_class_name">/>
          </classes>
      </test>

