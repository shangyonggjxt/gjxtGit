package com.cttic.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.cttic.service.domain.Student;
import com.cttic.service.domain.Teacher;
import com.cttic.service.domain.User;
import com.cttic.service.domain.primary.Teacher3Mapper;
import com.cttic.service.inter.TeacherServiceRepo;
import com.cttic.service.inter.UserServiceRepo;
import com.cttic.service.tasks.AsyncTask;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CtticSpringbootApplicationTests {

	@Autowired
	private Student student;

	@Autowired
	private UserServiceRepo userServiceRepo;

	@Autowired
	private TeacherServiceRepo teacherServiceRepo;

	@Autowired
	private Teacher3Mapper teacher3Mapper;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String, User> redisTemplate;

	@Autowired
	private RedisTemplate<String, Teacher> redisTemplateTeacher;

	// @Autowired
	// private User2Repository user2Repository;

	@Autowired
	private AsyncTask asyncTask;

	@Test
	public void contextLoads() throws InterruptedException, ExecutionException {

		// System.out.println(student.getName() + " || " + student.getAge());
		//
		// // userServiceRepo.createUser("乔峰", "降龙18掌");
		// userServiceRepo.deleteByName("乔峰");
		//
		// Teacher1 teacher = new Teacher1();
		// teacher.setName("乔峰");
		// teacher.setAge(25);
		// teacherServiceRepo.createTeacher(teacher);

		// List<Teacher> teachers = teacherServiceRepo.getTeacher();
		//
		// for (int i = 0; i < teachers.size(); i++) {
		// System.out.println(teachers.get(i).getName());
		// }

		// List<Teacher1> teachers = teacherServiceRepo.getPageContent(2, 2);
		// for (int i = 0; i < teachers.size(); i++) {
		// System.out.println(teachers.get(i).getName());
		// }

		// List<Teacher1> teachers = teacherServiceRepo.getNamePageContent(0, 2,
		// "李四");
		// for (int i = 0; i < teachers.size(); i++) {
		// System.out.println(teachers.get(i).getName());
		// }
		// MyBatis
		// teacher3Mapper.insert("张三", 11);
		// teacher3Mapper.insert("李四", 11);

		// Teacher3 teacher3 = new Teacher3();
		// teacher3.setName("王五");
		// teacher3.setAge(25);
		// teacher3.setId(1);
		// teacher3Mapper.updateByTeacher3(teacher3);

		// stringRedisTemplate.opsForValue().set("test", "test for redis");
		//
		// System.out.println(stringRedisTemplate.opsForValue().get("test"));

		// User user = new User();
		// user.setName("redis");
		// user.setAge(35);
		// redisTemplate.opsForValue().set(user.getName(), user);
		// System.out.println(redisTemplate.opsForValue().get(user.getName()).getName());
		//
		// Teacher teacher = new Teacher();
		// teacher.setName("teacher");
		// teacher.setAge(36);
		// redisTemplateTeacher.opsForValue().set(teacher.getName(), teacher);
		//
		// System.out.println(redisTemplateTeacher.opsForValue().get(teacher.getName()).getName());

		// User2 user2 = new User2();
		// user2.setId(1);
		// user2.setName("mongo db name");
		// user2.setAge(35);
		// user2Repository.save(user2);
		//
		// User2 u2 = user2Repository.findOne(1);
		//
		// System.out.println(u2.getName());

		// 测试回滚
		// Teacher1 teacher = new Teacher1();
		// teacher.setName("乔峰");
		// teacher.setAge(25);
		// teacherServiceRepo.createTeacher(teacher);

		// 不带返回值的异步回调
		// asyncTask.dealNoReturnTask();
		// try {
		// System.out.println("begin to deal other Task!");
		// Thread.sleep(10000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

		// 带返回值的异步回调
		// 用future.get()来获取异步任务的返回结果
		Future<String> future = asyncTask.dealHaveReturnTask();
		System.out.println("begin to deal other Task!");
		while (true) {
			if (future.isCancelled()) {
				System.out.println("deal async task is Cancelled");
				break;
			}
			if (future.isDone()) {
				System.out.println("deal async task is Done");
				System.out.println("return result is " + future.get());
				break;
			}
			System.out.println("wait async task to end ...");
			Thread.sleep(1000);
		}

	}

}
