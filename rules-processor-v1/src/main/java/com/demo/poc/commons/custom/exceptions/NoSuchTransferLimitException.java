package com.demo.poc.commons.custom.exceptions;

import com.demo.poc.commons.core.constants.Symbol;
import com.demo.poc.commons.core.errors.exceptions.GenericException;
import lombok.Getter;


@Getter
public class NoSuchTransferLimitException extends GenericException {

  public NoSuchTransferLimitException(String levelCode) {
    super(ErrorDictionary.NO_SUCH_TRANSFER_LIMIT.getMessage() + Symbol.COLON_WITH_SPACE + levelCode, ErrorDictionary.parse(NoSuchTransferLimitException.class));
  }
}
