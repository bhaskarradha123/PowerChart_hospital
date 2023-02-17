package com.ty.com.ty.springboot_hospital_eb9.responseStriucture;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {
	public Docket getDocket() {
		Contact contact = new Contact("TY", "www.tetyanra.com", "testyantrasupport@mail.com");
		List<VendorExtension> extensions = new ArrayList<VendorExtension>();
		ApiInfo apiInfo = new ApiInfo("Hospital_web App", "Hospital Appm V1.0", "Version 1.2",
				"www.testyantraglobal.com", contact, "testYtantralicence@asdf", "www.testyantraterms.com", extensions);

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ty.com.ty.springboot_hospital_eb9")).build()
				.apiInfo(apiInfo).useDefaultResponseMessages(false);
	}
}
