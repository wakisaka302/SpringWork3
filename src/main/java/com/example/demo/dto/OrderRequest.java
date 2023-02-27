package com.example.demo.dto;

import lombok.Data;

@Data
public class OrderRequest {
	/**
	 * 注文数
	 */
	private int user_id;
	private int goods_id;
	private int price;
	private int orderNum;
}
