# -------------------------------------------------------------------------
# STAGE 1: BUILD (Bleibt korrekt)
# -------------------------------------------------------------------------
FROM gradle:jdk21-jammy AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN chmod +x gradlew
# Stellt sicher, dass das ausführbare JAR-Task ausgeführt wird
RUN ./gradlew clean bootJar --no-daemon

# -------------------------------------------------------------------------
# STAGE 2: RUN - Exploded JAR Fix auf Alpine
# -------------------------------------------------------------------------
FROM eclipse-temurin:21-jre-alpine

# Installiere unzip (Alpine verwendet apk, nicht apt-get)
RUN apk update && apk add unzip

# Kopiere die JAR
COPY --from=build /home/gradle/src/build/libs/webtech-0.0.1-SNAPSHOT.jar app.jar

# Entpacke die ausführbare JAR-Datei und wechsle in das Verzeichnis
RUN unzip app.jar -d app
WORKDIR /app

# FINALER, ROBUSTER STARTBEFEHL: Exploded JAR mit Shell-Classpath-Erweiterung
# Dies ist der einzige Weg, das "ClassNotFoundException" in dieser Situation zu beheben.
CMD sh -c 'java -cp BOOT-INF/classes:BOOT-INF/lib/* htwwebtech.webtech.WebtechApplication'