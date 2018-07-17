package com.taotao.rest.component;

public interface Jedisimp {
	public String get(String key);

	public String set(String key, String value);

	public Long hset(String key, String item, String value);

	public String hget(String key, String item);

	public Long incr(String key);

	public Long decr(String key);

	public Long hdel(String key,String item);

	public Long expire(String key, int sencond);

}
