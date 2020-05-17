FROM openjdk:8-jre-alpine
VOLUME /tmp
ADD target/*.jar app.jar
ENV PORT 3030
EXPOSE 3030 80 443 22 8888
ENV JAVA_OPTS: ""
ENTRYPOINT [ "sh", "-c", "java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8888 -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]