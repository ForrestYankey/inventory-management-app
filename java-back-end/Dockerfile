# Use the official Maven image as base image for building
FROM maven:3.8.4-openjdk-11-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the project files and download dependencies
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean install -DskipTests

# Use the official OpenJDK image as base image for runtime
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/java-back-end.jar /inventory-management-app/java-back-end.jar

# Expose the port the app runs on
EXPOSE 8080

# Specify the command to run on container start
CMD ["java", "-jar", "java-back-end.jar"]

