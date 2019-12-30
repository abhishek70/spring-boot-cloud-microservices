# Auth Service

#### Resource services are protected with OAuth2 tokens provided by authentication/authorization service.
#### Auth service currently support ``Password Credentials`` grant type for single page app (front-end) and `Client Credentials` grant type for securing REST API (back-end) services.

##### Build and package spring boot app into a single executable jar file with maven
```
mvn clean install
```

##### Run spring boot app using maven
```
mvn spring-boot:run
```

##### UI
```
http://localhost:9191/
```