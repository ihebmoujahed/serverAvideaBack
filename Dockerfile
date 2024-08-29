VOLUME /tmp
COPY target/avidea-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ascii-art-generator.jar"]
