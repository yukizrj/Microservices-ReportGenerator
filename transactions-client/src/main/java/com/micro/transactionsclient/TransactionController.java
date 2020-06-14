package com.micro.transactionsclient;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.micrometer.core.instrument.util.StringUtils;

@RestController
public class TransactionController {
	@Autowired
	private TransRepository repo;
	
	@Autowired
	private Configuration config;
	
	@GetMapping("/trans")
	public List<Transaction> getAllTrans() {
		return repo.findAll();
	}
	
	@GetMapping("/trans/{id}")
	public Optional<Transaction> getTransById(@PathVariable int id) {
		return repo.findById((long) id);
	}
	
	@GetMapping("/trans/from/{sender}")
	public List<Transaction> getTransBySenderName(@PathVariable String sender) {
		return repo.findBySenderName(sender);
	}
	
	@GetMapping("/trans/from/{sender}/time/{time}")
	public List<Transaction> getTransBySenderAndTime(@PathVariable String sender, @PathVariable String time) {
		return repo.findBySenderAndTime(sender, time);
	}
	
	@GetMapping("/trans/time/{time}")
	public List<Transaction> getTransByTime(@PathVariable String time) {
		return repo.findByTime(time);
	}
	
	@PostMapping("/trans")
	public ResponseEntity<Object> addTrans(@RequestBody Transaction trans) {
		if(StringUtils.isEmpty(trans.getCreatedTime())) {
			String time = config.getDefaultDate();
			trans.setCreatedTime(time);
		}
		Transaction addedTrans = repo.save(trans);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addedTrans.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/trans/{id}")
	public ResponseEntity<Object> deleteTransById(@PathVariable int id) {
		repo.deleteById((long) id);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/trans").build().toUri();
		return ResponseEntity.created(location).build();
	}
	
}
