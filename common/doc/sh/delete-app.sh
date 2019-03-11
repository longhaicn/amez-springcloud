#!/usr/bin/env bash
project=/root/.jenkins/workspace/delete-app/cloud-app
yml=src/main/resources/deploy/yml/pro.yml
kubectl delete -f ${project}/app-api/${yml}
kubectl delete -f ${project}/app-financial/${yml}
kubectl delete -f ${project}/app-im/${yml}
kubectl delete -f ${project}/app-learn/${yml}
kubectl delete -f ${project}/app-member/${yml}
kubectl delete -f ${project}/app-order/${yml}
kubectl delete -f ${project}/app-pay/${yml}
kubectl delete -f ${project}/app-product/${yml}
kubectl delete -f ${project}/app-rule/${yml}
kubectl delete -f ${project}/app-store/${yml}
kubectl delete -f ${project}/app-system/${yml}
kubectl delete -f ${project}/app-umeng/${yml}
