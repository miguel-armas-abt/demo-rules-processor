package com.demo.poc.commons.custom.exceptions;

import com.demo.poc.commons.core.errors.exceptions.GenericException;
import lombok.Getter;

@Getter
public class NoSuchRuleMapperException extends GenericException {

  public NoSuchRuleMapperException() {
    super(ErrorDictionary.ERROR_COMPILING_RULES.getMessage(), ErrorDictionary.parse(NoSuchRuleMapperException.class));
  }
}
