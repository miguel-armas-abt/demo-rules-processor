package com.demo.service.entrypoint.limits.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionLimitResponseDto implements Serializable {

  private String level;
  private boolean currentLevel;
  private boolean allowUpdate;
  private String maximumAmount;
}
