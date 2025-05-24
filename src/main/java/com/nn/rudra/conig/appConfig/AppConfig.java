package com.nn.rudra.conig.appConfig;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class AppConfig {

	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource datasource) {
		return new NamedParameterJdbcTemplate(datasource);
	}
}
