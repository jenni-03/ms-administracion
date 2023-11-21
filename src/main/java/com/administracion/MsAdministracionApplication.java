package com.administracion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsAdministracionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAdministracionApplication.class, args);
	}

}
