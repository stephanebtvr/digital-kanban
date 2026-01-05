FROM eclipse-temurin:21-jdk-alpine
RUN apk add --no-cache curl
VOLUME /tmp
COPY target/*.jar app.jar
# On peut ajouter des paramètres JVM pour optimiser la mémoire du Gateway (réactif)
ENTRYPOINT ["java", "-Xmx256m", "-jar", "/app.jar"]