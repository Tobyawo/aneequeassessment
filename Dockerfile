FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/aneequeassessment-0.0.1-SNAPSHOT.jar aneequeassessment-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "aneequeassessment-0.0.1-SNAPSHOT.jar"]