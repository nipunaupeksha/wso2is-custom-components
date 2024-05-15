package com.nipunaupeksha.custom.provisioning.connector.internal;

import com.nipunaupeksha.custom.provisioning.connector.CustomProvisioningConnectorFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.wso2.carbon.identity.provisioning.AbstractProvisioningConnectorFactory;

/**
 * Registers the connector as an osgi component.
 */
@Component(
        name = "com.nipunaupeksha.custom.provisioning.connector",
        immediate = true
)
public class CustomProvisioningConnectorServiceComponent {

    private static final Log log = LogFactory.getLog(CustomProvisioningConnectorServiceComponent.class);

    @Activate
    protected void activate(ComponentContext context) {
        if (log.isDebugEnabled()) {
            log.debug("Activating CustomConnectorServiceComponent");
        }
        try {
            CustomProvisioningConnectorFactory provisioningConnectorFactory = new
                    CustomProvisioningConnectorFactory();
            context.getBundleContext().registerService(AbstractProvisioningConnectorFactory.class.getName(),
                    provisioningConnectorFactory, null);
            if (log.isDebugEnabled()) {
                log.debug("Custom Outbound Provisioning Connector bundle is activated");
            }
        } catch (Throwable e) {
            log.error("Error while activating Custom Identity Provisioning Connector ", e);
        }
    }
}
