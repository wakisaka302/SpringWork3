package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.UserRequest;

@Controller
public class UserController {

//	@Autowired
//	UserMapper Goods;
//	@Autowired
//	UserMapper Saless;
//	@Autowired
//	UserMapper UserInfo;

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
//		List<Goods> userlist = UserService.searchAll();
//		model.addAttribute("userlist", userlist);
		return "goods/goodslist";
	}

	/**
	 * 会員情報画面を表示
	 * @param model Model
	 * @return 会員情報画面
	 */
	@GetMapping(value = "/user/{id}")
	public String displayView(@PathVariable Long id, Model model) {
//		Userinfo user = UserService.findById(id);
//		model.addAttribute("userData", user);
		return "user/view";
	}

	/**
	 * ログイン画面を表示
	 * @param model Model
	 * @return ログイン画面
	 */
	@GetMapping(value = "/user/login")
	public String displayLogin(Model model) {
//		List<UserInfo> userlist = UserService.searchAll();
//		model.addAttribute("userlist", userlist);
		return "user/login";
	}

	/**
	 * 会社概要画面を表示
	 * @param model Model
	 * @return 会社概要画面
	 */
	@GetMapping(value = "/company/companyinfo")
	public String displayCompany(Model model) {
//		List<User> userlist = UserService.searchAll();
//		model.addAttribute("userlist", userlist);
		return "company/companyinfo";
	}

	/**
	 * Q&A画面を表示
	 * @param model Model
	 * @return Q&A画面
	 */
	@GetMapping(value = "/company/Q&A")
	public String displayQa(Model model) {
//		List<User> userlist = UserService.searchAll();
//		model.addAttribute("userlist", userlist);
		return "company/Q&A";
	}

	/**
	 * 商品検索結果一覧画面を表示
	 * @param model Model
	 * @return 検索結果一覧画面
	 */
	@GetMapping(value = "/goods/search")
	public String displaySearch(Model model) {
//		List<Goods> userlist = UserService.searchAll();
//		model.addAttribute("userlist", userlist);
		return "goods/search";
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
	
	  

}
