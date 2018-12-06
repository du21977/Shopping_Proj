package com.dobi.api.service;

import com.dobi.base.ResponseBase;
import com.dobi.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/member")
public interface MemberService {

	// 使用userId查找用户信息
	@RequestMapping("/findUserById")
	ResponseBase findUserById(Long userId);
	@RequestMapping("/regUser")
	ResponseBase regUser(@RequestBody UserEntity user);
}
