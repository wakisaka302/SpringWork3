package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.UserInfo;
import com.example.demo.repository.UserMapper;


@Service
public class UserService {
	
	@Autowired UserMapper repository;
	
	//会員情報登録
	public void userEntry(UserRequest userRequest){
		UserInfo userinfo = new UserInfo();
		userinfo.setPw(userRequest.getPw());
		userinfo.setName(userRequest.getName());
		userinfo.setBirth(userRequest.getBirth());
		userinfo.setAddress(userRequest.getAddress());
		userinfo.setMail(userRequest.getMail());
		userinfo.setCredit( userRequest.getCredit());
		repository.userInsert(userinfo);
	}


	
	

}
