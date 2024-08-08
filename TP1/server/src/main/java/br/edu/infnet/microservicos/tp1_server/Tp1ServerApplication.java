package br.edu.infnet.microservicos.tp1_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Tp1ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Tp1ServerApplication.class, args);
	}

}
