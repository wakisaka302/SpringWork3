package com.example.demo.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class UserSales {
	
	private Date order_date;
	private String goods_name;
	private int price;
	private Integer order_num;
	private Integer total;
	
	
	
	

}
