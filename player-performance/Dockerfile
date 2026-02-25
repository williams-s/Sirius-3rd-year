FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .

COPY common-library/pom.xml ./common-library/pom.xml
COPY player-performance/pom.xml ./player-performance/pom.xml
COPY team-performance/pom.xml ./team-performance/pom.xml
COPY entrance-cockpit/pom.xml ./entrance-cockpit/pom.xml

RUN mvn install -N -DskipTests

COPY common-library/src ./common-library/src
RUN mvn install -pl common-library -DskipTests

COPY player-performance/src ./player-performance/src
RUN mvn package -pl player-performance -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/player-performance/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]