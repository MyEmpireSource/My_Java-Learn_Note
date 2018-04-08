package com.learn.token.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.base.util.StringUtil;
import com.learn.token.entity.TokenInfo;
import com.learn.token.service.TokenService;
import com.learn.token.util.Constant;
import com.learn.token.util.JWTTokenOper;

import net.sf.json.JSONObject;

public class TokenServiceImpl implements TokenService {

	@Override
	public String getToken(String pkiKey) {
		// TODO Auto-generated method stub
		
		TokenInfo tokenInfo = new TokenInfo();
		tokenInfo.setPkiKey(pkiKey);
		
		return JWTTokenOper.createJWT("JWT", tokenInfo);
	}

	@Override
	public boolean checkTokenInfo(String tokenId) {
		// TODO Auto-generated method stub
		return JWTTokenOper.parseJwt(tokenId);
	}

	@Override
	public String updateExpTimeForTokenId(String tokenId) {
		// TODO Auto-generated method stub
		
		try {
			String[] tokenInfoArray = tokenId.split("\\.");
			
			JSONObject tokenHeadJson = JWTTokenOper.getTokenHeaderInfoByTokenId(tokenInfoArray[0]);
			
			TokenInfo tokenInfo = JWTTokenOper.getTokenInfoByTokenId(tokenInfoArray[1]);
			
			tokenInfo.setExp(tokenInfo.getExp() + Constant.TOKEN_CHECK_TIME);
			tokenInfo.setAlg(tokenHeadJson.getString("alg"));
			
			return JWTTokenOper.createJWT(tokenHeadJson.getString("typ"), tokenInfo);
		} catch (Exception e) {
			return null;
		}
		
		
	}

	@Override
	public Map<String, Object> checkAndReturnToken(JSONObject paramJsonInfo) {
		// TODO Auto-generated method stub
		String msg = "";
		Map<String, Object> returnMap = new HashMap<String, Object> ();
		returnMap.put(Constant.TOKEN_CHECK_FLAG_KEY, false);
		
		//if (StringUtil.isNullOrSpace(paramJsonInfoStr)) {
		if (paramJsonInfo == null || paramJsonInfo.isEmpty()) {
			msg = "参数信息为空!!";
		} else {
			
			try {
				
				//JSONObject paramJson = JSONObject.fromObject(paramJsonInfoStr);
				
				String tokenId = paramJsonInfo.getString(Constant.TOKEN_INFO_KEY);
				
				if (StringUtil.isNullOrSpace(tokenId)) {
					msg = "请登录!!";
				} else {
					boolean isTokenIdCheck = this.checkTokenInfo(tokenId);
					
					returnMap.put(Constant.TOKEN_CHECK_FLAG_KEY, isTokenIdCheck);
					
					if (isTokenIdCheck) {
						
						String newTokenId = this.updateExpTimeForTokenId(tokenId);
						
						if (StringUtil.isNullOrSpace(newTokenId)) {
							msg = "生成证书失败!!";
						} else {
							returnMap.put(Constant.TOKEN_INFO_KEY, newTokenId);
						}
					} else {
						msg = "证书认证不通过, 请重新登录!!";
					}
				}
				
				
			} catch (Exception e) {
				msg = "参数格式不正确!!";
			}
		}
		
		if (!StringUtil.isNullOrSpace(msg)) {
			returnMap.put(Constant.TOKEN_CHECK_MESSAGE_KEY, msg);
		}
		
		return returnMap;
	}

}
