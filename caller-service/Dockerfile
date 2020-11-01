FROM openjdk:11-jre-slim
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} caller-service.jar
ENTRYPOINT ["java","-jar","caller-service.jar"]