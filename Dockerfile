FROM openjdk:8
EXPOSE 8089
ADD target/testproject-docker-jenkins.jar testproject-docker-jenkins.jar
ENTRYPOINT ["java", "-jar", "/testproject-docker-jenkins.jar"] 