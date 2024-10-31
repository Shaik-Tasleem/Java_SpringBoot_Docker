FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/Springpro-0.0.1-SNAPSHOT.jar tvshow.jar

EXPOSE 8087

ENTRYPOINT ["java", "-jar", "tvshow.jar"]
