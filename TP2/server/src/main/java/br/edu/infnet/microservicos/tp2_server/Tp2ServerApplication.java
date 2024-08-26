package br.edu.infnet.microservicos.tp2_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Tp2ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tp2ServerApplication.class, args);
	}

}
