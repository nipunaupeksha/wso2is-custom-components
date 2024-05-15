# Custom Provisioning Connector

### Build the Application
 - Use the following command to make the custom provisioning connector artifact, `org.wso2.custom.provisioning.connector`.
```bash
mvn clean install -DskipTests
```

### Configure the Application in WSO2 IS
- Copy the artifact and put it into `<IS_HOME>/repository/components/dropins` directory.
- Run the IS server with OSGi console using the following command.
```bash
./wso2server.sh -DosgiConsole
```
- After starting the WSO2 Management Console, check whether the artifact in `ACTIVE` state by typing,
```bash
ss org.wso2.custom.provisioning.connector
```
- Then go to WSO2 IS Management Console by `<IS_HOST>:<IS_PORT>/carbon` and then go to `Identity Providers` → `Add`.
- Give a name to the Identity Provider (e.g. `Auth`).
- Then go the `Outbound Provisioning Connectors` in there.
- Go to the `Custom Provisioning Configuration`.
- Make the following settings there.
    - `Enable` → Check the checkbox.
    - `Endpoint` → `http://localhost:8080/api/v1/users`
- Click on `Update` to save the configurations.

### Test the Custom Provisioning Connector
- Create a new user in WSO2 IS.
- Configure the `com.nipunaupeksha.custom.provisioning.user.manager`.
- Test the flow as mentioned in the `com.nipunaupeksha.custom.provisioning.user.manager` README.md file.