FROM java:8
VOLUME /tmp/spring-boot2-dockerfile
ADD logon-0.0.1.jar spring-boot2-dockerfile.jar
RUN bash -c 'touch /spring-boot2-dockerfile.jar'
RUN echo "Etc/CST" > /etc/timezone
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-boot2-dockerfile.jar"]
