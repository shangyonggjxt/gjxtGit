package com.cttic.service.tasks;

import java.text.SimpleDateFormat;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTasks {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 3000)
	public void showCurrentTime() {
		// System.out.println("当前时间 1:" + sdf.format(new Date()));
	}

	@Scheduled(fixedRate = 5000)
	public void showCurrentTime2() {
		// System.out.println("当前时间 2:" + sdf.format(new Date()));
	}

}
