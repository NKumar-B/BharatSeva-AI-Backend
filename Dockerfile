# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jdk-alpine
# Copy the built JAR file into the container
COPY target/*.jar app.jar
# Run the JAR file
ENTRYPOINT ["java","-jar","/app.jar"]