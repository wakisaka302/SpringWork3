package com.example.demo.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Sales {
	
	
	private Integer user_id;
	private Integer goods_id;
	private Date order_date;
	private Integer order_num;
	private Integer total;
	
}
