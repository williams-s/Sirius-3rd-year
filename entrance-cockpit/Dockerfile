FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copier le pom parent
COPY pom.xml .

# Copier les pom.xml de TOUS les modules
COPY common-library/pom.xml ./common-library/pom.xml
COPY player-performance/pom.xml ./player-performance/pom.xml
COPY team-performance/pom.xml ./team-performance/pom.xml
COPY entrance-cockpit/pom.xml ./entrance-cockpit/pom.xml

# Installer le parent d'abord
RUN mvn install -N -DskipTests

# Installer common-library
COPY common-library/src ./common-library/src
RUN mvn install -pl common-library -DskipTests

# Builder entrance-cockpit
COPY entrance-cockpit/src ./entrance-cockpit/src
RUN mvn package -pl entrance-cockpit -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/entrance-cockpit/target/*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]