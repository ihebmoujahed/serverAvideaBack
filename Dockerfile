FROM ubuntu:latest AS build
VOLUME /tmp
COPY --from=build /build/libs/avidea-1.jar app.jar
ENTRYPOINT ["java","-jar","/ascii-art-generator.jar"]
