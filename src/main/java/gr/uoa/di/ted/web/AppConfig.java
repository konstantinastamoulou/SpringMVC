package gr.uoa.di.ted.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import gr.uoa.di.ted.converter.Id2Role;
import gr.uoa.di.ted.service.RoleService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "gr.uoa.di.ted")
class AppConfig extends WebMvcConfigurerAdapter {
 
	@Autowired
	Id2Role id2Role;
	
    @Override
    public void addFormatters(FormatterRegistry registry) {
    	
    	System.out.println("TESTTTT");
        registry.addConverter(id2Role);
    	System.out.println("TESTTTT2");
    }
}