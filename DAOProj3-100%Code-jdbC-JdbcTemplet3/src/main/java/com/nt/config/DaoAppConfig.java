package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
@PropertySource( "com/nt/properties/jdbc.properties")
public class DaoAppConfig {
	@Autowired
	private Environment env;

	@Bean(name = "hkds")
	public HikariDataSource createDs() {
		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
		ds.setJdbcUrl(env.getRequiredProperty("jdbc.url"));
		ds.setUsername(env.getRequiredProperty("jdbc.username"));
		ds.setPassword(env.getRequiredProperty("jdbc.pwd"));
		return ds;
	}

	@Bean(name = "templet")
	public JdbcTemplate templet() {
		JdbcTemplate jt=new JdbcTemplate();
      jt.setDataSource(createDs());
		return jt;
	}
}
