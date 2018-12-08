package com.dobi.fegin;

import com.dobi.api.service.PayCallBackService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

import com.dobi.api.service.PayCallBackService;

@FeignClient("pay")
@Component
public interface CallBackServiceFegin extends PayCallBackService {

}
