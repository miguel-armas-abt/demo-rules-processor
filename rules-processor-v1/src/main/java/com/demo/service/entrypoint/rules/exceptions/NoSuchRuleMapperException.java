package com.demo.service.entrypoint.rules.exceptions;

import com.demo.commons.errors.exceptions.GenericException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

public class NoSuchRuleMapperException extends GenericException {

  private static final String EXCEPTION_CODE = "01.01.01";

  public NoSuchRuleMapperException() {
    super(
        EXCEPTION_CODE,
        "No such rule mapper implement",
        INTERNAL_SERVER_ERROR
    );
  }
}
