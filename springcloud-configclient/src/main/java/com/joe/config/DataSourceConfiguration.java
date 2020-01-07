package com.joe.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * DataSource配置
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceConfiguration {

    //@Value("${spring.datasource.url}")
    private String url;
    //@Value("${spring.datasource.driver-class-name}")
    private String driver;
    //@Value("${spring.datasource.username}")
    private String username;
    //@Value("${spring.datasource.password}")
    private String password;
    //@Value("${spring.datasource.maxActive}")
    private int maxActive;
    //@Value("${spring.datasource.filters}")
    private String filters;
    //@Value("${spring.datasource.initialSize}")
    private int initialSize;
    //@Value("${spring.datasource.minIdle}")
    private int minIdle;
    //@Value("${spring.datasource.maxWait}")
    private int maxWait;
    //@Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    //@Value("${spring.datasource.removeAbandoned}")
    private boolean removeAbandoned;
    //@Value("${spring.datasource.removeAbandonedTimeout}")
    private int removeAbandonedTimeout;
    //@Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;
    //@Value("${spring.datasource.validationQuery}")
    private String validationQuery;
    //@Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;
    //@Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;
    //@Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;
    //@Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    //@Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;
    //@Value("${spring.datasource.connectionProperties}")
    private String connectionProperties;
    //@Value("${spring.datasource.useGlobalDataSourceStat}")
    private boolean useGlobalDataSourceStat;

    @Bean     //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        /*数据源主要配置*/
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        /*数据源补充配置*/
        dataSource.setMaxActive(maxActive);
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setRemoveAbandoned(removeAbandoned);
        dataSource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        dataSource.setConnectionProperties(connectionProperties);
        dataSource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);
        try {
            dataSource.setFilters(filters);
        } catch (SQLException e) {
            System.err.println("druid configuration initialization filter: " + e);
        }
        dataSource.setConnectionProperties(connectionProperties);
        return dataSource;
    }

}
