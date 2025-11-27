# -------------------------------------------------------------------------
# STAGE 1: BUILD - Bleibt korrekt
# -------------------------------------------------------------------------
FROM gradle:jdk21-jammy AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN chmod +x gradlew
RUN ./gradlew clean build --no-daemon

# -------------------------------------------------------------------------
# STAGE 2: RUN - Wechsel zum stabilsten Basis-Image (Alpine)
# -------------------------------------------------------------------------
FROM eclipse-temurin:21-jre-alpine

# Kopiere die JAR
COPY --from=build /home/gradle/src/build/libs/webtech-0.0.1-SNAPSHOT.jar app.jar

# Startbefehl: Standard-Spring-Boot-Start (funktioniert auf Alpine)
ENTRYPOINT ["java","-jar","/app.jar"]