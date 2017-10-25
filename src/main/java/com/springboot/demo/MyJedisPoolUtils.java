package com.springboot.demo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class MyJedisPoolUtils {

    private static JedisPool pool ;

    private static JedisPoolConfig config = new JedisPoolConfig();

    static{
        config.setMaxTotal(100);
        config.setMinIdle(5);
        config.setTestOnBorrow(true);
        config.setMaxIdle(10);
        config.setLifo(true);

    }

    private MyJedisPoolUtils(){

    }

    public static Jedis getJedisFromJedisPool(){
        synchronized ("AA"){
            if(pool != null){
                pool = new JedisPool("127.0.0.1",6379);
            }
        }
    }

}
