FROM openjdk:8-jre-alpine
VOLUME /tmp
ADD target/*.jar app.jar
ENV PORT 4040
EXPOSE 4040 80 443 22 9999
ENV JAVA_OPTS: ""
ENTRYPOINT [ "sh", "-c", "java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=9999 -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]