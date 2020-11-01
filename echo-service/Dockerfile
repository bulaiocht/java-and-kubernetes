FROM openjdk:11-jre-slim
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} echo-service.jar
ENTRYPOINT ["java","-jar","echo-service.jar"]