FROM openjdk:17-jdk-slim
WORKDIR /microsservicos
COPY target/server-0.0.1.jar server.jar
EXPOSE 8761
ENTRYPOINT [ "java", "-jar", "server.jar"]