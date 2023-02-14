package com.example.demo.dto;
import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * ユーザー情報更新リクエストデータ
 *
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class UserUpdateRequest extends UserRequest implements Serializable {
	/**
	   * 名前
	   */
	  @NotEmpty(message = "名前を入力してください")
	  @Size(max = 100, message = "名前は100桁以内で入力してください")
	  private String name;
	  /**
	   * 生年月日
	   */
	  @Size(max = 8, message = "誕生日は8桁以内で入力してください")
	  private String birth;
	  /**
	   * 住所
	   */
	  @Size(max = 8, message = "住所は100桁以内で入力してください")
	  private String address;
	  /**
	   * メールアドレス
	   */
	  @Size(max = 8, message = "メールアドレスは100桁以内で入力してください")
	  private String mail;
	  /**
	   * クレジット番号
	   */
	  @Pattern(regexp = "0\\d{1,4}-\\d{1,4}-\\d{1,4}-\\d{4}", message = "クレジット番号の形式で入力してください")
	  private String credit;
	  /**
	   * パスワード
	   */
	  @Size(max = 8, message = "パスワードは8桁以内で入力してください")
	  private String pw;
}