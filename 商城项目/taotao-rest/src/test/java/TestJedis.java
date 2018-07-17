import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taotao.rest.component.Jedisimp;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class TestJedis {
	@Test
	public void testSingleon() throws Exception {
		Jedis jedis = new Jedis("192.168.25.130", 6379);
		jedis.set("wz", "234");
		String s = jedis.get("wz");
         jedis.close();
		System.out.println(s);
	}

	@Test
	public void testJedisPool() throws Exception {
		JedisPool jedisPool = new JedisPool("192.168.25.130", 6379);
		Jedis jedis = jedisPool.getResource();
		String s = jedis.set("wz","123");
		System.out.println(s);
		jedis.close();
		jedisPool.close();
	}

	@Test
	public void testJedisCluster() throws Exception {
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.25.130", 7001));
		nodes.add(new HostAndPort("192.168.25.130", 7002));
		nodes.add(new HostAndPort("192.168.25.130", 7003));
		nodes.add(new HostAndPort("192.168.25.130", 7004));
		nodes.add(new HostAndPort("192.168.25.130", 7005));
		nodes.add(new HostAndPort("192.168.25.130", 7006));
		JedisCluster jedisCluster = new JedisCluster(nodes);
		jedisCluster.set("qw", "13");
		jedisCluster.set("qw2", "14");
		jedisCluster.set("qw3", "134");
		String name = jedisCluster.get("qw");

		jedisCluster.close();

	}

	@Test
	public void testSpringredis() throws Exception {
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
	    Jedisimp simp=app.getBean(Jedisimp.class);
	    simp.set("wz2", "1405");
	    
	    System.out.println( simp.get("wz"));
	
	
	}
}
