# spring-netflix-stack-playground
Demo application using the Netflix stack (Zuul, Hysterix, Eureka, Feign)

All applications are build with Spring-Boot and Maven. Run mvn install in each folder to create a fat-jar. Execute jat with "java -jar [name of jar]"

The following applications are available:

- guestbook-backend : Backend REST-Service for GuestbookEntries
- guestbook-frontend: Thymeleaf page + Spring MVC 
- guestbook-discovery: Eureka discovery application
- guestbook-proxy: Zuul Proxy server
- guestbook-mail: Mail web service 

Link to App:
http://localhost:8000/

Link to Eureka Registry:
http://localhost:8761/


