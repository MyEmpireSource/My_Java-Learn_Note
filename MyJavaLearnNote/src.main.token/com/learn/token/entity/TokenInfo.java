package com.learn.token.entity;

/**
 * 
 * @Package: com.learn.token.entity
 * @ClassName: TokenInfo.java
 *
 * @Description: Token 中 自定义信息抽象对象
 * 
 * @Company:
 * @Author: ZCX  
 * @CreateDate: 2018年2月8日 下午5:41:33
 * @UpdateDate: 2018年2月8日 下午5:41:33
 * @Version: V1.0
 */
public class TokenInfo {
	
	private String aud = "mobile";
	private String iss = "SJWebProject";
	private long iat = System.currentTimeMillis();	//Token创建时间
	private long exp = this.iat + 3600000;			//Token过期时间
	 
	private String userId;
	private String alg = "HS256";
	private String pkiKey = "";

	public String getAud() {
		return aud;
	}

	public void setAud(String aud) {
		this.aud = aud;
	}

	public String getIss() {
		return iss;
	}

	public void setIss(String iss) {
		this.iss = iss;
	}

	public long getIat() {
		return iat;
	}

	public void setIat(long iat) {
		this.iat = iat;
	}

	public long getExp() {
		return exp;
	}

	public void setExp(long exp) {
		this.exp = exp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAlg() {
		return alg;
	}

	public void setAlg(String alg) {
		this.alg = alg;
	}

	public String getPkiKey() {
		return pkiKey;
	}

	public void setPkiKey(String pkiKey) {
		this.pkiKey = pkiKey;
	}

	@Override
	public String toString() {
		return "TokenInfo [aud=" + aud + ", iss=" + iss + ", iat=" + iat + ", exp=" + exp + ", userId=" + userId
				+ ", alg=" + alg + ", pkiKey=" + pkiKey + "]";
	}
	
}
