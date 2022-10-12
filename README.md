# ClipboardHealth
ClipboardHealth Automation Test

This Project is developed on Intellij IDE with JAVA version 11

# Following Project Description:-
    Its a Hybrid Framework having Following techonologies such Cucumber, Gherkins, testng.
    
Now This Code Can Run on the Chrome Browser

# Steps To Run The Code
1. Pull The latest version of the Code From the git.
   1. Update the Code via Internet and Download the Dependencies.
   2. Go To the Directory ClipboardHealth>src>test>Testrunner>Runner.java
   3. Right-Click on the File.
   4. Click on the Run as>MyTestRunner{ if you are using the Intellij} Or {if You 
      the eclipse click on the Junit}.
2. Using Command line: mvn clean test

# Features of this Project
* This project design the BDD Framework

# Framework Description:-
1. src>main>java
   1. driver{package}:- 
      1. Driverfactory:-Its Contains all the information related to the driver. Which Browser need to invoke.
                               Maximise of the browser and application URL.
      2. ConstantVariable:- Describe all the constant variable of the application 
   2. pages{package}:- This package contains all the Page related method and their web elements.
   3. Util{package}:- 
      1. Utilities:-This package contains all the Util Classes which are comman and which can used multiple times. 
      2. ConfigReader:- This File is used to read the config file for passing the browser-name in the code.

      
src>test>resources
   1. config{Folder}: - This Folder contains the property file having the browser name.
   2. Executable_Driver:- This Folder contains all the driver exe which helpful to run the code on the browser.
   3. Feature:- This Folder contains all the feature of the Project Which helps all the members which wants to see the automation process. This File written in the Gherkin Langauage which means the normal English Language such as Given, When, Then, And etc.


URL:- https://reports.cucumber.io/reports/fd1588be-2418-416d-b432-c14d6014fe70