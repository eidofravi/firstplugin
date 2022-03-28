FROM openjdk:8-jdk-alpine
ENV PORT 8081
EXPOSE 8081
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} springbootservertemplate.jar
ENTRYPOINT ["java","-jar","/springbootservertemplate.jar"]