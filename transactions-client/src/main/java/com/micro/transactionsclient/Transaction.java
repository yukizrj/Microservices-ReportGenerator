package com.micro.transactionsclient;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "requesttype")
	private int type;
	@Column(name = "sendername")
	private String senderName;
	@Column(name = "receivername")
	private String receiverName;
	private BigDecimal amount;
	@Column(name="createdtime")
	private String createdTime;
	
	
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", type=" + type + ", senderName=" + senderName + ", receiverName="
				+ receiverName + ", amount=" + amount + ", createdTime=" + createdTime + "]";
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(Long id, int type, String senderName, String receiverName, BigDecimal amount, String createdTime) {
		super();
		this.id = id;
		this.type = type;
		this.senderName = senderName;
		this.receiverName = receiverName;
		this.amount = amount;
		this.createdTime = createdTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	
	
}
