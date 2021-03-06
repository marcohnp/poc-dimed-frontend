package com.dimed.backend.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.dimed.backend"))
				.paths(regex("/api.*"))
				.build()
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {

		ApiInfo apiInfo = new ApiInfo(
				"POC DIMED BACKEND",
				"TRANSPORTE REST API TESTE.",
				"1.0",
				"",
				new Contact("Marco Henrique Nunes Pereira", "https://gitlab.com/marcohnp/poc-dimed-backend",
						"marcoh@grupodimed.com.br"),
				"Apache License Version 2.0",
				"https://www.apache.org/licesen.html",
				new ArrayList<VendorExtension>()
		);

		return apiInfo;
	}
}