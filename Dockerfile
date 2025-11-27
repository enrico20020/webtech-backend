# -------------------------------------------------------------------------
# STAGE 1: BUILD - Bleibt korrekt
# -------------------------------------------------------------------------
FROM gradle:jdk21-jammy AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN chmod +x gradlew
# Behält die stabilste Build-Kette bei
RUN ./gradlew clean classes bootJar --no-daemon

# -------------------------------------------------------------------------
# STAGE 2: RUN - Bypasst den Spring Boot Loader (Fix für ClassNotFoundException)
# -------------------------------------------------------------------------
FROM eclipse-temurin:21-jre-jammy
# Installiert das Entpack-Programm, das wir brauchen
RUN apt-get update && apt-get install -y unzip && rm -rf /var/lib/apt/lists/*

# Kopiere die JAR
COPY --from=build /home/gradle/src/build/libs/webtech-0.0.1-SNAPSHOT.jar app.jar

# Entpacke die ausführbare JAR-Datei in den Ordner 'app'
RUN unzip app.jar -d app
WORKDIR /app

# NEUER, FINALER ENTRYPOINT: Startet die Anwendung direkt über den Classpath.
# Wir sagen der JVM explizit, wo sie die Klassen und die Abhängigkeiten suchen soll.
ENTRYPOINT ["java", "-cp", "BOOT-INF/classes:BOOT-INF/lib/*", "htwwebtech.webtech.WebtechApplication"]