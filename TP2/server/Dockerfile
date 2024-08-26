FROM openjdk:17-jdk-slim
WORKDIR /tp2
COPY target/tp2-server-0.0.1.jar tp2-server.jar
EXPOSE 8761
ENTRYPOINT [ "java", "-jar", "tp2-server.jar"]