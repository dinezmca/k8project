#FROM maven:3.5.2-jdk-8-alpine as MAVEN_BUILD
#MAINTAINER TAMIZHINI
#COPY pom.xml /build/
#COPY src /build/src/
#WORKDIR /build/
#RUN mvn package
FROM openjdk:8-jre-alpine
VOLUME /tmp
ADD target/*.jar app.jar
ENV PORT 8761
EXPOSE 8761
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
