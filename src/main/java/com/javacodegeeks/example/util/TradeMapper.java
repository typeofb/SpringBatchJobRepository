package com.javacodegeeks.example.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TradeMapper implements RowMapper<Trade> {
	
	public Trade mapRow(ResultSet rs, int rowNum) throws SQLException {
		Trade Trade = new Trade();
		Trade.setId(rs.getLong("id"));
		Trade.setStock(rs.getString("stock"));
		Trade.setTime(rs.getString("time"));
		Trade.setPrice(rs.getDouble("price"));
		Trade.setShares(rs.getInt("shares"));
		return Trade;
	}
}