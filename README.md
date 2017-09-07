Zack Hyder's Interview Project for Zmags


Spring Boot framework
Swagger UI library

1.) Import the project as a new Maven project.

2.) Run mvn clean install

3.) To run, navigate to and run Application.java (src/main/java/com/zmags/interview/Application.java)

4.) Once the program has started, visit http://localhost:8080/swagger-ui.html in your web browser

5.) Click "demo-controller" to access the endpoints

<br/>
<br/>
ENDPOINTS

<br/>
GET /api/triangle

Takes in 3 Doubles.

Returns the type of triangle calculated by the 3 sides the user enters.


<br/>
POST /api/textAnalysis

Takes in a text file (.txt)

Returns the number of times each word occurs in the passed in text file.

<br/>
<br/>
TESTS

In the test folder, you will see a test class for both the File Analysis and Triangle service calls

To run these tests, simply run the test class.




