FROM eclipse-temurin:17-jdk-jammy AS build

WORKDIR /app


COPY .mvn .mvn

COPY mvnw pom.xml ./


RUN chmod +x mvnw

RUN ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["sh", "-c", "java -jar app.jar"]
