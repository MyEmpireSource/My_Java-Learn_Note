package com.learn.token;

import com.learn.token.entity.TokenInfo;
import com.learn.token.util.JWTTokenOper;

public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println();
		TokenInfo tokenInfo = new TokenInfo();
		
		tokenInfo.setPkiKey("test@qq.com");
		
		System.out.println(JWTTokenOper.createJWT("JWT", tokenInfo));
		
		System.out.println();
		System.out.println();
		
		
	}

}
