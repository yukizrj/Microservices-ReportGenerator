package com.micro.transactionsclient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransRepository extends JpaRepository<Transaction, Long>{
	
	@Query("SELECT t FROM Transaction t WHERE t.senderName = ?1")
	List<Transaction> findBySenderName(String sendername);
	
	@Query("SELECT t FROM Transaction t WHERE t.createdTime = ?1")
	List<Transaction> findByTime(String createdtime);
	
	@Query("SELECT t FROM Transaction t WHERE t.senderName = ?1 AND t.createdTime = ?2")
	List<Transaction> findBySenderAndTime(String sendername, String createdtime);
	
}
