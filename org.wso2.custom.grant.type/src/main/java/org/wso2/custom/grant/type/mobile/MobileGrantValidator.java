package org.wso2.custom.grant.type.mobile;

import org.apache.oltu.oauth2.common.validators.AbstractValidator;

import javax.servlet.http.HttpServletRequest;


public class MobileGrantValidator  extends AbstractValidator<HttpServletRequest> {


    public MobileGrantValidator() {

        // mobile number must be in the request parameter
        requiredParams.add(MobileGrant.MOBILE_GRANT_PARAM);
    }
}