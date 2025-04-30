package com.demo.poc.entrypoint.rules.mapper;

import com.demo.poc.entrypoint.rules.rule.Rule;

public interface RuleMapper {

  Rule toRule(String jsonRequest);

  Object toResponse(Rule rule);

  boolean supports(String strategy);
}