FROM maven:3.6.3-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY ./src ./src
RUN mvn dependency:go-offline
RUN mvn package

FROM eclipse-temurin:17.0.8.1_1-jdk
WORKDIR /app
COPY --from=build /app/target/product-search-service-1.0.jar /app/product-search-service-1.0.jar
CMD ["java", "-jar", "product-search-service-1.0.jar"]