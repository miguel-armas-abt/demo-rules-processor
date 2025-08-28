package com.demo.service.entrypoint.rules.params;

import com.demo.commons.validations.headers.DefaultHeaders;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StrategyHeader extends DefaultHeaders {

  @NotEmpty
  private String strategy;
}
