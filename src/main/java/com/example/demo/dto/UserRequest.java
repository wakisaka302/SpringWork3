package com.example.demo.dto;
import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class UserRequest implements Serializable {
  /**
   * 名前
   */
  @NotEmpty(message = "名前を入力してください")
  @Length(max = 100, message = "名前は100文字以内で入力してください")
  private String name;
  /**
   * 生年月日
   */
  @Length(min = 10,max = 10, message = "誕生日は10桁以内で入力してください")
  private String birth;
  /**
   * 住所
   */
  @Length(max = 100, message = "住所は100桁以内で入力してください")
  private String address;
  /**
   * メールアドレス
   */
  @NotEmpty(message = "メールアドレスを入力してください")
  @Email( message = "メールアドレスは100桁以内で入力してください")
  private String mail;
  /**
   * クレジット番号
   */
  @Length(min =16, max =16, message = "クレジット番号の形式で入力してください")
  private String credit;
  /**
   * パスワード
   */
  @Length(min = 5 ,max = 32, message = "パスワードは5～32桁以内で入力してください")
  private String pw;
}