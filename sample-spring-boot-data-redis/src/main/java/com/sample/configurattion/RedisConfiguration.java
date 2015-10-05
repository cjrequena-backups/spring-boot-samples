package com.sample.configurattion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

@Configuration
public class RedisConfiguration<T> {

	@Autowired
	private JedisConnectionFactory jedisConnectionFactory;

	@Bean
	public StringRedisSerializer stringRedisSerializer() {
		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		return stringRedisSerializer;
	}

	@Bean
	public RedisTemplate<String, T> redisTemplate() {
		RedisTemplate<String, T> redisTemplate = new RedisTemplate<String, T>();
		redisTemplate = new RedisTemplate<String, T>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}

	@Bean
	public JedisConnectionFactory jedisConnFactory() {
		JedisConnectionFactory jedisConnFactory = new JedisConnectionFactory();
		return jedisConnFactory;
	}
}
