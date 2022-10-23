FROM openjdk:11-jre-alpine
WORKDIR /spring-app
ARG JAR_FILE=/1.0-SNAPSHOT/*.jar
RUN mvn clean install
RUN apt-get install wget
RUN wget --user=admin --password=zeineb   http://192.168.0.16:8081/repositories/maven-snapshots/com/esprit/examen/tpAchatProject/1.0-SNAPSHOT/tpAchatProject-1.0-20221023.001100-1.jar
COPY ${JAR_FILE} achat.jar
ENTRYPOINT ["java","-jar","/achat.jar"]
EXPOSE 8082
//FROM maven:3.8.2-jdk-8
//WORKDIR /spring-app
//COPY . .
//RUN mvn clean install
//CMD mvn spring-boot:run
