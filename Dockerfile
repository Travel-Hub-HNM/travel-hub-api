# JDK 17 slim 이미지 사용
FROM openjdk:17-jdk-slim

# 작업 디렉토리 설정
WORKDIR /app

# 빌드된 JAR 복사
COPY build/libs/*.jar app.jar
COPY logback-spring.xml logback-spring.xml

# 실행 명령어
ENTRYPOINT ["java", "-jar", "app.jar", "--logging.config=logback-spring.xml"]