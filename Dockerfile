FROM eclipse-temurin:17-jdk-alpine

EXPOSE 8081

LABEL authors="rsalliswell@gmail.com"

WORKDIR /app

COPY target/JenkinsCICD.jar /app/JenkinsCICD.jar

ENTRYPOINT ["java", "-jar", "JenkinsCICD.jar"]
