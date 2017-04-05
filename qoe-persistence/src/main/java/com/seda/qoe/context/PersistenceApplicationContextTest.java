package com.seda.qoe.context;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * @author Pavel Šeda (441048)
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.seda.qoe.dao" })
@ComponentScan(basePackages = { "com.seda.qoe.entity", "com.seda.qoe.dao" })
public class PersistenceApplicationContextTest {

	/**
	 * Enables automatic translation of exceptions to DataAccessExceptions.
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor postProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory().getObject());
	}

	/**
	 * Starts up a container that emulates behavior prescribed in JPA spec for
	 * container-managed EntityManager
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean jpaFactoryBean = new LocalContainerEntityManagerFactoryBean();
		jpaFactoryBean.setDataSource(db());
		jpaFactoryBean.setLoadTimeWeaver(instrumentationLoadTimeWeaver());
		jpaFactoryBean
				.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		jpaFactoryBean.setPersistenceXmlLocation("classpath:META-INF/persistence-test.xml");
		jpaFactoryBean.setPersistenceUnitName("persistenceTest");
		return jpaFactoryBean;
	}

	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() {
		return new LocalValidatorFactoryBean();
	}

	@Bean
	public LoadTimeWeaver instrumentationLoadTimeWeaver() {
		return new InstrumentationLoadTimeWeaver();
	}

	@Bean
	public DataSource db() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		return builder.setType(EmbeddedDatabaseType.DERBY).build();
	}

}
