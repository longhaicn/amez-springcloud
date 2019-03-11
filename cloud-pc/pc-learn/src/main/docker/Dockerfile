FROM java:8
VOLUME /tmp
ADD pcLearn.jar app.jar
RUN bash -c 'touch /app.jar'
RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
&& echo 'Asia/Shanghai' >/etc/timezone
EXPOSE 8031
ENTRYPOINT ["java","-Xmx800m","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
