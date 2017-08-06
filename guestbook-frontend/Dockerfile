FROM java:8
VOLUME /tmp
ADD target/guestbook-frontend-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]