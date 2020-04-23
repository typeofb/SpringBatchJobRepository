package com.javacodegeeks.example.job.stepDecision;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

import com.javacodegeeks.example.util.BatchUtils;

public class MyDecider implements JobExecutionDecider {
	
	SqlSessionTemplate sqlSessionTemplate;
	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
//		if (!stepExecution.getExitStatus().getExitCode().equals(ExitStatus.FAILED.getExitCode())
//				&& stepExecution.getSkipCount() > 2) {
//			return new FlowExecutionStatus("COMPLETED WITH SKIPS");
//		} else {
//			return new FlowExecutionStatus(ExitStatus.COMPLETED.getExitCode());
//		}
		
		String decision = BatchUtils.getContinue(jobExecution);
		if (decision == null) {
			decision = "CONTINUE";
		}
		return new FlowExecutionStatus(decision);
	}
}