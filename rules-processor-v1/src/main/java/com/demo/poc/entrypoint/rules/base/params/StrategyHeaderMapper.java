package com.demo.poc.entrypoint.rules.base.params;

import java.util.Map;

import com.demo.poc.commons.core.validations.ParamMapper;

import org.springframework.stereotype.Component;

@Component
public class StrategyHeaderMapper implements ParamMapper {

  @Override
  public Object map(Map<String, String> params) {
    StrategyHeader headers = new StrategyHeader();
    headers.setTraceId(params.get("trace-id"));
    headers.setChannelId(params.get("channel-id"));
    headers.setStrategy(params.get("strategy"));
    return headers;
  }

  @Override
  public boolean supports(Class<?> paramClass) {
    return StrategyHeader.class.isAssignableFrom(paramClass);
  }
}
