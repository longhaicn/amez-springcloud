#!/usr/bin/env bash
project=/root/.jenkins/workspace/start-app/cloud-app
yml=src/main/resources/deploy/yml/pro.yml
kubectl apply -f ${project}/app-api/${yml}
kubectl apply -f ${project}/app-financial/${yml}
kubectl apply -f ${project}/app-im/${yml}
kubectl apply -f ${project}/app-learn/${yml}
kubectl apply -f ${project}/app-member/${yml}
kubectl apply -f ${project}/app-order/${yml}
kubectl apply -f ${project}/app-pay/${yml}
kubectl apply -f ${project}/app-product/${yml}
kubectl apply -f ${project}/app-rule/${yml}
kubectl apply -f ${project}/app-store/${yml}
kubectl apply -f ${project}/app-system/${yml}
kubectl apply -f ${project}/app-umeng/${yml}
