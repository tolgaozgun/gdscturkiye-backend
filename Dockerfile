FROM openjdk:17
ADD target/gdscturkiye.jar gdscturkiye.jar
ENTRYPOINT ["java","-jar","/gdscturkiye.jar"]