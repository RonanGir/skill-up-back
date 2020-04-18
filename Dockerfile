###########################
# Stage 1 : Build project #
###########################

FROM maven:3.6.3-jdk-8 AS build  
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package -P prod -Dmaven.test.skip=true

############################
# Stage 2 : Launch project #
############################

FROM openjdk:8
COPY --from=build usr/src/app/target/skillup-0.0.1-SNAPSHOT.jar /usr/local/lib/skillup.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/skillup.jar"]