FROM openjdk:latest
COPY ./"target/DevOps_Gp5-0.1.0.2(0.1-alpha-2)-jar-with-dependencies.jar" /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "DevOps_Gp5-0.1.0.2(0.1-alpha-2)-jar-with-dependencies.jar"]