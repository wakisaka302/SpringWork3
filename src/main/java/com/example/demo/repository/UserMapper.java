package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.UserInfo;

@Mapper
public interface UserMapper {

	//ユーザー情報登録
	void userInsert(UserInfo userinfo); 
}
