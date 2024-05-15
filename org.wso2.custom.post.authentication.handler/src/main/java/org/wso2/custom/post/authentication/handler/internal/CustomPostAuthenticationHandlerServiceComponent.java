package org.wso2.custom.post.authentication.handler.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.wso2.carbon.identity.application.authentication.framework.handler.request.PostAuthenticationHandler;
import org.wso2.carbon.identity.core.util.IdentityCoreInitializedEvent;
import org.wso2.custom.post.authentication.handler.CustomPostAuthenticationHandler;

@Component(
        name = "identity.custom.post.authentication.handler",
        immediate = true
)
public class CustomPostAuthenticationHandlerServiceComponent {

    private static final Log log = LogFactory.getLog(CustomPostAuthenticationHandlerServiceComponent.class);

    @Activate
    protected void activate(ComponentContext context) {

        try {
            CustomPostAuthenticationHandler disclaimerPostAuthenticationHandler =
                    new CustomPostAuthenticationHandler();
            context.getBundleContext().registerService(PostAuthenticationHandler.class.getName(),
                    disclaimerPostAuthenticationHandler, null);

        } catch (Throwable e) {
            log.error("Error while activating disclaimer post authentication handler.", e);
        }
    }

    protected void unsetIdentityCoreInitializedEventService(IdentityCoreInitializedEvent identityCoreInitializedEvent) {
        /* reference IdentityCoreInitializedEvent service to guarantee that this component will wait until identity core
         is started */
    }

    @Reference(
            name = "identity.core.init.event.service",
            service = IdentityCoreInitializedEvent.class,
            cardinality = ReferenceCardinality.MANDATORY,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "unsetIdentityCoreInitializedEventService"
    )
    protected void setIdentityCoreInitializedEventService(IdentityCoreInitializedEvent identityCoreInitializedEvent) {
        /* reference IdentityCoreInitializedEvent service to guarantee that this component will wait until identity core
         is started */
    }
}
