package com.javacodegeeks.example.job.step1;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;

import com.javacodegeeks.example.util.Trade;
import com.javacodegeeks.example.util.TradeMapper;

public class MyTasklet implements Tasklet {
	
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		List<Trade> tradeList = new ArrayList<Trade>();
		JdbcTemplate myTemplate = new JdbcTemplate(getDataSource());
		String sql = "SELECT ID, STOCK, TIME, PRICE, SHARES FROM TRADES WHERE STOCK = 'SPY'";
		tradeList = myTemplate.query(sql, new TradeMapper());
		for (Trade t : tradeList) {
			System.out.println(t.toString());
		}
		return RepeatStatus.FINISHED;
	}
}