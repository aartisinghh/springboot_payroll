#Base 
FROM openjdk:18
LABEL maintainer=springboot_payroll.net
ADD target/springboot_payroll-0.0.1-SNAPSHOT.jar springboot_payroll.jar
ENTRYPOINT ["java", "-jar", "springboot_payroll.jar"]