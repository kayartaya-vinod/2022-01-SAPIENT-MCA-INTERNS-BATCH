FROM adoptopenjdk/openjdk11:alpine
WORKDIR /vinod/apps
COPY ./target/book-service-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8080
ENTRYPOINT java -jar ./app.jar