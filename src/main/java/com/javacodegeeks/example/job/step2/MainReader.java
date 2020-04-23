package com.javacodegeeks.example.job.step2;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;

import com.javacodegeeks.example.util.BatchUtils;

public class MainReader extends MyBatisCursorItemReader<Map<String, Object>> {
	
	@BeforeStep
	public void setParams(StepExecution stepExecution) {
		int parallelTotal = (Integer) BatchUtils.getJobContextValue("parallelTotal", stepExecution);
		int parallelIndex = (Integer) BatchUtils.getJobContextValue("parallelIndex", stepExecution);
		String search = stepExecution.getJobParameters().getString("search");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("search", search);
		params.put("parallelTotal", parallelTotal);
		params.put("parallelIndex", parallelIndex);
		this.setParameterValues(params);
	}
}