package br.edu.infnet.microsservicos.AT.aeronave_service.system;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class WebConfig {
    @Bean
    public RouterFunction<ServerResponse> staticResourceRouter() {
        return RouterFunctions
            .resources("/h2-console/**", new ClassPathResource("static/h2-console/"));
    }
}
