package com.dobi.controller;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.dobi.base.ResponseBase;
import com.dobi.constants.Constants;
import com.dobi.fegin.MemberServiceFegin;
import com.dobi.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Slf4j
@Controller
public class IndexController {
	private static final String INDEX = "index";
	@Autowired
	private MemberServiceFegin memberServiceFegin;

	// 主页
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest reqest) {
		// 1.从cookie中获取 token信息
		String token = CookieUtil.getUid(reqest, Constants.COOKIE_MEMBER_TOKEN);
		log.info("token---token", token);
		// 2.如果cookie 存在 token，调用会员服务接口，使用token查询用户信息
		if (!StringUtils.isEmpty(token)) {
			ResponseBase responseBase = memberServiceFegin.findByTokenUser(token);
			if (responseBase.getRtnCode().equals(Constants.HTTP_RES_CODE_200)) {
				LinkedHashMap userData = (LinkedHashMap) responseBase.getData();
				String username = (String) userData.get("username");
				reqest.setAttribute("username", username);
			}
		}
		return INDEX;
	}

}
