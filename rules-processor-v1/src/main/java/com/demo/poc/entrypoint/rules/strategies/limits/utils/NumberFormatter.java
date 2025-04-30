package com.demo.poc.entrypoint.rules.strategies.limits.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Optional;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NumberFormatter {

  private static final DecimalFormatSymbols DECIMAL_SYMBOLS = DecimalFormatSymbols.getInstance(Locale.US);

  public static String formatNumber(BigDecimal decimal, int scale) {
    return Optional.ofNullable(decimal)
        .map(number -> {
          String pattern = scale > 0
              ? "#,##0." + "0".repeat(scale)
              : "#,##0";
          DecimalFormat formatter = new DecimalFormat(pattern, DECIMAL_SYMBOLS);
          return formatter.format(number);
        })
        .orElse("0.0");
  }
}
