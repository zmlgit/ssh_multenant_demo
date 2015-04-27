package com.qtong.healthcare.ahx.dao;

import org.apache.log4j.Logger;
import org.hibernate.cfg.Environment;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.hibernate.service.UnknownUnwrapTypeException;
import org.hibernate.service.spi.ServiceRegistryAwareService;
import org.hibernate.service.spi.ServiceRegistryImplementor;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by ZML on 2015/4/20.
 */
public class SchemaBasedMultiTenantConnectionProvider implements MultiTenantConnectionProvider,ServiceRegistryAwareService {


    /**  
	* serialVersionUID:TODO（用一句话描述这个变量表示什么）  
	*  
	* @since Ver 1.1  
	*/  
	
	private static final long serialVersionUID = 5643321513633149830L;

	private Logger logger=Logger.getLogger(SchemaBasedMultiTenantConnectionProvider.class);

    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Connection getAnyConnection() throws SQLException {

        logger.debug("current thread connection name is :"+DataSourceHolder.getDataSourceType());
        if (dataSource==null){
            logger.error("dataSource is null!");
            return null;
        }
        return dataSource.getConnection();
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public Connection getConnection(String tenantIdentifier) throws SQLException {
        logger.debug("current tenantIdentifier is :"+tenantIdentifier);

        if(tenantIdentifier==null){
            return getAnyConnection();
        }
        DataSourceHolder.setDataSource(tenantIdentifier);
        if(dataSource==null){
            return null;
        }
        return dataSource.getConnection();
    }

    @Override
    public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
            releaseAnyConnection(connection);
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }

    @Override
    public boolean isUnwrappableAs(@SuppressWarnings("rawtypes") Class unwrapType) {
        return ConnectionProvider.class.equals(unwrapType) || MultiTenantConnectionProvider.class.equals(unwrapType) || SchemaBasedMultiTenantConnectionProvider.class.isAssignableFrom(unwrapType);
    }

    @SuppressWarnings("unchecked")
	@Override
    public <T> T unwrap(Class<T> unwrapType) {
        if (isUnwrappableAs(unwrapType)) {
            return (T) this;
        } else {
            throw new UnknownUnwrapTypeException(unwrapType);
        }
    }

    @Override
    public void injectServices(ServiceRegistryImplementor serviceRegistry) {
        @SuppressWarnings("rawtypes")
		java.util.Map lSettings = serviceRegistry.getService(ConfigurationService.class).getSettings();

        dataSource = (DataSource) lSettings.get( Environment.DATASOURCE );
    }
}
