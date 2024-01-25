FROM openjdk:latest
COPY ./"target/DevOpsCW_Gp5-1.0-SNAPSHOT-jar-with-dependencies.jar" /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "DevOpsCW_Gp5-1.0-SNAPSHOT-jar-with-dependencies.jar"]