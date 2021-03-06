package com.qtong.healthcare.ahx.dao;

/**
 * Created by ZML on 2015/4/16.
 */
public class DataSourceHolder {

    private static final  ThreadLocal<String> holder = new ThreadLocal<String>();

    public static String getDataSourceType() {
        return holder.get();
    }

    public static void setDataSource(String type) {
        holder.set(type);
    }

    public static void clearDataSource() {
        holder.remove();
    }
}
