package com.dobi.service;

import java.util.HashMap;
import java.util.Map;

import com.dobi.base.BaseController;
import com.dobi.base.BaseRedisService;
import com.dobi.base.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MemberServiceImpl extends BaseController implements MemberService {
	@Autowired
	private BaseRedisService baseRedisService;

	@Override
	public Map<String, Object> testRest() {
		Map<String, Object> result = new HashMap<>();
		result.put("errorCode", "200");
		result.put("errorMsg", "success");
		return result;
	}

//	@Override
	public ResponseBase testResponse() {
		return setResultSuccess();
	}

//	@Override
	public ResponseBase setRedisTest(String key, String value) {
		baseRedisService.setString(key, value);
		return setResultSuccess();
	}

//	@Override
	public ResponseBase getRedis(String key) {
		String value = baseRedisService.getString(key);
		return setResultSuccess(value);
	}

}
