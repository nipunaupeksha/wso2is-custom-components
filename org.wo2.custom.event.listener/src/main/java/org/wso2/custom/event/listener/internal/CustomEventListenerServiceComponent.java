package org.wso2.custom.event.listener.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.wso2.carbon.user.core.listener.UserOperationEventListener;
import org.wso2.custom.event.listener.CustomEventListener;

@Component(
        name = "org.wso2.custom.event.listener",
        immediate = true
)
public class CustomEventListenerServiceComponent {
    private static final Log log = LogFactory.getLog(CustomEventListenerServiceComponent.class);

    @Activate
    protected void activate(ComponentContext context) {

        CustomEventListener listener = new CustomEventListener();
        context.getBundleContext().registerService(UserOperationEventListener.class.getName(),
                        listener, null);
        log.debug("Custom event listener activated successfully.");
    }

    @Deactivate
    protected void deactivate(ComponentContext context) {
        log.debug("Custom event listener is deactivated");
    }
}