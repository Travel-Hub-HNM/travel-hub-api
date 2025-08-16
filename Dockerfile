FROM openjdk:17-jdk-slim

COPY build/libs/*.jar /app/app.jar
COPY ./logback-spring.xml /app/logback-spring.xml

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
