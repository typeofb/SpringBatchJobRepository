package com.javacodegeeks.example.job.step2;

import java.util.Map;

import org.springframework.batch.item.ItemProcessor;

public class MainProcessor implements ItemProcessor<Map<String, Object>, Map<String, Object>> {
	
	@Override
	public Map<String, Object> process(Map<String, Object> item) throws Exception {
		return item;
	}
}