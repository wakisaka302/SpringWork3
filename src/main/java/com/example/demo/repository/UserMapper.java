package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.LoginRequest;
import com.example.demo.entity.Goods;
import com.example.demo.entity.Sales;
import com.example.demo.entity.UserInfo;
import com.example.demo.entity.UserSales;

@Mapper
public interface UserMapper {

	//ユーザー情報登録
	void userInsert(UserInfo userinfo); 

	//ログイン取得(取得件数を返す)
	int selectLogin(LoginRequest loginRequest);

	//ログイン取得(取得件数を返す)
	int getcount(LoginRequest loginRequest);

	//会員情報取得
	UserInfo userInfoSelect(int user_id);

	//購入履歴取得
	List<UserSales> userSalesRecordSelect(int user_id);




	//商品詳細をselect
	Goods selectGoods(Integer goods_id);


	//購入商品をinsert
	void salesSave(Sales sales);


	//在庫数をupdate
	void stockUpdate(int stock, int goods_id);

}
