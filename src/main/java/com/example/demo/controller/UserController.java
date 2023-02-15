package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.Goods;
import com.example.demo.entity.UserInfo;
import com.example.demo.entity.Userinfo;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	
	//head部分のアクション

	/**
	 * TOP画面を表示
	 * @param model Model
	 * @return TOP覧画面
	 */
	@GetMapping(value = "top")
	public String displayList(Model model) {
		List<Goods> userlist = UserService.searchAll();
		model.addAttribute("userlist", userlist);
		return "goods/topt";
	}
	
	/**
	 * 商品一覧画面を表示
	 * @param model Model
	 * @return 商品一覧画面
	 */
	@GetMapping(value = "goodslist")
	public String displayList(Model model) {
		List<Goods> userlist = UserService.searchAll();
		model.addAttribute("userlist", userlist);
		return "goods/goodslist";
	}
	
	/**
	 * 会員情報画面を表示
	 * @param model Model
	 * @return 会員情報画面
	 */
	@GetMapping(value = "/user/{id}")
	public String displayView(@PathVariable Long id, Model model) {
		  Userinfo user = UserService.findById(id);
		    model.addAttribute("userData", user);
		return "user/view";
	}
	
	/**
	 * ログイン画面を表示
	 * @param model Model
	 * @return ログイン画面
	 */
	@GetMapping(value = "login")
	public String displayList(Model model) {
		List<UserInfo> userlist = UserService.searchAll();
		model.addAttribute("userlist", userlist);
		return "user/login";
	}
	
	/**
	 * 会社概要画面を表示
	 * @param model Model
	 * @return 会社概要画面
	 */
	@GetMapping(value = "companyinfo")
	public String displayList(Model model) {
		List<User> userlist = UserService.searchAll();
		model.addAttribute("userlist", userlist);
		return "company/companyinfo";
	}
	
	/**
	 * Q&A画面を表示
	 * @param model Model
	 * @return Q&A画面
	 */
	@GetMapping(value = "Q&A")
	public String displayList(Model model) {
		List<User> userlist = UserService.searchAll();
		model.addAttribute("userlist", userlist);
		return "company/Q&A";
	}
	
	
	/**ログイン・会員登録画面の
	 * 新規会員登録をクリックした場合動作
	 */
	
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
	 * @return ユーザー情報一覧画面
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
		UserService.create(UserRequest);
		return "redirect:/user/list";
	}

}
