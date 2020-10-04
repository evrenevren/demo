FROM openjdk:14-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} payment.jar
ENTRYPOINT ["java","-jar","/payment.jar"]
