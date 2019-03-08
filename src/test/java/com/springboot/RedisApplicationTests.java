package com.springboot;

import com.springboot.model.entity.Employee;
import com.springboot.model.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;

	@Test
	public void contextLoads() {
	}

	@Autowired
	StringRedisTemplate stringRedisTemplate; //操作的key-value都是字符串

	@Autowired
	RedisTemplate redisTemplate; //key-value都是对象

	@Test
	public void test1(){
		ValueOperations<String, String> value = stringRedisTemplate.opsForValue();
		value.set("name","jack",10, TimeUnit.DAYS);

	}

	@Test
	public void test2(){
		Employee employee = employeeMapper.entityById(4);
		redisTemplate.opsForValue().set("test2",employee);
	}

}
