package org.wso2.custom.provisioning.connector.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.wso2.carbon.identity.provisioning.AbstractProvisioningConnectorFactory;
import org.wso2.custom.provisioning.connector.CustomProvisioningConnectorFactory;

/**
 * CustomConnectorServiceComponent Class
 * This class registers the custom provisioning connector as an OSGi service.
 */
@Component(
        name = "identity.custom.outbound.provisioning.connector",
        immediate = true
)
public class CustomConnectorServiceComponent {

    private static Log log = LogFactory.getLog(CustomConnectorServiceComponent.class);

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
