FROM openjdk:19-jdk-alpine
COPY build/libs/rschir5-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]