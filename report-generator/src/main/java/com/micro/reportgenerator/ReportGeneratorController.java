package com.micro.reportgenerator;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportGeneratorController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TransactionClientProxy proxy;
	
	@GetMapping("/trans")
	public TransactionsReportBean fetchAllTrans() {
		List<TransactionBean> response = proxy.getAllTrans();
		BigDecimal total = BigDecimal.ZERO;
		for(TransactionBean tran: response) {
			total = total.add(tran.getAmount());
		}
		TransactionsReportBean report = new TransactionsReportBean();
		report.setTransList(response);
		report.setTotalAmt(total);
		logger.info("{}", response);
		return report;
	}
	
	@GetMapping("/trans/from/{sender}")
	public TransactionsReportBean fetchTransFromSender(@PathVariable String sender) {
		List<TransactionBean> response = proxy.getTransBySenderName(sender);
		BigDecimal total = BigDecimal.ZERO;
		for(TransactionBean tran: response) {
			total = total.add(tran.getAmount());
		}
		TransactionsReportBean report = new TransactionsReportBean();
		report.setTransList(response);
		report.setTotalAmt(total);
		logger.info("{}", response);
		return report;
	}
	
	@GetMapping("/trans/time/{time}")
	public TransactionsReportBean fetchTransDuringTime(@PathVariable String time) {
		List<TransactionBean> response = proxy.getTransByTime(time);
		BigDecimal total = BigDecimal.ZERO;
		for(TransactionBean tran: response) {
			total = total.add(tran.getAmount());
		}
		TransactionsReportBean report = new TransactionsReportBean();
		report.setTransList(response);
		report.setTotalAmt(total);
		logger.info("{}", response);
		return report;
	}
	

}
