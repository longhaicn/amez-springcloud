#!/usr/bin/env bash

yml=src/main/resources/deploy/yml/image.yml
projectcom=/root/.jenkins/workspace/start-all/common
#base
kubectl apply -f ${projectcom}/eureka-server-ha-1/${yml}
sleep 30s
kubectl apply -f ${projectcom}/config-server/${yml}
sleep 2m
kubectl apply -f /root/.jenkins/workspace/start-all/tx-manager/${yml}
sleep 1m
kubectl apply -f ${projectcom}/gateway-server/${yml}
#kubectl apply -f ${projectcom}/admin-server/${yml}
#app
projectapp=/root/.jenkins/workspace/start-all/cloud-app
kubectl apply -f ${projectapp}/app-api/${yml}
kubectl apply -f ${projectapp}/app-financial/${yml}
kubectl apply -f ${projectapp}/app-im/${yml}
sleep 30s
kubectl apply -f ${projectapp}/app-learn/${yml}
kubectl apply -f ${projectapp}/app-member/${yml}
kubectl apply -f ${projectapp}/app-order/${yml}
sleep 30s
kubectl apply -f ${projectapp}/app-pay/${yml}
kubectl apply -f ${projectapp}/app-product/${yml}
kubectl apply -f ${projectapp}/app-rule/${yml}
sleep 30s
kubectl apply -f ${projectapp}/app-store/${yml}
kubectl apply -f ${projectapp}/app-system/${yml}
kubectl apply -f ${projectapp}/app-umeng/${yml}
sleep 3m
#pc
projectpc=/root/.jenkins/workspace/start-all/cloud-pc
kubectl apply -f ${projectpc}/pc-api/${yml}
kubectl apply -f ${projectpc}/pc-financial/${yml}
kubectl apply -f ${projectpc}/pc-im/${yml}
sleep 30s
kubectl apply -f ${projectpc}/pc-learn/${yml}
kubectl apply -f ${projectpc}/pc-member/${yml}
kubectl apply -f ${projectpc}/pc-order/${yml}
sleep 30s
kubectl apply -f ${projectpc}/pc-crontab/${yml}
kubectl apply -f ${projectpc}/pc-product/${yml}
kubectl apply -f ${projectpc}/pc-store/${yml}
sleep 30s
kubectl apply -f ${projectpc}/pc-system/${yml}
kubectl apply -f ${projectpc}/pc-umeng/${yml}
