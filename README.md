

#TODO List Spring Boot Application#

This is a TODO list application built with Spring Boot. It supports adding, removing, and displaying tasks, which are stored in an H2 database.


#Ensure you the following requirements:#

- You have installed Java 11 or later.
- You have installed Gradle.

 #Clone the Repository#

git clone https://github.com/your-username/DZ4.git

#To build and run the application, use the command:#

./gradlew bootRun


The application will start on http://localhost:8080.

 #API Endpoints#

 Add a Task

- URL: http://localhost:8080/tasks
- Method: POST
- Headers: Content-Type: application/json
- Body:
  json
  {
    "description": "New Task"
  }
  

- Example:

  
  curl -X POST http://localhost:8080/tasks -H "Content-Type: application/json" -d '{"description": "New Task"}'
  

 Get All Tasks

- URL: http://localhost:8080/tasks
- Method: GET

- Example:

  
  curl http://localhost:8080/tasks
  

 Remove a Task

- URL: http://localhost:8080/tasks/{id}
- Method: DELETE

- Example:

  
  curl -X DELETE http://localhost:8080/tasks/1
  


#To run the tests, use the following command:#


./gradlew test


#Test reports are generated in the build/reports/tests/test/index.html file. Open this file in a web browser to see detailed test results#

# Project Structure#
<img width="428" alt="Screenshot 2024-05-22 at 2 22 46 AM" src="https://github.com/Kxrma47/DZ4/assets/114881854/2ca28cb0-bebf-49a0-aebc-301140908fe9">
