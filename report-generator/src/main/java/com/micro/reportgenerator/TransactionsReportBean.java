package com.micro.reportgenerator;

import java.math.BigDecimal;
import java.util.List;

public class TransactionsReportBean {
	private List<TransactionBean> transList;
	private BigDecimal totalAmt;
	public List<TransactionBean> getTransList() {
		return transList;
	}
	public void setTransList(List<TransactionBean> transList) {
		this.transList = transList;
	}
	public BigDecimal getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(BigDecimal totalAmt) {
		this.totalAmt = totalAmt;
	}
	
	
}
