package com.seda.qoe.rest.controllers;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.seda.qoe.config.SpringMVCConfig;
import com.seda.qoe.dto.mos.MosCreateDTO;
import com.seda.qoe.facade.MosFacade;
import com.seda.qoe.rest.controllers.hateos.MosRestHateosController;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.lang.reflect.Method;
import java.util.Collections;

import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;


@WebAppConfiguration
@ContextConfiguration(classes = { SpringMVCConfig.class})
public class MosRestHateosControllerTest extends AbstractTestNGSpringContextTests{
	
	@Mock
	private MosFacade mosFacade;
	
	@Autowired
	@InjectMocks
	private MosRestHateosController mosRestHateosController;
	
	private MockMvc mockMvc;
	
	@BeforeClass
	public void setup(){
		MockitoAnnotations.initMocks(this);
		mockMvc = standaloneSetup(mosRestHateosController).setMessageConverters(new MappingJackson2HttpMessageConverter()).build();          
	}
	
    /**
     * Registering the GlobalExceptionController if @ControllerAdvice is used
     * this can be used in SetHandlerExceptionResolvers() standaloneSetup()
     * Note that new Spring version from 4.2 has already a setControllerAdvice() method on 
     * MockMVC builders, so in that case it is only needed to pass one or more
     * @ControllerAdvice(s) configured within the application
     * 
     * @return
     */
    private ExceptionHandlerExceptionResolver createExceptionResolver() {
        ExceptionHandlerExceptionResolver exceptionResolver = new ExceptionHandlerExceptionResolver() {
            protected ServletInvocableHandlerMethod getExceptionHandlerMethod(HandlerMethod handlerMethod, Exception exception) {
                Method method = new ExceptionHandlerMethodResolver(GlobalExceptionController.class).resolveMethod(exception);
                return new ServletInvocableHandlerMethod(new GlobalExceptionController(), method);
            }
        };
        exceptionResolver.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        exceptionResolver.afterPropertiesSet();
        return exceptionResolver;
    }
    
    @Test
    public void createMos(){
    	MosCreateDTO mosCreateDTO = new MosCreateDTO();
    	
    }
    
//    @Test
//    public void getAllMos(){
//    	doReturn(Collections.unmodifiableList(this.createMos())).when(
//				mosFacade).getAllMos();
//    }

}
