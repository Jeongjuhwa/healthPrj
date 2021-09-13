FROM openjdk:11

EXPOSE 8080

ADD out/artifacts/healthPrj_jar/healthPrj_jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]