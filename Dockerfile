# Stage 1: Build the application
FROM maven:3.8-openjdk-17-slim AS build
WORKDIR /app

# Copy the pom.xml and install dependencies
COPY pom.xml /app
RUN mvn dependency:go-offline

# Copy the rest of the application and build it
COPY src /app/src
RUN mvn clean package -DskipTests

# Stage 2: Create the production image
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy the .jar file from the build stage
COPY --from=build /app/target/voting-app-*.jar /app/voting-app.jar

# Expose the port that the application will run on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "/app/voting-app.jar"]

