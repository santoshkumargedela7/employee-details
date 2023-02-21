package com.siva.EmployeeDetails.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@EnableWebMvc
@EnableSwagger2
public class SwaggerCongifuration {


    @Bean
    Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-apis")
                .apiInfo(getApiInfo())
                .select().
                apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).
                build();
    }
	
	public ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("EMPLOYEE-DETAILS").description("Employee details Api")
				.version("2").build();
		
	}
}
