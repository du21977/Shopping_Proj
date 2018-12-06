package com.dobi.api.serivce.impl;

import com.dobi.api.service.MemberService;
import com.dobi.base.BaseApiService;
import com.dobi.base.ResponseBase;
import com.dobi.constants.Constants;
import com.dobi.dao.MemberDao;
import com.dobi.entity.UserEntity;
import com.dobi.mq.RegisterMailboxProducer;
import com.dobi.utils.MD5Util;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MemberServiceImpl extends BaseApiService implements MemberService {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private RegisterMailboxProducer registerMailboxProducer;
	@Value("${messages.queue}")
	private String MESSAGESQUEUE;

	@Override
	public ResponseBase findUserById(Long userId) {
		UserEntity user = memberDao.findByID(userId);
		if (user == null) {
			return setResultError("未查找到用户信息.");
		}
		return setResultSuccess(user);
	}

	/**
	 * 注册功能
	 * @RequestBody------是json格式的呀
	 * @param user
	 * @return
	 */
	@Override
	public ResponseBase regUser(@RequestBody UserEntity user) {
		// 参数验证
		String password = user.getPassword();
		if (StringUtils.isEmpty(password)) {
			return setResultError("密码不能为空.");
		}
		//MD5加密   -----可以在密码后加一个随机数，就是加盐，再MD5，就是MD5加盐
		String newPassword = MD5Util.MD5(password);
		user.setPassword(newPassword);
		Integer result = memberDao.insertUser(user);
		if (result <= 0) {  //没有插入成功
			return setResultError("注册用户信息失败.");
		}
		// 采用异步方式发送消息
		String email = user.getEmail();
		String json = emailJson(email);
		log.info("####会员服务推送消息到消息服务平台####json:{}", json);
		sendMsg(json);
		return setResultSuccess("用户注册成功.");
	}

	/**
	 * 转json
	 * @param email
	 * @return
	 */
	private String emailJson(String email) {
		JSONObject rootJson = new JSONObject();
		JSONObject header = new JSONObject();
		header.put("interfaceType", Constants.MSG_EMAIL);
		JSONObject content = new JSONObject();
		content.put("email", email);
		rootJson.put("header", header);
		rootJson.put("content", content);
		return rootJson.toJSONString();
	}

	/**
	 * ActiveMQ发消息
	 * @param json
	 */
	private void sendMsg(String json) {
		ActiveMQQueue activeMQQueue = new ActiveMQQueue(MESSAGESQUEUE);
		registerMailboxProducer.sendMsg(activeMQQueue, json);

	}
}
