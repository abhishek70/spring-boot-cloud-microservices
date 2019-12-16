FROM openjdk:8
COPY /target/auth-service.jar auth-service.jar
EXPOSE 9191
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","auth-service.jar"]