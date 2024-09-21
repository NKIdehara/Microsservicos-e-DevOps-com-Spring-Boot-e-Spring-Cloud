FROM openjdk:17-jdk-slim
WORKDIR /microsservicos
COPY target/veiculo-service-0.0.1.jar veiculo-service.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "veiculo-service.jar"]