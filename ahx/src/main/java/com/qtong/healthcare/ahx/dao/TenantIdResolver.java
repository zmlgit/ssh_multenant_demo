package com.qtong.healthcare.ahx.dao;


import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

/**
 * Created by ZML on 2015/4/20.
 */
public class TenantIdResolver implements CurrentTenantIdentifierResolver {
    @Override
    public String resolveCurrentTenantIdentifier() {

        return "programmerDb";
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return false;
    }
}
