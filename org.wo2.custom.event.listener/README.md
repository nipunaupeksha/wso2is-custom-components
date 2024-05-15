## Custom Event Listener

### Build the Application
- First, run the following command to build the `org.wso2.custom.event.listener`.
```bash
mvn clean install -DskipTests
```
- You will find the artifact `org.wso2.custom.event.listener-1.0-SNAPSHOT.jar` in the `/target` directory of the code base.

### Configure WSO2 IS
- After building the project, paste the artifact in `<IS_HOME>/repository/components/dropins` directory.
- Open `<IS_HOME>/repository/conf/deployment.toml` file and add the following configurations.
```toml
[[event_listener]]
id = "custom-event-listener"
type = "org.wso2.carbon.user.core.listener.UserOperationEventListener"
name = "org.wso2.custom.event.listener.CustomEventListener"
order = 9000
enable = true
```
- Next, start the WSO2 IS, with the following command to open it in OSGi mode.
```bash
./wso2server.sh -DosgiConsole
```
- After starting, you can check whether the custom federated authenticator is in `ACTIVE` state or not.
```bash
ss org.wso2.custom.event.listener 
```

## Test the Custom Event Listener
- This is created by using the UserOperationEventListener. 
- Therefore, whenever a user operation event is done, you will be able to see it.