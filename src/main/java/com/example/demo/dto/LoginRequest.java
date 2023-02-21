package com.example.demo.dto;

import java.io.Serializable;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequest implements Serializable {
	/**
	 * メールアドレス
	 */
	@Size(max = 8, message = "メールアドレスは100桁以内で入力してください")
	private String mail;
	/**
	 * パスワード
	 */
	@Size(max = 8, message = "パスワードは8桁以内で入力してください")
	private String pw;





}
