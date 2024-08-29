FROM ubuntu:latest AS build
VOLUME /tmp
COPY build/libs/avidea-1.jar app.jar
ENTRYPOINT ["java","-jar","/ascii-art-generator.jar"]
