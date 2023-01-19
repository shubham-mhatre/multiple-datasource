package com.example.multitenant.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("spring.pract.datasource.hikari")
public class ConfigurationPropDemo {
	
	private Integer connectionTimeout;
	private Integer idleTimeout;
	private Integer maxLifetime;
	public Integer getConnectionTimeout() {
		return connectionTimeout;
	}
	public void setConnectionTimeout(Integer connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}
	public Integer getIdleTimeout() {
		return idleTimeout;
	}
	public void setIdleTimeout(Integer idleTimeout) {
		this.idleTimeout = idleTimeout;
	}
	public Integer getMaxLifetime() {
		return maxLifetime;
	}
	public void setMaxLifetime(Integer maxLifetime) {
		this.maxLifetime = maxLifetime;
	}
	@Override
	public String toString() {
		return "ConfigurationPropDemo [connectionTimeout=" + connectionTimeout + ", idleTimeout=" + idleTimeout
				+ ", maxLifetime=" + maxLifetime + "]";
	}
	
	
	
	
	

}
