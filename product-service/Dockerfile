FROM openjdk:8-jre-alpine
VOLUME /tmp
ADD target/*.jar app.jar
ENV PORT 2020
EXPOSE 2020
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]