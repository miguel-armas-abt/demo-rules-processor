package com.demo.service.entrypoint.rules.service;

public interface RuleService {

  Object processRule(String jsonRequest, String strategy);
}
