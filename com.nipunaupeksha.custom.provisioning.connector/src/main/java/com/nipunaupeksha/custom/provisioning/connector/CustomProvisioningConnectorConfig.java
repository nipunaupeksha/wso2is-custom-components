package com.nipunaupeksha.custom.provisioning.connector;

import java.util.Properties;

public class CustomProvisioningConnectorConfig {

    private final Properties configs;

    public CustomProvisioningConnectorConfig(Properties configs){
        this.configs = configs;
    }

    public String getValue(String key){
        return this.configs.getProperty(key);
    }
}
