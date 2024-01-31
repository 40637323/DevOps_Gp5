FROM openjdk:latest
COPY ./target/DevOpsCW_Gp5-0.1.0.2-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "DevOpsCW_Gp5-0.1.0.2-jar-with-dependencies.jar"]
