FROM openjdk:latest
COPY ./target/DevOpsCW_Gp5.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "DevOpsCW_Gp5.jar", "db:3306", "30000"]