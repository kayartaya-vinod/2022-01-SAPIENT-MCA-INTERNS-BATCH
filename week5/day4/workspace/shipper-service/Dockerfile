# this file is used for building an image for a app
# 1. specify the base os
# 2. install additional software (like java, mysql)
# 3. add files from local filesystem to the future container filesystem (such as shipper-service-0.0.1-SNAPSHOT.jar)
# 4. specify (if any) environment variables
# 5. specify the ENTRYPOINT command (this is the command that runs when you create and start the container from the image)
# 6. specify additional command line arguments (if any)

# steps 1 & 2
FROM adoptopenjdk/openjdk11:alpine
# change directory to a new working directory (gets created if already doesn't exist) 
WORKDIR /vinod/apps
COPY ./target/shipper-service-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8080
ENTRYPOINT java -jar ./app.jar