package com.cttic.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDubboConsumerApplicationTests {

	@Autowired
	ComputeService computeService;

	@Test
	public void contextLoads() {

		System.out.println("Dubbo消费结果为：。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
		System.out.println("Dubbo消费结果为：。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。"+computeService.add(100, 200));
		Assert.assertEquals("compute-service:add", new Integer(3), computeService.add(1, 2));

	}

}
