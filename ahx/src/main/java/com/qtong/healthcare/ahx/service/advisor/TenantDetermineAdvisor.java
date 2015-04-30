package com.qtong.healthcare.ahx.service.advisor;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by ZML on 2015/4/23.
 */
public class TenantDetermineAdvisor implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

        method.invoke(target,args);
    }
}
