package com.demo.poc.entrypoint.rules.exceptions;

import com.demo.poc.commons.core.errors.exceptions.GenericException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

public class RulesCompilationException extends GenericException {

  private static final String EXCEPTION_CODE = "01.01.02";

  public RulesCompilationException(String message) {
    super(
        EXCEPTION_CODE,
        "Error compiling rules: " + message,
        INTERNAL_SERVER_ERROR);
  }
}
