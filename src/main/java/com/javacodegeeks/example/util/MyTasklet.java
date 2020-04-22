package com.javacodegeeks.example.util;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;

public class MyTasklet implements Tasklet {
	private DataSource dataSource;
	private String sql = "SELECT ID, STOCK, TIME, PRICE, SHARES FROM TRADES WHERE STOCK = 'SPY'";

	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		List<Trade> tradeList = new ArrayList<Trade>();
		JdbcTemplate myTemplate = new JdbcTemplate(getDataSource());
		tradeList = myTemplate.query(sql, new TradeMapper());
		for (Trade t : tradeList) {
			System.out.println(t.toString());
		}
		return RepeatStatus.FINISHED;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}