FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/*.jar travel-hub-api.jar
COPY config/ config/
COPY src/main/resources/logback-spring.xml logback-spring.xml

ENTRYPOINT ["java", "-jar", "travel-hub-api.jar"]
