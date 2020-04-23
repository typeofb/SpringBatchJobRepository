package com.javacodegeeks.example.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	static ApplicationContext ctx;
	
	public static void main(String[] args) {
		String[] str = { "META-INF/spring/context-config.xml", "META-INF/spring/job-config.xml" };
		ctx = new ClassPathXmlApplicationContext(str);
		Job job = (Job) ctx.getBean("myJob");
		JobLauncher jobLauncher = (JobLauncher) ctx.getBean("jobLauncher");
		try {
			JobExecution execution = jobLauncher.run(job, makeJobParameters(args, 1));
			System.out.println("Job Execution Status: " + execution.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static JobParameters makeJobParameters(String[] args, int startIndex) {
		Map<String, JobParameter> confMap = new HashMap<String, JobParameter>();
		confMap.put("time", new JobParameter(System.currentTimeMillis()));
		makeArgsToParameter(confMap, args, startIndex);
		JobParameters jobParameters = new JobParameters(confMap);
		return jobParameters;
	}
	
	private static void makeArgsToParameter(Map<String, JobParameter> confMap, String[] args, int startIndex) {
		if (args == null || args.length == 0 || startIndex >= args.length) {
			return;
		}
		
		int division;
		String argument;
		for (int index = startIndex; index < args.length; index++) {
			argument = args[index];
			division = argument.indexOf('=');
			if (division <= 0)
				confMap.put("arg" + index, new JobParameter(argument));
			else
				confMap.put(argument.substring(0, division).trim(), new JobParameter(argument.substring(division + 1).trim()));
		}
	}
}
