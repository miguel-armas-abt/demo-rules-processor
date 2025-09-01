package com.demo.service.commons.rules.rest;

import com.demo.commons.validations.ParamValidator;
import com.demo.service.commons.rules.params.StrategyHeader;
import com.demo.service.commons.rules.service.RuleService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/poc/business/rules-processor/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class RuleProcessorRestService {

  private final RuleService ruleService;
  private final ParamValidator paramValidator;

  @PostMapping(value = "/execute")
  public ResponseEntity<Object> execute(HttpServletRequest httpServletRequest,
                                        @RequestBody String jsonRequest) {

    StrategyHeader headers = paramValidator.validateHeadersAndGet(httpServletRequest, StrategyHeader.class).getKey();
    Object result = ruleService.processRule(jsonRequest, headers.getStrategy());
    return ResponseEntity.ok(result);
  }
}