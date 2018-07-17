package com.taotao.rest.component;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Jedis;

public class JedisSingle implements Jedisimp {
	@Autowired
	private JedisPool jedisPool;

	@Override
	public String get(String key) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.get(key);
		return result;
	}

	@Override
	public String set(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.set(key, value);
		return result;
	}

	@Override
	public Long hset(String key, String item, String value) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hset(key, item, value);
		return result;
	}

	@Override
	public String hget(String key, String item) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.hget(key, item);
		return result;
	}

	@Override
	public Long incr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.incr(key);
		return result;
	}

	@Override
	public Long decr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.decr(key);
		return result;
	}



	@Override
	public Long expire(String key, int sencond) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.expire(key, sencond);
		return result;
	}

	@Override
	public Long hdel(String key, String item) {
		Jedis jedis = jedisPool.getResource();
		Long result = jedis.hdel(key,item);
		return result;
	}

}
