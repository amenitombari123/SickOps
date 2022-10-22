FROM openjdk:8-jre-alpine
WORKDIR /spring-app
ARG JAR_FILE=/1.0-SNAPSHOT/*.jar
RUN mvn clean install
RUN apt-get install wget
RUN wget --user=admin --password=zeineb   http://192.168.0.16:8081/repositories/maven-snapshots/com/esprit/examen/tpAchatProject/1.0-SNAPSHOT/tpAchatProject-1.0-20221018.073659-7.jar
COPY ${JAR_FILE} achat.jar
ENTRYPOINT ["java","-jar","/achat.jar"]
docker build jenkins -t
EXPOSE 8082

//CMD ["java","-jar","tpAchatProject-1.0-20221018.073659-7.jar"]
//ENTRYPOINT java -jar ,com/esprit/examen/tpAchatProject/1.0-SNAPSHOT/tpAchatProject-1.0-20221018.073659-7.jar
//RUN curl -u  http://192.168.0.16:8081/service/artifact/maven/redirect?r=maven-snapshots&g=com.esprit.examen&a=tpAchatProject&v=1.0&p=SNAPSHOT
//CMD mvn spring-boot:run
//RUN curl -u admin:zeineb -o com/esprit/examen/tpAchatProject/1.0-SNAPSHOT/tpAchatProject-1.0-20221018.073659-7.jar "nexus repository URL/com/esprit/examen/tpAchatProject/1.0-SNAPSHOT/tpAchatProject-1.0-20221018.073659-7.jar" -L



