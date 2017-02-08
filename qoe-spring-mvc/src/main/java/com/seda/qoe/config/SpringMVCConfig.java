package com.seda.qoe.config;

import javax.validation.Validator;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.seda.qoe.security.WebSecurityConfig;

@EnableWebMvc
@Configuration
@Import({ WebSecurityConfig.class })
@ComponentScan(basePackages = { "com.seda.qoe.controllers", "com.seda.qoe.security" })
public class SpringMVCConfig extends WebMvcConfigurerAdapter {

	public static final String TEXTS = "Texts";

	/**
	 * Maps the main page to a specific view.
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}

	/**
	 * Enables default Tomcat servlet that serves static files.
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/**
	 * Provides mapping for assets
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// registry.addResourceHandler("/WEB-INF/assets/**").addResourceLocations("/WEB-INF/assets/").setCachePeriod(31556926);
		registry.addResourceHandler("/assets/bootstrap/**").addResourceLocations("/assets/bootstrap/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/assets/reveal/**").addResourceLocations("/assets/reveal/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/assets/videa/**").addResourceLocations("/assets/videa/").setCachePeriod(31556926);
		registry.addResourceHandler("/assets/css/**").addResourceLocations("/assets/css/").setCachePeriod(31556926);
		registry.addResourceHandler("/assets/font-awesome/**").addResourceLocations("/assets/font-awesome/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/assets/ico/**").addResourceLocations("/assets/ico/").setCachePeriod(31556926);
		registry.addResourceHandler("/assets/img/**").addResourceLocations("/assets/img/").setCachePeriod(31556926);
		registry.addResourceHandler("/assets/js/**").addResourceLocations("/assets/js/").setCachePeriod(31556926);
	}

	/**
	 * Provides mapping from view names to JSP pages in WEB-INF/jsp directory.
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		// viewResolver.setCharacterEncoding("UTF-8");
		viewResolver.setContentType("text/html; charset=UTF-8");
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	/**
	 * Provides localized messages.
	 */
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename(TEXTS);
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	/**
	 * Provides JSR-303 Validator.
	 */
	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}

}
