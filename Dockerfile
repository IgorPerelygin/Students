FROM openjdk:11-jre-slim
COPY target/students.war /user/app/
WORKDIR /user/app
EXPOSE 8080
CMD ["java", "-jar", "/students.jar"]