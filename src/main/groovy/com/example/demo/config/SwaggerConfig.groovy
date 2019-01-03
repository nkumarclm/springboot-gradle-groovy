package com.example.demo.config

import com.example.demo.controller.PartnerController
import com.google.common.collect.Lists
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.service.Contact
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
@Slf4j
public class SwaggerConfig {

    @Autowired
    Environment environment;

    @Bean
    public Docket demoApi() {
        log.warn("Swagger UI enabled under /swagger-ui.html. Please don't do this in higher environments.")
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage(PartnerController.class.getPackage().getName()))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfo("Demo Service", "API Doc for Demo service", "" , "", "", "", ""))
    }
}