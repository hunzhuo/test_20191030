package com.imooc.o2o.util;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
	public static boolean checkVerifyCode(HttpServletRequest request) {
		String verifyCodeExpected = (String) request.getSession().getAttribute(
				com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);/*实际产生的验证码*/
		String verifyCodeActual = HttpServletRequestUtil.getString(request,
				"verifyCodeActual");/*输入的验证码*/
		if (verifyCodeActual == null
				|| !verifyCodeActual.equals(verifyCodeExpected)) {
			return false;
		}
		return true;
	}
}
