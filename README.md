# spring-netflix-stack-playground
Demo application using the Netflix stack (Zuul, Hysterix, Eureka, Feign)

All applications are build with Spring-Boot and Maven. Run mvn install in each folder to create a fat-jar. Execute jar with "java -jar [name of jar]"

Check out all apps and start all fat-jars to run the complete app.

The following applications are available:

- guestbook-backend : Backend REST-Service for GuestbookEntries
- guestbook-frontend: Thymeleaf page + Spring MVC 
- guestbook-discovery: Eureka discovery server
- guestbook-proxy: Zuul proxy server
- guestbook-mail: mail web service build on spring mail

Link to App (via proxy):
http://localhost:8000/

Link to Eureka Registry:
http://localhost:8761/


