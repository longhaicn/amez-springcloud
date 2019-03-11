#!/usr/bin/env bash
project=/root/.jenkins/workspace/start-pc/cloud-pc
yml=src/main/resources/deploy/yml/pro.yml
kubectl apply -f ${project}/pc-api/${yml}
kubectl apply -f ${project}/pc-financial/${yml}
kubectl apply -f ${project}/pc-im/${yml}
kubectl apply -f ${project}/pc-learn/${yml}
kubectl apply -f ${project}/pc-member/${yml}
kubectl apply -f ${project}/pc-order/${yml}
kubectl apply -f ${project}/pc-crontab/${yml}
kubectl apply -f ${project}/pc-product/${yml}
kubectl apply -f ${project}/pc-store/${yml}
kubectl apply -f ${project}/pc-system/${yml}
kubectl apply -f ${project}/pc-umeng/${yml}
