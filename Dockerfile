FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY ./build/libs/planaplan_backend-0.0.1.jar /app/planaplan_backend.jar
ENTRYPOINT ["java","-jar","planaplan_backend.jar"]