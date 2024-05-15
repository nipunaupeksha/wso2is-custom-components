package org.wso2.custom.provisioning.connector;

import java.util.Properties;

/**
 * CustomProvisioningConnectorConfig Class
 * This class contains the configurations needed for the custom provisioning connector.
 */
public class CustomProvisioningConnectorConfig {

    private Properties configs;

    public CustomProvisioningConnectorConfig(Properties configs) {
        this.configs = configs;
    }

    public String getValue(String key) {
        return this.configs.getProperty(key);
    }
}