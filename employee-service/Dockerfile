FROM eclipse-temurin:17

LABEL maintainer="abhay.sharma@infostride.com"

WORKDIR /app

COPY target/employee-service-0.0.1-SNAPSHOT.jar /app/employee-service.jar

ENTRYPOINT ["java","-jar","employee-service.jar"]