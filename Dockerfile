FROM openjdk:17-ea-3-jdk-slim

WORKDIR /api

ARG JAR_FILE

COPY target/${JAR_FILE} /api/erp-application-api.jar
COPY wait-for-it.sh /wait-for-it.sh

RUN chmod +x /wait-for-it.sh

EXPOSE 8080

CMD ["java","-jar","erp-application-api.jar"]