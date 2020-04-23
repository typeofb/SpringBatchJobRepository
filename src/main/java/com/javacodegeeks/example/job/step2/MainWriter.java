package com.javacodegeeks.example.job.step2;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.batch.item.ItemWriter;

public class MainWriter implements ItemWriter<Map<String, Object>> {
	
	private static final Log log = LogFactory.getLog(MainWriter.class);
	
	SqlSessionTemplate batchSqlSessionTemplate;
	
	public void setSqlSessionTemplate(SqlSessionTemplate batchSqlSessionTemplate) {
		this.batchSqlSessionTemplate = batchSqlSessionTemplate;
	}
	
	@Override
	public void write(List<? extends Map<String, Object>> items) throws Exception {
		for (Map<String, Object> item: items) {
			log.info("Writer:" + item);
			batchSqlSessionTemplate.insert("Trade.insertTrade", item);
		}
		batchSqlSessionTemplate.flushStatements();
	}
}