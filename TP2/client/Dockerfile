FROM openjdk:17-jdk-slim
WORKDIR /tp2
COPY target/tp2-client-0.0.1.jar tp2-client.jar
EXPOSE 8081
ENTRYPOINT [ "java", "-jar", "tp2-client.jar"]