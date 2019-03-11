#!/usr/bin/env bash
project=/root/.jenkins/workspace/delete-pc-image/cloud-pc
yml=src/main/resources/deploy/yml/image.yml
kubectl delete -f ${project}/pc-api/${yml}
kubectl delete -f ${project}/pc-financial/${yml}
kubectl delete -f ${project}/pc-im/${yml}
kubectl delete -f ${project}/pc-learn/${yml}
kubectl delete -f ${project}/pc-member/${yml}
kubectl delete -f ${project}/pc-order/${yml}
kubectl delete -f ${project}/pc-crontab/${yml}
kubectl delete -f ${project}/pc-product/${yml}
kubectl delete -f ${project}/pc-store/${yml}
kubectl delete -f ${project}/pc-system/${yml}
kubectl delete -f ${project}/pc-umeng/${yml}
