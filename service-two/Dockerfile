FROM openjdk:8u131-jdk-alpine

EXPOSE 8080

COPY target/service-two.jar /app/

ENTRYPOINT ["java", "-Xmx150m", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap","-Djava.security.egd=file:/dev/./urandom","-jar","/app/service-two.jar"]