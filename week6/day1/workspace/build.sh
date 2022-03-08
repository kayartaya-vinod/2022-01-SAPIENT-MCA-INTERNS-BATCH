cd ./department-service
mvn clean package -DskipTests
cd ..
cd ./employee-service
mvn clean package -DskipTests
cd ..
cd ./eureka-service
mvn clean package -DskipTests
cd ..

cd ./gateway-service
mvn clean package -DskipTests
cd ..

