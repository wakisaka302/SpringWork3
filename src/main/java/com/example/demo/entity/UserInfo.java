package com.example.demo.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class UserInfo {

	
	private Integer user_id;
	private String pw;
	private String name;
	private Date birth;
	private String address;
	private String mail;
	private String credit;

}



