VOLUME /tmp
COPY target/avidea-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app/avidea.jar"]
