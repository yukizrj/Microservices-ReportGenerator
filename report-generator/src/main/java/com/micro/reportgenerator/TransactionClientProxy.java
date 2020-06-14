package com.micro.reportgenerator;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="zuul-api-gateway")
@RibbonClient(name="transactions-client")
public interface TransactionClientProxy {
	
	@GetMapping("/transactions-client/trans")
	public List<TransactionBean> getAllTrans();
	
	@GetMapping("/transactions-client/trans/from/{sender}")
	public List<TransactionBean> getTransBySenderName(@PathVariable String sender);
		
	@GetMapping("/transactions-client/trans/time/{time}")
	public List<TransactionBean> getTransByTime(@PathVariable String time);	
	
}
