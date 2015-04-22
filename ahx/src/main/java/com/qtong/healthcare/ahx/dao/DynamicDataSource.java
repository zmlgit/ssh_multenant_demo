package com.qtong.healthcare.ahx.dao;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;

/**
 * Created by ZML on 2015/4/16.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> holder=new ThreadLocal<String>();

    @Override
    protected String determineCurrentLookupKey() {

//        System.out.println(DataSourceHolder.getDataSourceType());
       return DataSourceHolder.getDataSourceType();
       // return "testDb";
    }

}
