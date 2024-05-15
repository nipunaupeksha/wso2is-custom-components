## Custom Grant 
This contains the mobile grant created for WSO2 IS.

### Build the Application
- First, run the following command to build the `org.wso2.custom.grant.type`.
```bash
mvn clean install -DskipTests
```
- You will find the artifact `org.wso2.custom.grant.type-1.0-SNAPSHOT.jar` in the `/target` directory of the code base.

### Configure WSO2 IS
- Copy the artifact to `<IS_HOME>/repository/components/lib` directory.
- Go to `<IS_HOME>/repository/conf` directory and add the following configurations to the `deployment.toml` file.
```bash
[[oauth.custom_grant_type]]
name="mobile_grant"
grant_handler="org.wso2.custom.grant.type.mobile.MobileGrant"
grant_validator="org.wso2.custom.grant.type.mobile.MobileGrantValidator"

[oauth.custom_grant_type.properties]
IdTokenAllowed=true
```
- Run the IS server with OSGi console using the following command.
```bash
./wso2server.sh -DosgiConsole
```
- After starting the WSO2 Management Console, check whether the artifact in `ACTIVE` state by typing,
```bash
ss org.wso2.custom.grant.type
```

### Test the Custom Grant Type
- Create an SP using the following DCR script.
```bash
curl -k -X POST -H "Authorization: Basic YWRtaW46YWRtaW4=" -H "Content-Type: application/json" -d '{  "client_name": "playground_2", "grant_types": ["password","mobile_grant"], "redirect_uris":["http://localhost:8080/playground2"], "ext_param_client_id":"provided_client_id0001","ext_param_client_secret":"provided_client_secret0001" }' "https://localhost:9443/api/identity/oauth2/dcr/v1.1/register"
```
- Run the following cURL command to execute the mobile grant type. Note that the name you have used in `deployment.toml` for `oauth.custom_grant_type.name` should be the `grant_type` of your cURL command.
```bash
curl --user provided_client_id0001:provided_client_secret0001 -k -d "grant_type=mobile&mobileNumber=0333444" -H "Content-Type: application/x-www-form-urlencoded" https://localhost:9443/oauth2/token
```
-  With this you can get an `access_token` and a `refresh_token`.