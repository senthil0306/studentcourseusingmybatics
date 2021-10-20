/*
 * Copyright (c) 2021
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.student.course.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.util.Assert;

/**
 * Configuration to create the H2 datasource, sqlSessionFactory and transactionManger.
 *
 * @author Senthil M
 */
@Configuration
@Profile("h2")
public class H2Configuration {

	private static final String SQL_CONFIG_FILE = "sqlmaps/ConfigSqlMap.xml";

	@Value("${database.h2.username}")
	private String username;

	@Value("${database.h2.password}")
	private String password;

	/**
	 * Creates the {@link DataSource}.
	 *
	 * @return dataSource
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public DataSource dataSource() {
		Assert.isTrue(StringUtils.isNotBlank(this.username), "Unable to determine H2 username.");
		//Assert.isTrue(StringUtils.isNotBlank(this.password), "Unable to determine H2 password.");
		return DataSourceBuilder
				.create()
				.username(this.username)
				.password(this.password)
				.build();
	}

	/**
	 * Creates the {@link SqlSessionFactory}.
	 *
	 * @return sqlSessionFactoryBeanPrimary
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception { // NOPMD - SignatureDeclareThrowsException
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		Resource configLocation = new ClassPathResource(SQL_CONFIG_FILE);
		sqlSessionFactoryBean.setConfigLocation(configLocation);
		return sqlSessionFactoryBean.getObject();
	}

	/**
	 * Creates the {@link PlatformTransactionManager}.
	 *
	 * @return transactionManager
	 */
	@Bean
	@Primary
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	@Bean(name = "transactionManagerSecondary")
	public PlatformTransactionManager transactionManagerSecondary() throws SQLException {
		return new DataSourceTransactionManager(dataSource());
	}
}
