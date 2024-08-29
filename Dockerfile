FROM ubuntu:latest AS build
VOLUME /tmp
COPY . .
ENTRYPOINT ["java","-jar","/ascii-art-generator.jar"]
