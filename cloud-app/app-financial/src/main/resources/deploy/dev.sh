#!/usr/bin/env bash



#jenkins任务名称
job_name=app-financial
#所属模块
belong=financial
#jar包名称
jar_name=appFinancial
#端名称(app端还是pc端)
point_name=cloud-app





#模块名称
module_name=${job_name}
#容器名称
container_name=beautybond_${module_name}
#镜像名称
image_name=${module_name}
#重现打包依赖包
cd /var/lib/jenkins/workspace/${job_name}/common
cd common-module
/usr/local/maven/apache-maven-3.3.9/bin/mvn clean
/usr/local/maven/apache-maven-3.3.9/bin/mvn install -Dmaven.test.skip=true
cd ../common-invoke-amez
/usr/local/maven/apache-maven-3.3.9/bin/mvn clean
/usr/local/maven/apache-maven-3.3.9/bin/mvn install -Dmaven.test.skip=true

#打包编译应用程序包
cd /var/lib/jenkins/workspace/${job_name}/${point_name}/${module_name}
/usr/local/maven/apache-maven-3.3.9/bin/mvn clean
/usr/local/maven/apache-maven-3.3.9/bin/mvn install -Dmaven.test.skip=true -Ptest
cd target
mv ${jar_name}.jar -f /usr/local/beautybond_application/${belong}/${module_name}/
docker rm -f ${container_name} || true
docker rmi -f ${image_name} || true
cd /usr/local/beautybond_application/${belong}/${module_name}/
docker build -t ${image_name} .
docker run -d  --net=host --name=${container_name} -m 800M --restart=always  ${image_name}
