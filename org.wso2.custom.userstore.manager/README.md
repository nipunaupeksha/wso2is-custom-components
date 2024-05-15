## Custom Event Handler

### Build the Application
- First, run the following command to build the `org.wso2.custom.userstore.manager`.
```bash
mvn clean install -DskipTests
```
- You will find the artifact `org.wso2.custom.userstore.manager-1.0-SNAPSHOT.jar` in the `/target` directory of the code base.

### Configure WSO2 IS
- After building the project, paste the artifact in `<IS_HOME>/repository/components/dropins` directory.
- Open `<IS_HOME>/repository/conf/deployment.toml` file and add the following configurations.
```toml
[user_store_mgt]
custom_user_stores=["org.wso2.custom.userstore.manager.CustomUserStoreManager"]
```
- Next, start the WSO2 IS, with the following command to open it in OSGi mode.
```bash
./wso2server.sh -DosgiConsole
```
- After starting, you can check whether the custom federated authenticator is in `ACTIVE` state or not.
```bash
ss org.wso2.custom.userstore.manager
```

## Test the Custom Event Handler
- Now if you open the WSO2 Mangement Console in `<IS_HOST>:<IS_PORT>/carbon` and go to, `Userstores` → `Add`, then you will see the custom userstore you have created is under th list of userstore manager classes available.