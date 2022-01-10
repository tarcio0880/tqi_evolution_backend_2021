package com.app.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.util.CollectionUtils;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.nio.file.Path;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.app.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData())
                .tags(new Tag("Login", "", 1),
                        new Tag("Cadastro de cliente", "", 2),
                        new Tag("Solicitação de Empréstimo", "", 3),
                        new Tag("Acompanhamento das solicitações de empréstimo", "", 4),
                        new Tag("Tarefas adicionais", "", 5));

    }


    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Emprestimo Rest API",
                "API Rest para emprestimo financeiro",
                "1.0",
                "Terms of service",
                new Contact("Tarcio Rodrigues", "https://www.linkedin.com/in/tarcio-rodrigues-8187aa227/", "tarciorodrigues0880@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0", Collections.EMPTY_LIST);
        return apiInfo;
    }
}