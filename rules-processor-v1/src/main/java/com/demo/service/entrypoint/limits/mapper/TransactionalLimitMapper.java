package com.demo.service.entrypoint.limits.mapper;

import com.demo.service.commons.rules.mapper.RuleMapper;
import com.demo.service.commons.rules.rule.Rule;
import com.demo.service.entrypoint.limits.dto.TransactionalLimitRequestDto;
import com.demo.service.entrypoint.limits.rule.TransactionalLimitRule;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionalLimitMapper implements RuleMapper {

  private final Gson gson;
  private final TransactionalLimitResponseMapper responseMapper;

  @Override
  public Rule toRule(String jsonRequest) {
    TransactionalLimitRequestDto request = gson.fromJson(jsonRequest, TransactionalLimitRequestDto.class);
    return TransactionalLimitRule.builder()
        .currentLevel(request.getCurrentLevel())
        .build();
  }

  @Override
  public Object toResponse(Rule rule) {
    TransactionalLimitRule transactionalLimitRule = (TransactionalLimitRule) rule;
    return transactionalLimitRule.getAvailableLimits()
        .stream()
        .map(responseMapper::toResponse)
        .toList();
  }

  @Override
  public boolean supports(String strategy) {
    return TransactionalLimitRule.class.getSimpleName().equals(strategy);
  }
}
