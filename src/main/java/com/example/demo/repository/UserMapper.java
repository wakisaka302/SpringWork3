package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.LoginRequest;
import com.example.demo.entity.Goods;
import com.example.demo.entity.UserInfo;

@Mapper
public interface UserMapper {
	
	//ユーザー情報登録
	void userInsert(UserInfo userinfo); 
	
	
	//商品詳細をselect
	Goods selectGoods(Integer goods_id);
	
	
	//ログイン取得(取得件数を返す)
	int selectLogin(LoginRequest loginRequest);

	
	
}
