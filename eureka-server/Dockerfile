FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/eurekaserver-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8761
ENV JAVA_OPTS="-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap  -XX:MaxRAMFraction=1 -XshowSettings:vm "
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]