<img width="1791" alt="Screenshot 2024-10-13 at 12 47 16 AM" src="https://github.com/user-attachments/assets/475e95e3-5a45-483f-a069-7c7a52381798">




# Almosafer-APIs_Automatio-Testing
A Java-based automation testing project using Rest Assured framework to validate GET and POST APIs for the Almosafer platform. The project focuses on dynamic data handling, response validation with reporting
#### Project website link: https://Almosafer.com/en <br>

------------------------------------------------

## Technology <br>
Tool: Rest Assured for API testing. <br>
Build tool: Maven for dependency management and project build. <br>
Language: Java for writing test scripts. <br>
Framework: TestNG for structuring tests and managing execution. <br>
Report: EmailableReporter2 and FailedReporter for generating reports on test execution results.<br>
Project Structure: Standard Maven Project Structure. <br>
selenium-java (4.25.0)<br>
java-client (9.3.0) <br>
netty-handler (4.1.90.Final) <br>
TestNG (7.10.2) <br>
rest-assured (5.5.0) <br>
jackson-core (2.18.0) <br>
json-path(2.18.0) <br>
IDE: IntelliJ IDEA for development and testing.<br>

--------------------------------------------------
## Project Architecture: <br>
<img width="441" alt="image" src="https://github.com/user-attachments/assets/9c7b0e94-684f-440a-829d-6b6b35f53619">


--------------------------------------------------

### To Run the project with a Different Test Runner:<br>


--------------------------------------------------

Number Of Modules: 3 <br>
Total test case: 5 <br>

### Test Report Location: <br>
> project root -> test-output-> emailable-report.html<br>

### Sample TestNG Run Screenshot <br>
<img width="358" alt="image" src="https://github.com/user-attachments/assets/3f1473f1-ddf6-43ab-9192-d343575f7e8c"> <br>
### Sample Report Screenshot <br>
<img width="1791" alt="Screenshot 2024-10-13 at 12 47 16 AM" src="https://github.com/user-attachments/assets/ac2c9095-124e-4d8c-b075-b5d6afe1fab8">


----------------------------------------------------------

## Project Related Info:<br>
This project is basically a demo test API automation project for almosafer website where I have to navigate to https://www.almosafer.com/en and automate any GET & POST API from flights/hotels/Activities module(In total 2 APIs i.e. GET & POST). .<br>

I have done TestNG integration in this project. to show the report and for the general conditions, such as that the dates should be returned dynamically and add the token to some of the request headers based on the selected module
