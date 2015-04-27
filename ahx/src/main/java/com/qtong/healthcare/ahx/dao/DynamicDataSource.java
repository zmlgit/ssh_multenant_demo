package com.qtong.healthcare.ahx.dao;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by ZML on 2015/4/16.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected String determineCurrentLookupKey() {

//        System.out.println(DataSourceHolder.getDataSourceType());
       return DataSourceHolder.getDataSourceType();
       // return "testDb";
    }

}
