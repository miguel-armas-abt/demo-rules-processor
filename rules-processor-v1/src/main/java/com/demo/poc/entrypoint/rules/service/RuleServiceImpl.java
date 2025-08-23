package com.demo.poc.entrypoint.rules.service;

import com.demo.poc.entrypoint.rules.exceptions.NoSuchRuleMapperException;
import com.demo.poc.entrypoint.rules.processor.RuleProcessor;
import com.demo.poc.entrypoint.rules.mapper.RuleMapper;
import com.demo.poc.entrypoint.rules.rule.Rule;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RuleServiceImpl implements RuleService {

  private final RuleProcessor ruleProcessor;
  private final List<RuleMapper> ruleMappers;

  @Override
  public Object processRule(String jsonRequest, String strategy) {
    RuleMapper ruleMapper = selectRuleMapper(strategy);
    Rule rule = ruleMapper.toRule(jsonRequest);
    rule = ruleProcessor.process(rule);
    return ruleMapper.toResponse(rule);
  }

  private RuleMapper selectRuleMapper(String strategy) {
    return ruleMappers.stream()
        .filter(mapper -> mapper.supports(strategy))
        .findFirst()
        .orElseThrow(NoSuchRuleMapperException::new);
  }

}