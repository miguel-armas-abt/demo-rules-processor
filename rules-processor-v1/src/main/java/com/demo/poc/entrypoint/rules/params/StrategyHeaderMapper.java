package com.demo.poc.entrypoint.rules.params;

import java.util.Map;

import com.demo.poc.commons.core.tracing.enums.ForwardedParam;
import com.demo.poc.commons.core.tracing.enums.TraceParam;
import com.demo.poc.commons.core.validations.ParamMapper;

import org.springframework.stereotype.Component;

@Component
public class StrategyHeaderMapper implements ParamMapper {

  @Override
  public Object map(Map<String, String> params) {
    StrategyHeader headers = new StrategyHeader();
    headers.setTraceId(params.get(TraceParam.TRACE_PARENT.getKey()));
    headers.setChannelId(params.get(ForwardedParam.CHANNEL_ID.getKey()));
    headers.setStrategy(params.get("strategy"));
    return headers;
  }

  @Override
  public boolean supports(Class<?> paramClass) {
    return StrategyHeader.class.isAssignableFrom(paramClass);
  }
}
