package com.example.demo.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginRequest implements Serializable {
	/**
	 * メールアドレス
	 */
	@NotEmpty(message = "メールアドレスを入力してください")
	@Email( message = "メールアドレスは100桁以内で入力してください")
	private String mail;
	/**
	 * パスワード
	 */
	@Length(min = 5 ,max = 32, message = "パスワードは5～32桁以内で入力してください")
	private String pw;





}
