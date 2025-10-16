# Use OpenJDK 17 (matches your pom.xml)
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built JAR
COPY target/*.jar app.jar

# Expose port (Render assigns dynamically; your app uses ${PORT:8080})
EXPOSE $PORT

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]