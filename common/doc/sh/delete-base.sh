#!/usr/bin/env bash
project=/root/.jenkins/workspace/delete-base/common
yml=src/main/resources/deploy/yml/pro.yml
kubectl delete -f ${project}/eureka-server-ha-1/${yml}
kubectl delete -f ${project}/eureka-server-ha-2/${yml}
kubectl delete -f ${project}/config-server/${yml}
kubectl delete -f ${project}/admin-server/${yml}
kubectl delete -f /root/.jenkins/workspace/delete-base/tx-manager/${yml}
kubectl delete -f ${project}/gateway-server/${yml}
