# WSO2 IS Custom Components

This repository contains the following custom components.

- `com.nipunaupeksha.custom.provisioning.connector` → A custom provisioning connector to be used with `com.nipunaupeksha.custom.user.manager` application.
- `com.nipunaupeksha.custom.user.manager` → An Spring application for the demo purposes of `com.nipunaupeksha.custom.provisioning.connector`
- `org.wso2.custom.federated.authenticator` → A custom federated authenticator which uses OAuth2/OIDC as the authentication protocol.
- `org.wso2.custom.local.authenticator` → `A custom local authenticator`
- `org.wso2.custom.post.authentication.handler` → `An post-authentication event handler`
- `org.wso2.custom.provisioning.connector` → Simple custom provisioning connector which gives you logs whenever you create/delete/update a user.
- `org.wso2.custom.event.listener` → Simple user store event listener created to listen to the user store events.
- `org.wso2.custom.event.handler` → Simple user store event handler created to provide logs when the `POST_AUTHENTICATION` event hits.
- `org.wso2.custom.userstore.manager` → Sample user store manager for SQL databases.
- `org.wso2.custom.grant.type` → Contains a custom grant type. In this case, this is for mobile grant.
