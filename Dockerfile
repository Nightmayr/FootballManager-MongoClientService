FROM openjdk
ADD target/FootballManager-MongoClientService-0.0.1-SNAPSHOT.jar FootballManager-MongoClientService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/FootballManager-MongoClientService-0.0.1-SNAPSHOT.jar"]
EXPOSE 8085
