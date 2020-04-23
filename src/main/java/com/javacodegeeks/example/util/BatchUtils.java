package com.javacodegeeks.example.util;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.scope.context.StepContext;
import org.springframework.batch.item.ExecutionContext;

public class BatchUtils {

	private final static String JOB_CONTINUE_STATUS = "JOB_CONTINUE_STATUS";

	// set/get a key-value pair job execution context
	static public void setJobContextValue(String name, Object value, ChunkContext chunkContext) {
		setJobContextValue(name, value, chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext());
	}

	static public void setJobContextValue(String name, Object value, StepContext stepContext) {
		setJobContextValue(name, value, stepContext.getStepExecution().getJobExecution().getExecutionContext());
	}

	static public void setJobContextValue(String name, Object value, StepExecution stepExecution) {
		setJobContextValue(name, value, stepExecution.getExecutionContext());
	}

	static public void setJobContextValue(String name, Object value, ExecutionContext executionContext) {
		executionContext.put(name, value);
	}

	static public Object getJobContextValue(String name, ChunkContext chunkContext) {
		return getJobContextValue(name, chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext());
	}

	static public Object getJobContextValue(String name, StepContext stepContext) {
		return getJobContextValue(name, stepContext.getStepExecution().getJobExecution().getExecutionContext());
	}

	static public Object getJobContextValue(String name, StepExecution stepExecution) {
		return getJobContextValue(name, stepExecution.getExecutionContext());
	}

	static public Object getJobContextValue(String name, ExecutionContext executionContext) {
		return executionContext.get(name);
	}

	// set/get job execution control value
	static public void setContinue(String value, ChunkContext chunkContext) {
		setContinue(value, chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext());
	}

	static public void setContinue(String value, StepContext stepContext) {
		setContinue(value, stepContext.getStepExecution().getJobExecution().getExecutionContext());
	}

	static public void setContinue(String value, JobExecution jobExecution) {
		setContinue(value, jobExecution.getExecutionContext());
	}

	static public void setContinue(String value, ExecutionContext executionContext) {
		executionContext.put(JOB_CONTINUE_STATUS, value);
	}

	static public String getContinue(ChunkContext chunkContext) {
		return getContinue(chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext());
	}

	static public String getContinue(StepContext stepContext) {
		return getContinue(stepContext.getStepExecution().getJobExecution().getExecutionContext());
	}

	static public String getContinue(JobExecution jobExecution) {
		return getContinue(jobExecution.getExecutionContext());
	}

	static public String getContinue(ExecutionContext executionContext) {
		if (executionContext.containsKey(JOB_CONTINUE_STATUS)) {
			return executionContext.getString(JOB_CONTINUE_STATUS);
		}
		return null;
	}
}