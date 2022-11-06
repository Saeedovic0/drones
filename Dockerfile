FROM maven:3.8.6-amazoncorretto-19 AS builder
WORKDIR /build/
COPY pom.xml /build/
RUN mvn verify clean --fail-never
COPY . /build/
RUN mvn -e -q -D maven.test.failure.ignore=true clean package

FROM amazoncorretto:19-alpine AS code
WORKDIR /app
COPY --from=builder /build/target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
