package com.dobi.service.impl;

import com.codingapi.tx.annotation.ITxTransaction;
import com.codingapi.tx.annotation.TxTransaction;
import com.dobi.api.order.OrderService;
import com.dobi.base.BaseApiService;
import com.dobi.base.ResponseBase;
import com.dobi.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderServiceImpl extends BaseApiService implements OrderService, ITxTransaction {
	@Autowired
	private OrderDao orderDao;

	@Override
	@TxTransaction//这里是参与方，@TxTransaction(isStart = true)//true为发起方
	@Transactional
	public ResponseBase updateOrderIdInfo(@RequestParam("isPay") Long isPay, @RequestParam("payId") String aliPayId,
										  @RequestParam("orderNumber") String orderNumber) {
		int updateOrder = orderDao.updateOrder(isPay, aliPayId, orderNumber);
		if (updateOrder <= 0) {
			return setResultError("系统错误!");
		}
		return setResultSuccess();
	}

}
