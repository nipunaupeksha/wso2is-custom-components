## Custom User Store Manager

This is the Spring Application you can use with `com.nipunaupeksha.custom.provisioning.connector`.

### Run the Spring Application
#### Build the Spring Application
- To build the Spring application, you can execute the following Maven command.
```bash
mvn clean install -DskipTests
```

#### Run the Spring Application
- Then run the Spring Application using the following command.
```bash
mvn spring-boot:run 
```
- You don't necessarily have to bulid the application before running, but its better to understand whether there are errors when you build the application.
- If you are positive that there are no errors, then you can simply run the second Maven command.
```bash
mvn spring-boot:run
```

### Configuring WSO2 Management Console
- Follow the instructions given in `com.nipunaupeksha.custom.provisioning.connector` to test the application.

### Test the Application
- After configuring the application with the instructions given at,`com.nipunaupeksha.custom.provisiong.connector` you can create a new user in WSO2 IS.
- Then that user should be created in this application as well.
- To check that, go to `http://localhost:8080/h2-console` and execute the following H2-SQL command.
```sql
select * from users;
```

### Change Configurations
- The default username, password and the db-name of this application can be found at `application.properties` file of the application.
- You can change them to whatever the values you need.
- But make sure to restart the application after changing the configurations.