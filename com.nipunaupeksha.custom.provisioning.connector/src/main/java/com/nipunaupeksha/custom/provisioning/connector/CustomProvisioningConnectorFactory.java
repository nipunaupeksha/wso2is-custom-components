package com.nipunaupeksha.custom.provisioning.connector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.application.common.model.Property;
import org.wso2.carbon.identity.provisioning.AbstractOutboundProvisioningConnector;
import org.wso2.carbon.identity.provisioning.AbstractProvisioningConnectorFactory;
import org.wso2.carbon.identity.provisioning.IdentityProvisioningException;

import java.util.ArrayList;
import java.util.List;


public class CustomProvisioningConnectorFactory extends AbstractProvisioningConnectorFactory {

    private static final Log log = LogFactory.getLog(CustomProvisioningConnectorFactory.class);
    private static final String CONNECTOR_TYPE = "Custom";

    @Override
    protected AbstractOutboundProvisioningConnector buildConnector(Property[] provisioningProperties) throws
            IdentityProvisioningException {

        CustomProvisioningConnector connector = new CustomProvisioningConnector();
        connector.init(provisioningProperties);
        if (log.isDebugEnabled()) {
            log.debug("Custom provisioning connector created successfully.");
        }
        return connector;
    }

    @Override
    public String getConnectorType() {
        return CONNECTOR_TYPE;
    }

    @Override
    public List<Property> getConfigurationProperties() {

        Property clientId = new Property();
        clientId.setName(CustomConnectorConstants.ENDPOINT);
        clientId.setDisplayName("Endpoint");
        clientId.setDisplayOrder(1);
        clientId.setRequired(true);

        List<Property> properties = new ArrayList<>();
        properties.add(clientId);
        return properties;
    }
}
