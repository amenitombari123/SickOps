FROM maven:3.8.2-jdk-8
RUN apt-get install curl
RUN curl -u admin:zeineb -o achat.jar "http://192.168.0.16:8081/repository/maven-releases/com/esprit/examen/tpAchatProject/1.0/tpAchatProject-1.0.jar" -L
CMD mvn spring-boot:run
EXPOSE 8082

