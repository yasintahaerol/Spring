package com.example.omreon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.omreon.model.ScUserlogService;
@ComponentScan
@SpringBootApplication(scanBasePackageClasses = {ScUserlogService.class})
public class OmreonApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmreonApplication.class, args);
		System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow", "{}");
	}

}
