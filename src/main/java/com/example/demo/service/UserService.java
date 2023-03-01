package com.example.demo.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.OrderRequest;
import com.example.demo.dto.UserRequest;
import com.example.demo.entity.Goods;
import com.example.demo.entity.Sales;
import com.example.demo.entity.UserInfo;
import com.example.demo.entity.UserSales;
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
		int count = 0;
		
		count = repository.getcount(loginRequest);
		
		if (count>0) {
			userId = repository.selectLogin(loginRequest);
			return true;
		} else {
			return false;
		}
	}


	//会員情報を取得
	public UserInfo getUserInfo(int user_id){
		return repository.userInfoSelect(user_id);  //会員情報取得
	}


	
	public List<UserSales> getUserSales(int user_id){
		return repository.userSalesRecordSelect(user_id);
	}


	
	
	
	

	//商品詳細をselect
	public Goods getGoodsDetail(Integer goods_id){
		//System.out.println(goods_id);
		return repository.selectGoods(goods_id);
	}


	//商品購入時
	public Sales salesInsert(OrderRequest orderRequest){
		Sales sales = new Sales();
		//エンティティにセット(user_id, goods_id, order_num)
		sales.setUser_id(orderRequest.getUser_id());
		sales.setGoods_id(orderRequest.getGoods_id());
		sales.setOrder_num(orderRequest.getOrderNum());
		//エンティティにセット(order_date)
		Date sqlNow = new Date(System.currentTimeMillis());
		Date utilDate = sqlNow; //java.util.Dateから派生しているので、キャストも無しでも代入できる
		Date sqlDate = new Date(utilDate.getTime());
		System.out.println("購入日"+sqlDate);
		sales.setOrder_date(sqlDate);
		//Goodsテーブルから商品の値段をselect
		repository.selectGoods(sales.getGoods_id());
		//エンティティにセット(total)
		int total = repository.selectGoods(sales.getGoods_id()).getPrice() * orderRequest.getOrderNum();
		sales.setTotal(total);		
		//リポジトリのinsertメソッドを呼び出す
		repository.salesSave(sales);
		
		//sqlの個数を計算
		int afterStock = repository.selectGoods(orderRequest.getGoods_id()).getStock() - orderRequest.getOrderNum();
		//リポジトリのupdateメソッドを呼び出す
		repository.stockUpdate(afterStock, orderRequest.getGoods_id());
		
		return sales;
	}

	
	
	

}
