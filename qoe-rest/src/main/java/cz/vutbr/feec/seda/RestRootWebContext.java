package cz.vutbr.feec.seda;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;

import cz.vutbr.feec.seda.config.BeanMappingConfiguration;
import cz.vutbr.feec.seda.dto.mos.MosDTO;
import cz.vutbr.feec.seda.dto.questionary.QuestionaryDTO;
import cz.vutbr.feec.seda.dto.scenario.ScenarioDTO;
import cz.vutbr.feec.seda.dto.scenarioparameters.ScenarioParametersDTO;
import cz.vutbr.feec.seda.dto.user.UserDTO;
import cz.vutbr.feec.seda.dto.video.VideoDTO;
import cz.vutbr.feec.seda.rest.mixin.MosDTOMixin;
import cz.vutbr.feec.seda.rest.mixin.QuestionaryDTOMixin;
import cz.vutbr.feec.seda.rest.mixin.ScenarioDTOMixin;
import cz.vutbr.feec.seda.rest.mixin.ScenarioParametersDTOMixin;
import cz.vutbr.feec.seda.rest.mixin.UserDTOMixin;
import cz.vutbr.feec.seda.rest.mixin.VideoDTOMixin;

import java.util.List;

import java.text.SimpleDateFormat;
import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@Import({BeanMappingConfiguration.class})
@ComponentScan(basePackages = {"cz.vutbr.feec.seda.controllers", "cz.vutbr.feec.seda.assemblers"})
public class RestRootWebContext extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AllowOriginInterceptor()); 
    }
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    @Bean
    @Primary
    public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH));
        
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

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(customJackson2HttpMessageConverter());
    }
}
