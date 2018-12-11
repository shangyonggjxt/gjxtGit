package com.cttic.service;

import java.io.File;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.collections.map.HashedMap;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.cttic.service.domain.Teacher1;
import com.cttic.service.domain.Teacher1Repository;
import com.cttic.service.mq.Sender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CtticSpringboot2ApplicationTests {

	@Autowired
	private Teacher1Repository teacher1Repository;

	@Autowired
	private CacheManager cacheManager;

	// 注入邮件依赖
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private VelocityEngine velocityEngine;

	@Autowired
	private Sender sender;

	@Test
	public void contextLoads() throws MessagingException, InterruptedException {

//		Teacher1 teacher1 = teacher1Repository.findByName("乔峰");
//		System.out.println("第一次查询为：" + teacher1.getAge());
//		
//		
//		Teacher1 teacher3=new Teacher1();
//		teacher3.setId(16);
//		teacher3.setName("乔峰");
//		teacher3.setAge(35);
//		teacher1Repository.save(teacher3);
//		
//		
//		
//		Teacher1 teacher2=teacher1Repository.findByName("乔峰");
//		System.out.println("第二次查询为："+teacher2.getAge());

		// 发送一个简单的邮件
//		SimpleMailMessage message=new SimpleMailMessage();
//		message.setFrom("619563988@qq.com");
//		message.setTo("shangyong808@126.com");
//		message.setSubject("主题：测试邮件发送，简单发送");
//		message.setText("测试邮件简单发送的内容");
//		javaMailSender.send(message);

		// 发送一个带有附件的邮件
//		MimeMessage message = javaMailSender.createMimeMessage();
//
//		MimeMessageHelper helper = new MimeMessageHelper(message, true);
//		helper.setFrom("619563988@qq.com");
//		helper.setTo("shangyong808@126.com");
//		helper.setSubject("主题：测试邮件发送，带有附件的发送");
//		// 正文2种方式,发送附件
////		helper.setText("测试邮件简单发送的内容，带有附件");
//		helper.setText("<html><body>测试简单的邮件发送，插入附件<img src=\"cid:tupian\"></body></html>", true);
//
//		FileSystemResource file = new FileSystemResource(new File("C:\\Users\\shangyong\\Downloads\\gjxt.jpg"));
//		// 附件插入方式
////		helper.addAttachment("申报表.docx", file);
//		helper.addInline("tupian", file);
//		javaMailSender.send(message);

		// 发送模板邮件
//		MimeMessage message = javaMailSender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(message, true);
//		helper.setFrom("619563988@qq.com");
//		helper.setTo("shangyong808@126.com");
//		helper.setSubject("主题：测试邮件发送，发送模板邮件");
//		Map<String, Object> model = new HashedMap();
//		model.put("username", "学员们");
//		String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "template.vm", model);
//		helper.setText(text, true);
//
//		javaMailSender.send(message);

		// 测试发送数据到mq
		for (int i = 0; i < 100; i++) {
			sender.send();
			synchronized (this) {
				this.wait(1000);
			}

		}

	}

}
