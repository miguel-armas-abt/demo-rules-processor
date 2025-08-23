package com.demo.poc.entrypoint.rules.exceptions;

import com.demo.poc.commons.core.errors.exceptions.GenericException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

public class NoSuchTransferLimitException extends GenericException {

  private static final String EXCEPTION_CODE = "01.01.03";

  public NoSuchTransferLimitException(String levelCode) {
    super(
        EXCEPTION_CODE,
        "No such transfer limit: " + levelCode,
        INTERNAL_SERVER_ERROR);
  }
}
