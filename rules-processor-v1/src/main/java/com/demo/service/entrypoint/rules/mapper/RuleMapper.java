package com.demo.service.entrypoint.rules.mapper;

import com.demo.service.entrypoint.rules.rule.Rule;

public interface RuleMapper {

  Rule toRule(String jsonRequest);

  Object toResponse(Rule rule);

  boolean supports(String strategy);
}