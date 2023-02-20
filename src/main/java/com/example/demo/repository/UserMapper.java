package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Goods;
import com.example.demo.entity.Sales;
import com.example.demo.entity.UserInfo;
@Mapper
public interface UserMapper {

	/* 会員情報登録 */
	void userInsert(UserInfo userinfo);
	
	/* 会員情報を表示 */
	UserInfo userOneSelect(String pw, String mail);
	
	/* 商品詳細 */
	Goods goodsOneSelect(String goods_id);
	
	/* 購入完了 */
	Sales order(String user_id);
	
	/* 購入履歴 */
	void salesRecord(Sales sales);
	

	//List<Userinfo>selectAll();
	//List<Goods>selectAll();
	//List<Sales>selectAll();

}
