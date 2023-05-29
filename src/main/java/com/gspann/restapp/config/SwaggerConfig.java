package com.gspann.restapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
   /* @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gspann.restapp"))
                .paths(PathSelectors.any())
                .build().apiInfo(metaData());
    }*/
    @Bean
    public Docket configApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).pathMapping("/").select()
                .paths(regex("/api/books.*")).build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Book Rest Api-Swagger UI").
                description("").version("1.0").build();
    }
   /* private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Swagger UI For Rest  App")
                .description("\"spring boot library management rest application \"")
                .build();
    }*/
    //for Swagger api doc generation
    //http://localhost:8091/v2/api-docs
}
