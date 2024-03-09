FROM openjdk:20
WORKDIR /app
COPY target/analytics-service.jar /app/analytics-service.jar
EXPOSE 8081
CMD ["java", "-jar", "analytics-service.jar"]
