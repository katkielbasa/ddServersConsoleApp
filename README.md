# ddServersConsoleApp
Simple console app to manage servers

Prerequisite:
jre 1.8.0 +
maven 3.5 + 
MySQLServer 8.0.1 +
console (CMDR, cmd, bash or which ever depending on system)

running locally:
1) clone this project
2) setup your database (create schema, user and password or use root)
3) modify the file application.properties:
app.datasource.driverClassName=com.mysql.cj.jdbc.Driver
app.datasource.url=jdbc:mysql://localhost:{your_port}/{your_schema}*
app.datasource.username={your_dbusername}
app.datasource.password={your_dbPassword}
*concut this additional datasource params if Your are getting time zone issues while running application "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT"
4) go to top folder location (where your pom file is) and run mvn clean install to build a project. It will run the test too.
5) run either java -jar  target/dimensiondatasimpleapp-0.0.1-SNAPSHOT.jar or mvn spring-boot:run command to start the application
6) type "help" command to see the options
