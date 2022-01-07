1. Introduction

In order to carry out automation testing for Android application, I developed an app "Student Workhours Calculator".
It's used for tracking workhours and calculating sum of money that is earned in a month. 

2. How app works

There's two screens (Activities), main which holds table with data and second for adding shift.  

**Adding new shift
User needs to click on button Add and another Activity opens with 5 fields.
First option is that user enters field per hour and working hours and then application calculates earned money by multiplying values of those fields. 
Second option is that user enters sum and then app won't calculate earned money for that shift but use the entered value. 
Fields date and working hours are obilagtory in both cases. 

**Deleting shift
After user added shifts, they're shown on main screen in a table. Long press click on row deletes that row and record
itself from the database.

**Calculating montly income
On the main screen, there is field in right up corner where user needs to enter the number of month (i.e. 1, 3, 11) for which he/she wants to caluclate income. Then user needs to press button Calculate. New row will be added, which will contain the number of month which was entered, 
total of worked hours for that month and summed up income for that month. 

3. Tests

There are 6 JUnit tests.
a)TestCalculatingMonthlyIncome - checking if sum is correct	
b)TestDeletingRecord - checking if record is deleted after long press on it	
c)TestAddingNewShiftWithEmptyObligatoryField - checking if message would show that field is obligatory		
d)TestCalculatingShiftSum- adding wnew shift without sum, so calculatingsum for shift can be tested
e)TestAddingNewShift - testing funcionality of adding a record to table (checking only for sum column value in table row)		
f)TestAppWhileIncomingCall - testing how app works if someone calls the user and how it works while in a call		
g)TestCalculateMonthlyIncomeWithoutData - checking if message shows that there's no data for chosen month






