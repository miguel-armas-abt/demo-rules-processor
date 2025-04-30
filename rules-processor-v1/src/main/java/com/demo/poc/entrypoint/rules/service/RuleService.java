package com.demo.poc.entrypoint.rules.service;

public interface RuleService {

  Object processRule(String jsonRequest, String strategy);
}
