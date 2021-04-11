package com.formacionbdi.microservicios.app.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;

@EnableZuulProxy
@Controller
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviciosZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosZuulApplication.class, args);
	}

}
