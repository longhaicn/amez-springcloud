#!/usr/bin/env bash
project=/root/.jenkins/workspace/push
yml=src/main/resources/deploy
cd ${project}/common/common-invoke-amez
mvn install
cd ${project}/common/common-module
mvn install
cd ${project}/common/common-feign
mvn install
#eureka
cd ${project}/common/eureka-server-ha-1
mvn clean package -Pk8s docker:build -DpushImage
#eureka
cd ${project}/common/eureka-server-ha-2
mvn clean package -Pk8s docker:build -DpushImage
#config
cd ${project}/common/config-server
mvn clean package -Pk8s docker:build -DpushImage
#tx
cd ${project}/tx-manager
mvn clean package -Pk8s docker:build -DpushImage
#gateway
cd ${project}/common/gateway-server
mvn clean package -Pk8s docker:build -DpushImage
#admin-server
cd ${project}/common/admin-server
mvn clean package -Pk8s docker:build -DpushImage
#umeng
cd ${project}/cloud-pc/pc-umeng
mvn clean package -Pk8s docker:build -DpushImage
#system
cd ${project}/cloud-pc/pc-system
mvn clean package -Pk8s docker:build -DpushImage
#店铺
cd ${project}/cloud-pc/pc-store
mvn clean package -Pk8s docker:build -DpushImage
#product
cd ${project}/cloud-pc/pc-product
mvn clean package -Pk8s docker:build -DpushImage
#order
cd ${project}/cloud-pc/pc-order
mvn clean package -Pk8s docker:build -DpushImage
#member
cd ${project}/cloud-pc/pc-member
mvn clean package -Pk8s docker:build -DpushImage
#learn
cd ${project}/cloud-pc/pc-learn
mvn clean package -Pk8s docker:build -DpushImage
#im
cd ${project}/cloud-pc/pc-im
mvn clean package -Pk8s docker:build -DpushImage
#financial
cd ${project}/cloud-pc/pc-financial
mvn clean package -Pk8s docker:build -DpushImage
#crontab
cd ${project}/cloud-pc/pc-crontab
mvn clean package -Pk8s docker:build -DpushImage
#api
cd ${project}/cloud-pc/pc-api/
mvn clean package -Pk8s docker:build -DpushImage
#end pc
#umeng
cd ${project}/cloud-app/app-umeng
mvn clean package -Pk8s docker:build -DpushImage
#system
cd ${project}/cloud-app/app-system
mvn clean package -Pk8s docker:build -DpushImage
#店铺
cd ${project}/cloud-app/app-store
mvn clean package -Pk8s docker:build -DpushImage
#rule
cd ${project}/cloud-app/app-rule
mvn clean package -Pk8s docker:build -DpushImage
#product
cd ${project}/cloud-app/app-product
mvn clean package -Pk8s docker:build -DpushImage
#pay
cd ${project}/cloud-app/app-pay
mvn clean package -Pk8s docker:build -DpushImage
#order
cd ${project}/cloud-app/app-order
mvn clean package -Pk8s docker:build -DpushImage
#member
cd ${project}/cloud-app/app-member
mvn clean package -Pk8s docker:build -DpushImage
#learn
cd ${project}/cloud-app/app-learn
mvn clean package -Pk8s docker:build -DpushImage
#im
cd ${project}/cloud-app/app-im
mvn clean package -Pk8s docker:build -DpushImage
#financial
cd ${project}/cloud-app/app-financial
mvn clean package -Pk8s docker:build -DpushImage
#api
cd ${project}/cloud-app/app-api/
mvn clean package -Pk8s docker:build -DpushImage
#end pc
echo "successful"