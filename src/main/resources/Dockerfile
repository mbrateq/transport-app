FROM openjdk:11
VOLUME /transport-app
#COPY releases.v2/*.jar app.jar
COPY *.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
#BUILD APP - RELEASE