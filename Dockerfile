# Use a base image with OpenJDK 22
FROM openjdk:22-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/avidea-0.0.1-SNAPSHOT.jar app.jar

# Specify the command to run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Expose the port the application runs on
EXPOSE 8080
