package com.xl.gmall.manage;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xl.gmall.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageServiceApplicationTests {

     @Autowired
     RedisUtil redisUtil;
    @Test
    public void contextLoads() {
        Jedis jedis = redisUtil.getJedis();
        jedis.set("lo","lisi");

        String lo = jedis.get("lo");
        System.out.println("测试"+lo);
        System.out.println("测试"+jedis);
    }

}
