package com.demo.service.entrypoint.rules.strategies.limits.rule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.demo.service.entrypoint.rules.rule.Rule;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class TransactionalLimitRule extends Rule implements Serializable {

  //input
  private String currentLevel;

  //output
  private String nextLevel;
  private boolean higherLevel;
  private boolean lowerLevel;
  private boolean isActive;

  @Builder.Default
  private List<TransactionLimit> availableLimits = new ArrayList<>();

  public void dispatch(
      String nextLevel,
      boolean higherLevel,
      boolean lowerLevel,
      boolean isActive) {

    if(!isActive) return;

    this.availableLimits.add(TransactionLimit.builder()
            .level(nextLevel)
            .currentLevel(nextLevel.equalsIgnoreCase(this.currentLevel))
            .allowUpdate(higherLevel)
        .build());

  }

  @Builder
  @Setter
  @Getter
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class TransactionLimit implements Serializable {
    private String level;
    private boolean currentLevel;
    private boolean allowUpdate;
  }
}
