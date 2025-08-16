FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build/libs/*.jar travel-hub-api.jar
COPY config/ config/
COPY src/main/resources/logback-spring.xml logback-spring.xml
COPY bootstrap.yml bootstrap.yml

RUN sed -i -E 's/^([[:space:]]*active:[[:space:]]*).*/\1'"$REF_NAME"'/' bootstrap.yml

ENTRYPOINT ["java", "-jar", "travel-hub-api.jar"]
