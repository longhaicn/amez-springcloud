#!/usr/bin/env bash
projectapp=/root/.jenkins/workspace/delete-all/cloud-app
yml=src/main/resources/deploy/yml/pro.yml
kubectl delete -f ${projectapp}/app-api/${yml}
kubectl delete -f ${projectapp}/app-financial/${yml}
kubectl delete -f ${projectapp}/app-im/${yml}
kubectl delete -f ${projectapp}/app-learn/${yml}
kubectl delete -f ${projectapp}/app-member/${yml}
kubectl delete -f ${projectapp}/app-order/${yml}
kubectl delete -f ${projectapp}/app-pay/${yml}
kubectl delete -f ${projectapp}/app-product/${yml}
kubectl delete -f ${projectapp}/app-rule/${yml}
kubectl delete -f ${projectapp}/app-store/${yml}
kubectl delete -f ${projectapp}/app-system/${yml}
kubectl delete -f ${projectapp}/app-umeng/${yml}
projectpc=/root/.jenkins/workspace/delete-all/cloud-pc
kubectl delete -f ${projectpc}/pc-api/${yml}
kubectl delete -f ${projectpc}/pc-financial/${yml}
kubectl delete -f ${projectpc}/pc-im/${yml}
kubectl delete -f ${projectpc}/pc-learn/${yml}
kubectl delete -f ${projectpc}/pc-member/${yml}
kubectl delete -f ${projectpc}/pc-order/${yml}
kubectl delete -f ${projectpc}/pc-crontab/${yml}
kubectl delete -f ${projectpc}/pc-product/${yml}
kubectl delete -f ${projectpc}/pc-store/${yml}
kubectl delete -f ${projectpc}/pc-system/${yml}
kubectl delete -f ${projectpc}/pc-umeng/${yml}
projectcom=/root/.jenkins/workspace/delete-all/common
kubectl delete -f ${projectcom}/eureka-server-ha-1/${yml}
kubectl delete -f ${projectcom}/eureka-server-ha-2/${yml}
kubectl delete -f ${projectcom}/config-server/${yml}
kubectl delete -f ${projectcom}/admin-server/${yml}
kubectl delete -f /root/.jenkins/workspace/delete-all/tx-manager/${yml}
kubectl delete -f ${projectcom}/gateway-server/${yml}
