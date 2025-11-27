FROM gradle:jdk21-jammy AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN chmod +x gradlew
RUN ./gradlew clean classes bootJar --no-daemon

FROM eclipse-temurin:21-jre-jammy
COPY --from=build /home/gradle/src/build/libs/webtech-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Dloader.main=htwwebtech.webtech.WebtechApplication", "-jar", "/app.jar"]
#'