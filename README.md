# spring-netflix-stack-playground
A simple guestbook application implemented with the Spring-Boot and the Spring-Netflix-Stack (Zuul, Hystrix, Eureka, Feign).

All applications can be build with Maven. Run 
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

Link to Hystrix Dashboard:
http://localhost:8081/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8081%2Fhystrix.stream

# Docker setup
To build docker images for all apps, run the following Maven command from the root directory of the project:
```
mvn package docker:build
```
To start all images as docker containers, use the docker-compose.yml file in the root directory from the command line:
```
docker-compose up -d
```
When started, the application is available under the following URL (change the IP to the one you run your docker on)
```
http://192.168.99.100:8000/  (Guestbook)
http://192.168.99.100:8761/  (Eureka Registry)
```

The docker-maven plugin is also registered in the maven install-phase. To build all applications AND build all docker images execute
```
mvn install
```
from the root directory of the project.


