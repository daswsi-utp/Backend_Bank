FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/service-card-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8085  
ENTRYPOINT ["java", "-jar", "app.jar"]
