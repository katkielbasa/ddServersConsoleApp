# ddServersConsoleApp
### Simple console app to manage servers

###### Prerequisite:
- jre 1.8.0 +
- maven 3.5 + 
- MySQLServer 8.0.1 +
- console (CMDR, cmd, bash or which ever depending on system)

###### running locally:
1. clone this project.
2. setup your database (create schema, user and password or use root).
3. modify the file application.properties (or set up the database as per file):
```
 app.datasource.driverClassName=com.mysql.cj.jdbc.Driver
 app.datasource.url=jdbc:mysql://localhost:{your_port}/{your_schema}*
 app.datasource.username={your_dbusername}
 app.datasource.password={your_dbPassword}
```
  * *if Your are getting time zone issues while running application, concut this additional datasource params or modify them according to your issues:*
  ```
app.datasource.url=jdbc:mysql://localhost:3306/new_schema2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT
  ```
4. go to top folder location (where your pom file is) and run:
```
mvn clean install
```
to build a project. It will run the test too.

5. run either
```
java -jar  target/dimensiondatasimpleapp-0.0.1-SNAPSHOT.jar "HELP" 
```
or 
```
mvn spring-boot:run -mvn spring-boot:run -Dspring-boot.run.arguments="HELP"
```
command to start the application with "HELP COMMAND".

6. Try different command (replace "HELP" with commnand name, plus eventually add additional arguments as strings.
###### Tests:
test results can be found in target/surefire-report folder 

###### ToDo:
- improve handling exceptions
- add tests for negative cases (not only happy path)
- improve logging
- change the requirement for the id (to be autoimcremented)?
