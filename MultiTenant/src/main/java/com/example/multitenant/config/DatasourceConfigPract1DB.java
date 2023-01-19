package com.example.multitenant.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
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

import com.example.multitenant.pract1.model.Client;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "practDb1entityManagerFactory", 
	transactionManagerRef = "practDb1TransactionalManager",
basePackages = { "com.example.multitenant.pract1.repo" })
public class DatasourceConfigPract1DB {

	//@Primary
	@Bean
	@ConfigurationProperties("spring.pract1.datasource")
	public DataSourceProperties pract1DatasourceProperty() {
		return new DataSourceProperties();
	}
	
	//@Primary
	@Bean
	@ConfigurationProperties("spring.pract1.datasource.configuration")
	public DataSource pract1DataSource() {
		return pract1DatasourceProperty().initializeDataSourceBuilder()
				.type(HikariDataSource.class)
				.build();
	}
	
	//@Primary
	@Bean("practDb1entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean pract1DbEntitytManager(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(pract1DataSource())
				.packages(Client.class)
				.build();
	}
	
	//@Primary
	@Bean("practDb1TransactionalManager")
	public PlatformTransactionManager practDb1TransactionManager(final @Qualifier("practDb1entityManagerFactory") LocalContainerEntityManagerFactoryBean lcemfbpract1) {
		return new JpaTransactionManager(lcemfbpract1.getObject());
	}
}
