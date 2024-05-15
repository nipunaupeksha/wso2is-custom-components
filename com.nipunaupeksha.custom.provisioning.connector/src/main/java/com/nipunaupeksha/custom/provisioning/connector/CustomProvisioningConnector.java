package com.nipunaupeksha.custom.provisioning.connector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.wso2.carbon.identity.application.common.model.Property;
import org.wso2.carbon.identity.provisioning.*;

import java.io.IOException;
import java.util.Properties;

import static com.nipunaupeksha.custom.provisioning.connector.CustomConnectorConstants.ENDPOINT;

public class CustomProvisioningConnector extends AbstractOutboundProvisioningConnector {

    private static final Log log = LogFactory.getLog(CustomProvisioningConnector.class);
    private CustomProvisioningConnectorConfig configHolder;

    @Override
    public void init(Property[] provisioningProperties) throws IdentityProvisioningException {
        Properties configs = new Properties();
        if (provisioningProperties != null) {
            for (Property property : provisioningProperties) {
                configs.put(property.getName(), property.getValue());
                if (IdentityProvisioningConstants.JIT_PROVISIONING_ENABLED.equals(property.getName())) {
                    if(CustomConnectorConstants.PROPERTY_VALUE_TRUE.equals(property.getValue())){
                        jitProvisioningEnabled = true;
                    }
                }
            }
        }
        configHolder = new CustomProvisioningConnectorConfig(configs);
    }

    @Override
    public ProvisionedIdentifier provision(ProvisioningEntity provisioningEntity) throws IdentityProvisioningException {
        String provisionedId = null;
        if(provisioningEntity!=null){
            if (provisioningEntity.isJitProvisioning() && !isJitProvisioningEnabled()) {
                log.debug("JIT provisioning disabled for Office365 connector");
                return null;
            }

            if (ProvisioningEntityType.USER == provisioningEntity.getEntityType()) {
                if (ProvisioningOperation.DELETE == provisioningEntity.getOperation()) {
                    deleteUser(provisioningEntity);
                } else if (ProvisioningOperation.POST == provisioningEntity.getOperation()) {
                    provisionedId = createUser(provisioningEntity);
                } else if (ProvisioningOperation.PUT == provisioningEntity.getOperation()) {
                    updateUser(provisioningEntity);
                } else {
                    log.warn("Unsupported provisioning operation " + provisioningEntity.getOperation() +
                            " for entity type " + provisioningEntity.getEntityType());
                }
            } else {
                log.warn("Unsupported provisioning entity type " + provisioningEntity.getEntityType());
            }
        }
        // Creates a provisioned identifier for the provisioned user.
        ProvisionedIdentifier identifier = new ProvisionedIdentifier();
        identifier.setIdentifier(provisionedId);
        return identifier;
    }

    private String createUser(ProvisioningEntity provisioningEntity) {

        // Implement user creation logic.
        String provisionedId = null;
        // get username from here
        String entityName = provisioningEntity.getEntityName();
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost(ENDPOINT + "?username=" + entityName);
            HttpResponse httpresponse = httpclient.execute(httppost);
        }catch (ClientProtocolException e){
            log.error("HTTP POST failed.",e);
        }catch(IOException e){
            log.error("IO exception",e);
        }
        log.info("Creating the copy of the user in the external system:" + entityName);
        return provisionedId;
    }

    private void deleteUser(ProvisioningEntity provisioningEntity) {

        // Implement user deletion logic.
        log.info("Delete the user account from the external system.");
    }

    private void updateUser(ProvisioningEntity provisioningEntity) {

        // Implement user update logic.
        log.info("Update user account in the external system.");
    }
}
