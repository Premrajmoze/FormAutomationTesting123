

Tools & Frameworks


Tool/Framework	  Purpose
Appium	          Android automation
Java	          Programming language
Maven	          Build tool
TestNG	          Test runner
ExtentReports	  HTML test reporting
Apache POI	      Read/write Excel
AShot	          Screenshot utility
Git/GitHub	      Version control


-This project automates mobile app form submissions for the following three modules using 
Appium with Java and Page Object Model (POM)

- Specimen
- Harvesting
- Media Moisture

Approach Used

1.Page Object Model (POM) was implemented to separate test logic from UI locators and actions.
2.Data-Driven Testing using Excel (`Apache POI`) for scalable input data management (50 records/module).
3.Appium with `UiAutomator2` driver was used for native Android automation.
4.TestNG framework manages test execution lifecycle.
5.ExtentReports used for HTML test execution reporting.
6.Screenshots are auto-captured for each test result (pass/fail).
7.A `README` and flow diagram aid in project understanding and execution.



Application Flow Diagram

-plaintext

[Launch App]
     ↓
[Login / Home Page]
     ↓
[Select Module]
     ↓
| Specimen |
     ↓
[Fill Form Fields]      
     ↓ 
[Click Submit]
     ↓   
[Back Home Page]
     ↓     
| Click Dome |
     ↓     
| Select Harvesting Module |
     ↓
[Fill Form Fields]
     ↓ 
[Click Submit]
     ↓     
[Back Home Page] 
     ↓            
| Select Media Moisture Module |
     ↓
[Fill Form Fields]
     ↓
[Click Submit]
     ↓
[Back Home Page]
     ↓     
[Capture Screenshot]
     ↓
[Log Result in Report]



Form_Automation_Testing_Project
│
├── /src/
│   ├── /pages/                  # Page Object classes
│   │   ├── SpecimenPage.java
│   │   ├── HarvestingPage.java
│   │   └── MediaMoisturePage.java

        /Base/
        |-- BasePage
        
        /Driver/
        |--DriverManager
│    
│   ├── /testcases/             # Test classes
│   │   ├── SpecimenTest.java
│   │   ├── HarvestingTest.java
│   │   └── MediaMoistureTest.java
│   │
│   ├── /utils/                 # Utility classes
│   │   ├── ExcelReader.java
│   │   ├── ScreenshotUtil.java
│       |-- ExtentReportManager
├── /data/
│   └── TestData.xlsx           # Contains 50 records per module
│
├── /screenshots/               # Saved screenshots (pass/fail)
│   └── Specimen/
│   └── Harvesting/
│   └── MediaMoisture/
│
├── /reports/
│   └── TestExecutionReport.html
│
├── pom.xml                    # Maven dependencies
├── testng.xml                 # TestNG suite config
└── README.md                  # This file

