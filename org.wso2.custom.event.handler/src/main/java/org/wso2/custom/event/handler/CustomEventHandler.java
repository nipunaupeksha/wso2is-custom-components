package org.wso2.custom.event.handler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.core.bean.context.MessageContext;
import org.wso2.carbon.identity.event.IdentityEventConstants;
import org.wso2.carbon.identity.event.IdentityEventException;
import org.wso2.carbon.identity.event.event.Event;
import org.wso2.carbon.identity.event.handler.AbstractEventHandler;

import java.util.Map;

public class CustomEventHandler extends AbstractEventHandler {

    private static final Log log = LogFactory.getLog(CustomEventHandler.class);

    @Override
    public void handleEvent(Event event) throws IdentityEventException {

        log.info("Custom event handler received events successfully.");
        String eventName = "POST_AUTHENTICATION";
        if(eventName.equals(event.getEventName())){
            Map<String, Object> eventProperties = event.getEventProperties();
            String userName = (String)eventProperties.get(IdentityEventConstants.EventProperty.USER_NAME);
            log.info("Authenticated user: "+ userName);
        }
    }
    @Override
    public int getPriority(MessageContext messageContext){
        return 50;
    }

    @Override
    public String getName(){
        return "custom.event.handler";
    }
}
