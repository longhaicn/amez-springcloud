FROM java:8
VOLUME /tmp
ADD appApi.jar app.jar
RUN bash -c 'touch /app.jar'
RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
&& echo 'Asia/Shanghai' >/etc/timezone
EXPOSE 8080
ENTRYPOINT ["java","-Xmx3000m","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
