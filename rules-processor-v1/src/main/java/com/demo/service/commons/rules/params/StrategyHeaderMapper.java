package com.demo.service.commons.rules.params;

import java.util.Map;
import java.util.TreeMap;

import com.demo.commons.tracing.enums.ForwardedParam;
import com.demo.commons.tracing.enums.TraceParam;
import com.demo.commons.validations.ParamMapper;

import org.springframework.stereotype.Component;

@Component
public class StrategyHeaderMapper implements ParamMapper<StrategyHeader> {

  private static final String STRATEGY_KEY = "strategy";

  @Override
  public Map.Entry<StrategyHeader, Map<String, String>> map(Map<String, String> params) {
    StrategyHeader headers = new StrategyHeader();
    headers.setTraceParent(params.get(TraceParam.TRACE_PARENT.getKey()));
    headers.setChannelId(params.get(ForwardedParam.CHANNEL_ID.getKey()));
    headers.setStrategy(params.get(STRATEGY_KEY));

    Map<String, String> headersMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    headersMap.put(TraceParam.TRACE_PARENT.getKey(), headers.getTraceParent());
    headersMap.put(ForwardedParam.CHANNEL_ID.getKey(), headers.getChannelId());
    headersMap.put(STRATEGY_KEY, headers.getStrategy());

    return Map.entry(headers, headersMap);
  }

  @Override
  public boolean supports(Class<?> paramClass) {
    return StrategyHeader.class.isAssignableFrom(paramClass);
  }
}
