#!/usr/bin/env bash
project=/root/.jenkins/workspace/start-base/common
yml=src/main/resources/deploy/yml/image.yml
kubectl apply -f ${project}/eureka-server-ha-1/${yml}
sleep 20s
kubectl apply -f ${project}/eureka-server-ha-2/${yml}
sleep 30s
kubectl apply -f ${project}/config-server/${yml}
sleep 1m
kubectl apply -f /root/.jenkins/workspace/start-base/tx-manager/${yml}
sleep 1m
kubectl apply -f ${project}/gateway-server/${yml}
kubectl apply -f ${project}/admin-server/${yml}
