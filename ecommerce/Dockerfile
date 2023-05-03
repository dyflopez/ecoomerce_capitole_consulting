FROM openjdk:11-jdk-slim
WORKDIR /app
RUN mkdir ./logs
COPY ./target/ecommerce-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "ecommerce-0.0.1-SNAPSHOT.jar"]