package com.dobi.fegin;

import com.dobi.api.service.PayService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;


@Component
@FeignClient("pay")
public interface PayServiceFegin extends PayService {

}
