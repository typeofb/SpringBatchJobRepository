package com.javacodegeeks.example.util;

public class Trade {
	long id;
	String stock;
	String time;
	double price;
	int shares;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}
	
	@Override
	public String toString() {
		return getId() + "|" + getStock() + "|" + getTime() + "|" + getPrice() + "|" + getShares();
	}
}