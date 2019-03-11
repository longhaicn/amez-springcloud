#!/usr/bin/env bash
project=/root/.jenkins/workspace/deploy
yml=src/main/resources/deploy
#eureka
cd ${project}/common/eureka-server-ha-1/${yml}
chmod a+x pro.sh
./pro.sh push
#eureka
cd ${project}/common/eureka-server-ha-2/${yml}
chmod a+x pro.sh
./pro.sh push
#config
cd ${project}/common/config-server/${yml}
chmod a+x pro.sh
./pro.sh push
#tx
cd ${project}/tx-manager/${yml}
chmod a+x pro.sh
./pro.sh push
#gateway
cd ${project}/common/gateway-server/${yml}
chmod a+x pro.sh
./pro.sh push
#admin-server
cd ${project}/common/admin-server/${yml}
chmod a+x pro.sh
./pro.sh push
#umeng
cd ${project}/cloud-pc/pc-umeng/${yml}
chmod a+x pro.sh
./pro.sh push
#system
cd ${project}/cloud-pc/pc-system/${yml}
chmod a+x pro.sh
./pro.sh push
#店铺
cd ${project}/cloud-pc/pc-store/${yml}
chmod a+x pro.sh
./pro.sh push
#product
cd ${project}/cloud-pc/pc-product/${yml}
chmod a+x pro.sh
./pro.sh push
#order
cd ${project}/cloud-pc/pc-order/${yml}
chmod a+x pro.sh
./pro.sh push
#member
cd ${project}/cloud-pc/pc-member/${yml}
chmod a+x pro.sh
./pro.sh push
#learn
cd ${project}/cloud-pc/pc-learn/${yml}
chmod a+x pro.sh
./pro.sh push
#im
cd ${project}/cloud-pc/pc-im/${yml}
chmod a+x pro.sh
./pro.sh push
#financial
cd ${project}/cloud-pc/pc-financial/${yml}
chmod a+x pro.sh
./pro.sh push
#crontab
cd ${project}/cloud-pc/pc-crontab/${yml}
chmod a+x pro.sh
./pro.sh push
#api
cd ${project}/cloud-pc/pc-api/${yml}
chmod a+x pro.sh
./pro.sh push
#end pc
#umeng
cd ${project}/cloud-app/app-umeng/${yml}
chmod a+x pro.sh
./pro.sh push
#system
cd ${project}/cloud-app/app-system/${yml}
chmod a+x pro.sh
./pro.sh push
#店铺
cd ${project}/cloud-app/app-store/${yml}
chmod a+x pro.sh
./pro.sh push
#rule
cd ${project}/cloud-app/app-rule/${yml}
chmod a+x pro.sh
./pro.sh push
#product
cd ${project}/cloud-app/app-product/${yml}
chmod a+x pro.sh
./pro.sh push
#pay
cd ${project}/cloud-app/app-pay/${yml}
chmod a+x pro.sh
./pro.sh push
#order
cd ${project}/cloud-app/app-order/${yml}
chmod a+x pro.sh
./pro.sh push
#member
cd ${project}/cloud-app/app-member/${yml}
chmod a+x pro.sh
./pro.sh push
#learn
cd ${project}/cloud-app/app-learn/${yml}
chmod a+x pro.sh
./pro.sh push
#im
cd ${project}/cloud-app/app-im/${yml}
chmod a+x pro.sh
./pro.sh push
#financial
cd ${project}/cloud-app/app-financial/${yml}
chmod a+x pro.sh
./pro.sh push
#api
cd ${project}/cloud-app/app-api/${yml}
chmod a+x pro.sh
./pro.sh push
#end pc