FROM triplesic/minimal-openjdk8:latest
ADD target/tdd.example-0.0.1-SNAPSHOT.jar app.jar

RUN mkdir -p /config

ENTRYPOINT ["java", "-jar", "app.jar" , "--spring.config.location=/config/application.properties"]
EXPOSE 443 8080 80