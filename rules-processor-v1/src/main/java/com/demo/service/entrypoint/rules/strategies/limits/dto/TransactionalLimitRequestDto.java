package com.demo.service.entrypoint.rules.strategies.limits.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionalLimitRequestDto implements Serializable {

  private String currentLevel;
}
