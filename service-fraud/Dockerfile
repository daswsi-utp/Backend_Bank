FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/service-fraud-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8089  
ENTRYPOINT ["java", "-jar", "app.jar"]
