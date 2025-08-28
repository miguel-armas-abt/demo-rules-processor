package com.demo.service.entrypoint.rules.rest;

import com.demo.commons.restserver.utils.RestServerUtils;
import com.demo.commons.validations.ParamValidator;
import com.demo.service.entrypoint.rules.params.StrategyHeader;
import com.demo.service.entrypoint.rules.service.RuleService;
import io.reactivex.rxjava3.core.Single;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/poc/business/rules-processor/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class RuleProcessorRestService {

  private final RuleService ruleService;
  private final ParamValidator paramValidator;

  @PostMapping(value = "/execute")
  public Single<Object> execute(HttpServletRequest httpServletRequest,
                                @RequestBody String jsonRequest) {

    return paramValidator.validateAndGet(RestServerUtils.extractHeadersAsMap(httpServletRequest), StrategyHeader.class)
        .map(headers -> ruleService.processRule(jsonRequest, headers.getStrategy()));
  }
}