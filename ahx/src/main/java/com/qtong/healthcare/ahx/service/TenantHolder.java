package com.qtong.healthcare.ahx.service;

import com.google.common.base.Preconditions;

/**
 * Created by ZML on 2015/4/23.
 */


public class TenantHolder {

    private static ThreadLocal<String> holder=new ThreadLocal<String>();

    public static void setCurrentItenant(String itenantId){

        Preconditions.checkNotNull(itenantId,"当前租户ID为空");
        holder.set(itenantId);
    }

    public static String getCurrentItenant(){
        return holder.get();
    }
}
