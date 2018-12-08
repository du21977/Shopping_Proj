package com.dobi.fegin;

import com.dobi.api.order.OrderService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;



@Component
@FeignClient("order")
public interface OrderServiceFegin extends OrderService {

}
