package redis_20200114;

import redis.clients.jedis.Jedis;

/**
 * redis界helloworld
 *
 * new时候，没有异常，ping（set/get）有异常抛出。
 * ByteArrayOutputStream writeObject
 */
public class RedisLo {
	Jedis jedis;

	public void connect() {
		jedis = new Jedis("localhost");

		System.out.println("连接成功");
		// 查看服务是否运行
		System.out.println("服务正在运行: " + jedis.ping());
	}

	public void set(String key, String value) {
		// 设置 redis 字符串数据
		jedis.set(key, value);
		// 获取数据并输出
		System.out.println("redis 存储的字符串为: " + key + ":" + value);
	}
	
	public void set(String key, byte []value) {
		// 设置 redis 字符串数据
		jedis.set(key.getBytes(), value);
		// 获取数据并输出
		System.out.println("redis 存储的字符串为: " + key + ":" + value);
	}

	public String get(String key) {
		// 获取存储的数据
		String value = jedis.get(key);
		System.out.println("redis 存储的字符串为: " + key + ":" + value);
		return value;
	}
	
	public byte[] get(byte[] key) {
		// 获取存储的数据
		byte[] value = jedis.get(key);
		System.out.println("redis 存储的字符串为: " + key + ":" + value);
		return value;
	}

	public static void main(String[] args) {
		RedisLo redislo = new RedisLo();
		
		redislo.connect();
		//redislo.set("key", "value");
		
		redislo.get("key");
	}

}
