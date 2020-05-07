FROM openjdk:8-jre-alpine
VOLUME /tmp
ADD target/*.jar app.jar
ENV PORT 1010
EXPOSE 1010
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]