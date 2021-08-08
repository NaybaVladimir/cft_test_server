FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/cft_test-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
RUN mkdir /opt/app/tmp
COPY /tmp /opt/app/tmp
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]