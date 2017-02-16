package com.seda.qoe.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.seda.qoe.context.PersistenceApplicationContext;

/**
 * 
 * @author Pavel Šeda (441048) 
 * 
 */
@Configuration
@Import(PersistenceApplicationContext.class)
@ComponentScan(basePackages = { "com.seda.qoe.security", "com.seda.qoe.mapping", "com.seda.qoe.service", "com.seda.qoe.facade" })
public class BeanMappingConfiguration {
        
//	@Bean
//	public ModelMapper modelMapper() {
//		ModelMapper mapper = new ModelMapper();
//		return mapper;
//	}
	
	@Bean
	public Mapper dozer(){
		DozerBeanMapper dozer = new DozerBeanMapper();		
		return dozer;
	}

}
