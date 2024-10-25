FROM eclipse-temurin:23

WORKDIR /app

COPY target/product-0.0.1-SNAPSHOT.jar /app/product-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/product-service.jar"]
