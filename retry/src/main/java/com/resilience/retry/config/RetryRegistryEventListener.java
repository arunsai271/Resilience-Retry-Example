package com.resilience.retry.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.resilience4j.retry.RetryRegistry;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RetryRegistryEventListener {

	@Autowired
	private RetryRegistry registry;

	@PostConstruct
	public void postConstruct() {
		registry.retry("sample-api").getEventPublisher()
				.onRetry(ev -> log.info("#### RetryRegistryEventListener message: {}", ev));
	}
}
