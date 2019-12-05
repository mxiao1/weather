package com.xiao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class JedisClientSingle {

    @Autowired
    private JedisPool jedisPool;

    private int expiredTime = 24*60*60;

    public String get(String key){
        Jedis jedis = jedisPool.getResource();
        jedis.expire(key, 5);
        String string = jedis.get(key);
        jedis.close();
        return string;
    }
    public String set(String key, String value){
        Jedis jedis = jedisPool.getResource();
        String string = jedis.set(key, value);
        jedis.expire(key, 5);
        System.out.println("key :" + key);
        System.out.println("查看key的剩余生存时间" + jedis.ttl(key));
        jedis.close();
        return string;
    }


}
