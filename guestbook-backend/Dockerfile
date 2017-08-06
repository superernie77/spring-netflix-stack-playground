FROM java:8
VOLUME /tmp
ADD target/guestbook-backend-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]