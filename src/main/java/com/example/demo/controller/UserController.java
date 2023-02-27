package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.OrderRequest;
import com.example.demo.dto.UserRequest;
import com.example.demo.entity.Goods;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	boolean flag = false;
	int user_id;
	
	

		@Autowired
		UserService userService;
	

	//head部分のアクション

	/**
	 * TOP画面を表示
	 * @param model Model
	 * @return TOP画面
	 */
	@GetMapping(value = "/goods/top")
	public String displayTop(Model model) {

		return "goods/top";
	}

	/**
	 * 商品一覧画面を表示
	 * @param model Model
	 * @return 商品一覧画面
	 */
	@GetMapping(value = "/goods/goodslist")
	public String displayGoodslist(Model model) {
			return "goods/goodslist";
	}

	/**
	 * 会員情報画面を表示
	 * @param model Model
	 * @return 会員情報画面
	 */
	//2/27追加
	@GetMapping(value = "/user/view")
	public String displayView(@PathVariable Long id, Model model) {
		if(flag) {
			model.addAttribute("loginRequest", new LoginRequest());
			
//			userService.getUserInfo(user_id);
			//userInfoエンティティをモデルに追加
			model.addAttribute("userInfo", userService.getUserInfo(user_id));
			
//			userService.getUserSales(user_id);
			//Salesエンティティのリストをモデルに追加
			model.addAttribute("userSales", userService.getUserSales(user_id));
			
			
			
			
			return "user/login";
//			return "user/view";
		}
		
		
		//		Userinfo user = UserService.getUserInfo(id);
		//      if(user.userid =!= null){
		//		model.addAttribute("userData", user);
		// List<Sales> list = UserService.getSales(id)
		//model.addAttribute("userlist", list);
		//return "user/view";

		//      } else{
		//		return "goods/top";
		//	}
		//		
		model.addAttribute("loginRequest", new LoginRequest());
		return "user/login";
	}

	/**
	 * ログイン画面を表示
	 * @param model Model
	 * @return ログイン画面
	 */
	@GetMapping(value = "/user/login")
	public String displayLogin(Model model) {
		model.addAttribute("loginRequest", new LoginRequest());
		return "user/login";
	}
	

	/**
	 * 会社概要画面を表示
	 * @param model Model
	 * @return 会社概要画面
	 */
	@GetMapping(value = "/company/companyinfo")
	public String displayCompany(Model model) {

		return "company/companyinfo";
	}

	/**
	 * Q&A画面を表示
	 * @param model Model
	 * @return Q&A画面
	 */
	@GetMapping(value = "/company/qa")
	public String displayQa(Model model) {

		return "company/qa";
	}

	/**
	 * 商品詳細情報画面
	 * @param model Model
	 * @return 商品詳細情報画面
	 */
	@GetMapping(value = "/goods/goods/{id}")
	public String displayGoods(@PathVariable Integer id, Model model) {
		Goods goods = userService.getGoodsDetail(id);
		model.addAttribute("goods", goods);
		return "goods/goods";
	}
	
	
	
	//2/24追加, 2/27追加・修整
	/**
	 * 購入画面(ログイン中なら購入完了画面、未ログインならログイン画面に遷移)
	 * @param model Model
	 * @return 商品詳細情報画面
	 */
	@RequestMapping(value = "/goods/purchased_1", method = RequestMethod.POST)
	public String purchasedComplete(@Validated @ModelAttribute OrderRequest orderRequest, BindingResult result, Model model) {
		if(flag) {
			orderRequest.setUser_id(user_id);;
			model.addAttribute("orderRequest", orderRequest);
			//salesエンティティをモデルに追加
			model.addAttribute("sales", userService.salesInsert(orderRequest));
			//goodsエンティティをモデルに追加
			model.addAttribute("goods", userService.getGoodsDetail(orderRequest.getGoods_id()));
			return "goods/purchased";
		}
		model.addAttribute("loginRequest", new LoginRequest());
		return "user/login";
	}
	

	
	
	
	

	//ログイン・会員登録画面の
	//新規会員登録をクリックした場合動作
	/**
	 * ユーザー新規会員登録画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@GetMapping(value = "/user/add")
	public String displayAdd(Model model) {
		
				model.addAttribute("userRequest", new UserRequest());
		return "user/add";
	}

	/**
	 * ユーザー新規登録
	 * @param userRequest リクエストデータ
	 * @param model Model
	 * @return 成功時:TOP画面 /失敗時：ユーザー新規登録画面
	 */
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public String create(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// 入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "user/add";
		}
		// ユーザー情報の登録
		userService.userEntry(userRequest);
		return "redirect:/goods/top";
	}
	
	
	//2/22追加
	/**
	 * ユーザーログイン
	 * @param userRequest リクエストデータ
	 * @param model Model
	 * @return 成功時:TOP画面 /失敗時：ユーザー新規登録画面
	 */
	//アノテーションvalueのURLが未定
	@RequestMapping(value = "/user/login_1", method = RequestMethod.POST)
	public String login(@Validated @ModelAttribute LoginRequest loginRequest, BindingResult result, Model model) {

		if (result.hasErrors()) {
			// 入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError2", errorList);
			return "user/login";
		}
		// ユーザーログイン認証成功
		
		flag = userService.checkLogin(loginRequest);
		user_id = UserService.userId;
		System.out.println(user_id);
		
		
		return "redirect:/goods/top";
	}
	
	
	

}
