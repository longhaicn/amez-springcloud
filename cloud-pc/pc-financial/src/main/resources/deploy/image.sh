#!/usr/bin/env bash
#jenkins应用名称
project=$1
#应用名称
app=pc-financial
#模块名称
module=cloud-pc
#jenkisn代码目录
cd /root/.jenkins/workspace/${project}/common/common-invoke-amez
mvn install
cd /root/.jenkins/workspace/${project}/common/common-module
mvn install
cd /root/.jenkins/workspace/${project}/common/common-feign
mvn install
cd /root/.jenkins/workspace/${project}/${module}/${app}
#maven打包和推镜像
mvn clean package -Pimagek8s docker:build -DpushImage
#yml目录
cd src/main/resources/deploy/yml
#部署
kubectl apply -f image.yml