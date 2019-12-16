FROM openjdk:8
COPY /target/eureka-service.jar eureka-service.jar
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","eureka-service.jar"]