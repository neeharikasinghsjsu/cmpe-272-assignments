FROM maven:3.8.1-jdk-11 AS build
WORKDIR /app
COPY pom.xml .
COPY ./src ./src
RUN mvn dependency:go-offline
RUN mvn package -DskipTests

FROM eclipse-temurin:17.0.8.1_1-jdk
WORKDIR /app
COPY --from=build /app/target/spring-boot-crud-example-2-0.0.1-SNAPSHOT.jar /app/spring-boot-crud-example-2-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "spring-boot-crud-example-2-0.0.1-SNAPSHOT.jar"]