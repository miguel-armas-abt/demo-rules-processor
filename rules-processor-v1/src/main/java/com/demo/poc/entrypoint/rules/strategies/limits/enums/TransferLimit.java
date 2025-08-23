package com.demo.poc.entrypoint.rules.strategies.limits.enums;

import java.util.Arrays;

import com.demo.poc.entrypoint.rules.exceptions.NoSuchTransferLimitException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TransferLimit {

  LEVEL_ONE("01", 1500),
  LEVEL_TWO("02", 3000),
  LEVEL_THREE("03", 10000),
  LEVEL_FOUR("04", 30000),
  LEVEL_FIVE("05", 99999),
  LEVEL_SIX("06", 100000);

  private final String levelCode;
  private final double maximumAmount;

  public static TransferLimit parse(String levelCode) {
    return Arrays.stream(TransferLimit.values())
        .filter(transferLimit -> transferLimit.getLevelCode().equals(levelCode))
        .findFirst()
        .orElseThrow(() -> new NoSuchTransferLimitException(levelCode));
  }
}
