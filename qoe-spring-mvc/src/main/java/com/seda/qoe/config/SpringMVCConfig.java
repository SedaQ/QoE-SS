package com.seda.qoe.config;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.validation.Validator;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.seda.qoe.rest.AllowOriginInterceptor;
import com.seda.qoe.dto.mos.MosDTO;
import com.seda.qoe.dto.questionary.QuestionaryDTO;
import com.seda.qoe.dto.scenario.ScenarioDTO;
import com.seda.qoe.dto.scenarioparameters.ScenarioParametersDTO;
import com.seda.qoe.dto.user.UserDTO;
import com.seda.qoe.dto.video.VideoDTO;
import com.seda.qoe.rest.mixin.MosDTOMixin;
import com.seda.qoe.rest.mixin.QuestionaryDTOMixin;
import com.seda.qoe.rest.mixin.ScenarioDTOMixin;
import com.seda.qoe.rest.mixin.ScenarioParametersDTOMixin;
import com.seda.qoe.rest.mixin.UserDTOMixin;
import com.seda.qoe.rest.mixin.VideoDTOMixin;
import com.seda.qoe.security.WebSecurityConfig;

@EnableWebMvc
@Configuration
@Import({BeanMappingConfiguration.class, WebSecurityConfig.class})
@ComponentScan(basePackages = { "com.seda.qoe.controllers", "com.seda.qoe.security", "com.seda.qoe.rest.controllers", "com.seda.qoe.rest"})
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
		registry.addResourceHandler("/WEB-INF/assets/**").addResourceLocations("/WEB-INF/assets/").setCachePeriod(31556926);
		registry.addResourceHandler("/assets/bootstrap/**").addResourceLocations("/assets/bootstrap/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/assets/reveal/**").addResourceLocations("/assets/reveal/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/assets/pdf/**").addResourceLocations("/assets/reveal/")
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
	
	/**
	 * REST settings .
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AllowOriginInterceptor());
	}

	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {
		converters.add(customJackson2HttpMessageConverter());
	}
	
	@Bean
	@Primary
	public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(
				DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm",
				Locale.ENGLISH));

		// TODO need to add mixins.. it is used for ignoring inner objects
		// {collections} but it is still invoking dependencies etc. so it is
		// needed to make it better!
		objectMapper.addMixIn(UserDTO.class, UserDTOMixin.class);
		objectMapper.addMixIn(MosDTO.class, MosDTOMixin.class);
		objectMapper.addMixIn(QuestionaryDTO.class, QuestionaryDTOMixin.class);
		objectMapper.addMixIn(ScenarioDTO.class, ScenarioDTOMixin.class);
		objectMapper.addMixIn(ScenarioParametersDTO.class,
				ScenarioParametersDTOMixin.class);
		objectMapper.addMixIn(VideoDTO.class, VideoDTOMixin.class);

		objectMapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);

		jsonConverter.setObjectMapper(objectMapper);
		return jsonConverter;
	}

}
