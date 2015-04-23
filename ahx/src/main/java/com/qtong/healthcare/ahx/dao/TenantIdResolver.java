package com.qtong.healthcare.ahx.dao;


import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by ZML on 2015/4/20.
 */
public class TenantIdResolver implements CurrentTenantIdentifierResolver {

    private static final String DEFAULTSCHEME="programmerDb";

    private static  Properties properties=null;

    private static Logger logger=Logger.getLogger(TenantIdResolver.class);

    public TenantIdResolver() {

        try {
            if(null==properties){
                properties.load(TenantIdResolver.class.getResourceAsStream("tenant.properties"));
            }
        } catch (IOException e) {
            logger.error(e.getLocalizedMessage(),e);
        }

    }

    @Override
    public String resolveCurrentTenantIdentifier() {
       if(!SecurityUtils.getSubject().isAuthenticated()){
           return DEFAULTSCHEME;
       }
        for (String prop: properties.stringPropertyNames()){
            if(SecurityUtils.getSubject().hasRole(prop)){
                return properties.getProperty(prop);
            }
        }
        return DEFAULTSCHEME;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return false;
    }
}
