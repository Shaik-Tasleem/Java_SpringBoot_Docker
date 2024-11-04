FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/Springpro-0.0.1-SNAPSHOT.jar spring-app
EXPOSE 8087
ENTRYPOINT ["java","-jar","spring-app.jar"]