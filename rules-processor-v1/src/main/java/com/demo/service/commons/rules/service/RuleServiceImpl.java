package com.demo.service.commons.rules.service;

import com.demo.service.commons.rules.processor.RuleProcessor;
import com.demo.service.commons.rules.mapper.RuleMapper;
import com.demo.service.commons.rules.rule.Rule;
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
    RuleMapper ruleMapper = RuleMapper.selectRuleMapper(strategy, ruleMappers);
    Rule rule = ruleMapper.toRule(jsonRequest);
    rule = ruleProcessor.process(rule);
    return ruleMapper.toResponse(rule);
  }
}