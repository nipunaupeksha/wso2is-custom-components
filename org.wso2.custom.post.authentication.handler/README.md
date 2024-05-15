## Custom Post Authentication Handler

## Build the Application

 - Use the following command to make the custom provisioning connector artifact, `org.wso2.custom.post.authentication.handler`.
```bash
mvn clean install -DskipTests
```

## Configure the Application in WSO2 IS

- Copy the artifact and put it into `<IS_HOME>/repository/components/dropins`.
- Run the IS server with OSGi console using the following command.
```bash
./wso2server.sh -DosgiConsole
```
- After starting the WSO2 Management Console, check whether the artifact in `ACTIVE` state by typing,
```bash
ss org.wso2.custom.post.authentication.handler
```

## Test the Application
- When you log into any application, there will be logs shown due to the post-authenticate event.