FROM openjdk:8
COPY /target/profile-service.jar profile-service.jar
EXPOSE 9192
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","profile-service.jar"]