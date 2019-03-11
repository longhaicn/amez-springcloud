package com.union.aimei.order.test;


import com.union.aimei.order.controller.OrderBaseController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(value = "classpath:bootstrap.yml")
public class OrderBaseTest {

    @Resource
    private OrderBaseController orderBaseController;


}
