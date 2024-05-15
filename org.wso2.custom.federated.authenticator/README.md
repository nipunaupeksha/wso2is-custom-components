## Custom Federated Authenticator

### Build the Application
- First, run the following command to build the `org.wso2.custom.federated.authenticator`.
```bash
mvn clean install -DskipTests
```
- You will find the artifact `org.wso2.custom.federated.authenticator-1.0-SNAPSHOT.jar` in the `/target` directory of the code base.

### Configure WSO2 IS
- After building the project, paste the artifact in `<IS_HOME>/repository/components/dropins` directory.
- Next, start the WSO2 IS, with the following command to open it in OSGi mode.
```bash
./wso2server.sh -DosgiConsole
```
- After starting, you can check whether the custom federated authenticator is in `ACTIVE` state or not.
```bash
ss org.wso2.custom.federated.authenticator 
```

### Test the Custom Federated Authenticator
- To test the custom federated authenticator we need an external IdP.
- We can configure another IS instance as an external IdP.
- From this point onwards, we will use IS-1 for the IS which has the `org.wso2.custom.federated.authenticator` and use IS-2 for the other IS instance.
- Go to `<IS2_HOME>/repository/conf` and open the `deployment.toml` file.
- Then add the following configuration there.
```toml
[server]
offset = 1
```
- Start IS-2 with the following command.
```bash
./wso2carbon.sh -DosgiConsole
```
- Create a new service provider named WSO2 in IS-2 using OAuth2/OIDC inbound authentication protocol. 
- You can use the following DCR script for that.
```bash
curl -k -X POST -H "Authorization: Basic YWRtaW46YWRtaW4=" -H "Content-Type: application/json" -d '{"client_name": "WSO2","grant_types": ["authorization_code","password"], "redirect_uris": ["http://localhost:8080/playground2/oauth2client"],"ext_param_client_id":"provided_client_id0001","ext_param_client_secret":"provided_client_secret0001" }' "https://localhost:9444/api/identity/oauth2/dcr/v1.1/register"
```
- The credentials of this client application are as follows.
  - `Name` → `WSO2`
  - `Client ID` → `provided_client_id0001`
  - `Client Secret` → `provided_client_secret0001`
- Then go to IS-1's Management Console and go to`Identity Providers` → `Add` to add a new Identity Provider.
- Give the IdP a name and go to the `Federated Authenticators` where you will see, `Custom-Federated-Authenticator Configuration`.
- Configure it as follows.
  - `Enable` → Check the checkbox
  - `Client Id` → `provided_client_id0001`
  - `Client Secret` → `provided_client_secret0001`
  - `Authorization Endpoint` → `https://localhost:9444/oauth2/authorize`
  - `Token Endpoint` → `https://localhost:9444/oauth2/token`
- Next, create a new SP in IS-1. You can use the following DCR script to create a new SP.
```bash
curl -k -X POST -H "Authorization: Basic YWRtaW46YWRtaW4=" -H "Content-Type: application/json" -d '{"client_name": "playground_2","grant_types": ["authorization_code","password"], "redirect_uris": ["http://localhost:8080/playground2/oauth2client"],"ext_param_client_id":"provided_client_id0002","ext_param_client_secret":"provided_client_secret0002" }' "https://localhost:9443/api/identity/oauth2/dcr/v1.1/register"
```
- Go to the `Local & Outbound Authentication Configuration` of the created SP.
- Select `Federated Authentication` and the IdP you have created.
- Create a new user in IS-2.
- After that, copy and paste the following URL in the browser.
```bash
https://localhost:9443/oauth2/authorize?response_type=code&client_id=provided_client_id0002&redirect_uri=http://localhost:8080/playground2/oauth2client&scope=openid 
```
- Then you will be redirected to enter the user credentials, you can use the user credentials of the user you created in IS-2 for this and log in.