package com.javacodegeeks.example.job.step2;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

public class ParallelPartitioner implements Partitioner {
	
	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {
		Map<String, ExecutionContext> result = new HashMap<>();
		for (int index = 0; index < gridSize; index++) {
			ExecutionContext value = new ExecutionContext();
			value.putInt("parallelTotal", gridSize);
			value.putInt("parallelIndex", index);
			result.put("partition" + index, value);
		}
		return result;
	}
}