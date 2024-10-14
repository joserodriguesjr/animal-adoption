#Build stage

FROM gradle:8.10.2-jdk21 AS build
WORKDIR /app
COPY . .
RUN gradle build

# Package stage

FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
