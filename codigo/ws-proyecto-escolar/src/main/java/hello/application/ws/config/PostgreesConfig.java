//package hello.application.ws.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.stereotype.Component;
//
//@Configuration
//@Component
//public class PostgreesConfig {
//
//	@Bean(name = "dataSource")
//	public DriverManagerDataSource dataSource() {
//		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//		driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
//		driverManagerDataSource.setUrl("jdbc:postgres://iloorkeu:tYswLyuPniBa6JhaHlcmZZhytaanoTfZ@raja.db.elephantsql.com:5432/iloorkeu");
//		driverManagerDataSource.setUsername("iloorkeu");
//		driverManagerDataSource.setPassword("tYswLyuPniBa6JhaHlcmZZhytaanoTfZ");
//		return new DriverManagerDataSource();
//	}
//	
//}
