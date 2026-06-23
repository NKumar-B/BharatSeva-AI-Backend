# Stage 1
FROM eclipse-temurin:17-jdk-alpine AS build
COPY . .
RUN ./mvnw clean package -DskipTests

# Stage 2
FROM eclipse-temurin:17-jre-alpine

COPY --from=build /target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]