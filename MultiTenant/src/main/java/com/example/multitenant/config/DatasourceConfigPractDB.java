package com.example.multitenant.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.multitenant.pract.model.Client;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "practentityManagerFactory", 
	transactionManagerRef = "practDbTransactionManager",
	basePackages = { "com.example.multitenant.pract.repo" })
public class DatasourceConfigPractDB {

	@Primary
	@Bean
	@ConfigurationProperties("spring.pract.datasource")
	public DataSourceProperties practDatasourceProperty() {
		return new DataSourceProperties();
	}
	
	
	@Primary
	@Bean
	@ConfigurationProperties("spring.pract.datasource.configuration")
	public DataSource practDataSource() {
		return practDatasourceProperty().initializeDataSourceBuilder()
				.type(HikariDataSource.class)
				.build();
	}
	
	@Primary
	@Bean("practentityManagerFactory")
	public LocalContainerEntityManagerFactoryBean practDbEntitytManager(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(practDataSource())
				.packages(Client.class)
				.build();
	}
	
	@Primary
	@Bean("practDbTransactionManager")
	public PlatformTransactionManager practDbTransactionManager(final @Qualifier("practentityManagerFactory") LocalContainerEntityManagerFactoryBean lcemfb) {
		return new JpaTransactionManager(lcemfb.getObject());
	}
	
}
