package com.demo.poc.commons.custom.exceptions;

import com.demo.poc.commons.core.errors.exceptions.GenericException;
import lombok.Getter;

@Getter
public class RulesCompilationException extends GenericException {

  public RulesCompilationException(String message) {
    super(message, ErrorDictionary.parse(RulesCompilationException.class));
  }
}
