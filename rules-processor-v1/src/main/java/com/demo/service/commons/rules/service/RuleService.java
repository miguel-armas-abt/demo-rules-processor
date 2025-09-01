package com.demo.service.commons.rules.service;

public interface RuleService {

  Object processRule(String jsonRequest, String strategy);
}
