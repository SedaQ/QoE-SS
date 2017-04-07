package cz.vutbr.feec.seda.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import cz.vutbr.feec.seda.context.PersistenceApplicationContext;

/**
 * 
 * @author Pavel Šeda (441048) 
 * 
 */
@Configuration
@Import(PersistenceApplicationContext.class)
@ComponentScan(basePackages = { "cz.vutbr.feec.seda.security", "cz.vutbr.feec.seda.mapping", "cz.vutbr.feec.seda.service", "cz.vutbr.feec.seda.facade" })
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
