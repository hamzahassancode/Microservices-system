FROM openjdk:20

WORKDIR /app
COPY target/authentication-service.jar /app/authentication-service.jar
EXPOSE 8080
CMD ["java", "-jar", "authentication-service.jar"]
