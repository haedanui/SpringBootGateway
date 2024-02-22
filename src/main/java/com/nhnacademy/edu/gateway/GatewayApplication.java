package com.nhnacademy.edu.gateway;

import com.nhnacademy.edu.gateway.adaptor.AccountAdaptor;
import com.nhnacademy.edu.gateway.domain.Account;
import com.nhnacademy.edu.gateway.domain.Task;
import com.nhnacademy.edu.gateway.service.AccountService;
import com.nhnacademy.edu.gateway.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

@ConfigurationPropertiesScan
@SpringBootApplication
@Slf4j
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

//	@Autowired
//	AccountService accountService;
//	@Bean
//	ApplicationListener<ApplicationReadyEvent> applicationReadyEventApplicationListener() {
//		return event -> {
//			accountService.createAccount(new Account(1L,"1","1","1","1","1"));
//			accountService.getAccounts()
//					.forEach(it -> log.info("multi: {}", it));
//
//			log.info("single: {}", accountService.getAccount("1"));
//		};
//	}

//	@Autowired
//	TaskService taskService;
//	@Bean
//		ApplicationListener<ApplicationReadyEvent> applicationReadyEventApplicationListener() {
//		return event -> {
//			taskService.createTask(new Task(1L, "1", "1", "1"));
//			taskService.getTasks()
//					.forEach(it -> log.info("multi: {}", it));
//
//			log.info("single: {}", taskService.getTask("1"));
//		};
//	}
}