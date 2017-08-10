# spring-netflix-stack-playground
Demo application using the Netflix stack (Zuul, Hystrix, Eureka, Feign)

All applications are build with Spring-Boot and Maven. Run 
```
mvn install 
```
in each folder to create a fat-jar. 
Execute the jar with 
```
java -jar [name of jar]"
```

The following applications are available:

- guestbook-backend : Backend REST-Service for GuestbookEntries
- guestbook-frontend: Thymeleaf page + Spring MVC 
- guestbook-discovery: Eureka discovery server
- guestbook-proxy: Zuul proxy server
- guestbook-mail: mail web service build on spring mail

Check out all apps and start all fat-jars to run the complete app.
guestbook-discovery must be started first.

Link to App (via proxy):
http://localhost:8000/

Link to Eureka Registry:
http://localhost:8761/

# Docker setup
To build docker images for all apps, run the following Maven command from the root directory of the project:
```
mvn package docker:build
```

To start all images, use the docker-compose.yml file in the root directory
```
docker-compose up -d
```
The docker-maven plugin is also registered in the install-phase of the maven build. To build all applications AND build all docker images execute
´´´
mvn install
´´´
from the root directory of the project.


