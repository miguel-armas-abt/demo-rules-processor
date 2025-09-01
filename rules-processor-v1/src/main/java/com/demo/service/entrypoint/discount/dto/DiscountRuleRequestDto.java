package com.demo.service.entrypoint.discount.dto;

import java.io.Serializable;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiscountRuleRequestDto implements Serializable {

  private Integer quantity;
  private String productCode;
}
