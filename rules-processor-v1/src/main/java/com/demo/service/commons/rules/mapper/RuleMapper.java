package com.demo.service.commons.rules.mapper;

import com.demo.service.commons.rules.rule.Rule;
import com.demo.service.commons.rules.exceptions.NoSuchRuleMapperException;

import java.util.List;

public interface RuleMapper {

  Rule toRule(String jsonRequest);

  Object toResponse(Rule rule);

  boolean supports(String strategy);

  static RuleMapper selectRuleMapper(String strategy, List<RuleMapper> ruleMappers) {
    return ruleMappers.stream()
        .filter(mapper -> mapper.supports(strategy))
        .findFirst()
        .orElseThrow(NoSuchRuleMapperException::new);
  }
}