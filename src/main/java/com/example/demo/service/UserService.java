package com.example.demo.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.OrderRequest;
import com.example.demo.dto.UserRequest;
import com.example.demo.entity.Goods;
import com.example.demo.entity.Sales;
import com.example.demo.entity.UserInfo;
import com.example.demo.repository.UserMapper;


@Service
public class UserService {

	@Autowired UserMapper repository;
	public static int userId = 0;

	//会員情報登録
	public void userEntry(UserRequest userRequest){
		UserInfo userinfo = new UserInfo();
		userinfo.setPw(userRequest.getPw());
		userinfo.setName(userRequest.getName());		
		Date birthDate = Date.valueOf(userRequest.getBirth());
		userinfo.setBirth(birthDate);
		userinfo.setAddress(userRequest.getAddress());
		userinfo.setMail(userRequest.getMail());
		userinfo.setCredit( userRequest.getCredit());
		repository.userInsert(userinfo);
	}

	//ログイン取得(boolean型で取得)
	public boolean checkLogin(LoginRequest loginRequest){
		userId = repository.selectLogin(loginRequest);
		if (userId>0) {
			return true;
		} else {
			return false;
		}
	}





	//商品詳細をselect
	public Goods getGoodsDetail(Integer goods_id){
		//System.out.println(goods_id);
		return repository.selectGoods(goods_id);
	}


	//商品購入時
	public void salesInsert(OrderRequest orderRequest){
		Sales sales = new Sales();
		sales.setUser_id(orderRequest.getUser_id());
		sales.setGoods_id(orderRequest.getGoods_id());
		
		
//		sales.getOrder_date();
//		
//		sales.user_id = orderRequest.getUser_id();
//		sales.goods_id = orderRequest.getGoods_id(); 
//		sales.order_num = orderRequest.getOrder_num();
//		sales.total = sales.order_num * getGoodsPrice;	
//	repository.salesSave();
	}

	

}
