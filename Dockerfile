FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:zeineb -o achat.jar "http://192.168.0.16:8081/repositories/maven-snapshots/com/esprit/examen/tpAchatProject/1.0-SNAPSHOT/tpAchatProject-1.0-20221023.001100-1.jar" -L
CMD mvn spring-boot:run
EXPOSE 8082

