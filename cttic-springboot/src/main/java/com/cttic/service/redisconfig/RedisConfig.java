package com.cttic.service.redisconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.cttic.service.domain.Teacher;
import com.cttic.service.domain.User;

@Configuration
public class RedisConfig {
	@Bean
	public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, User> template = new RedisTemplate<String, User>();
		template.setConnectionFactory(factory);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new RedisObjectSerializer());
		return template;
	}

	@Bean
	public RedisTemplate<String, Teacher> redisTemplateTeacher(RedisConnectionFactory factory) {
		RedisTemplate<String, Teacher> template = new RedisTemplate<String, Teacher>();
		template.setConnectionFactory(factory);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new RedisObjectSerializer());
		return template;
	}

}
