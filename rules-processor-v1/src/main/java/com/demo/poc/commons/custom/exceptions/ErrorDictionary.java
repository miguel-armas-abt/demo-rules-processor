package com.demo.poc.commons.custom.exceptions;

import com.demo.poc.commons.core.errors.exceptions.EmptyBaseUrlException;
import com.demo.poc.commons.core.errors.exceptions.GenericException;
import com.demo.poc.commons.core.errors.exceptions.InvalidFieldException;
import com.demo.poc.commons.core.errors.exceptions.JsonReadException;
import com.demo.poc.commons.core.errors.exceptions.NoSuchRestClientException;
import com.demo.poc.commons.core.errors.exceptions.ReflectiveParamAssignmentException;
import com.demo.poc.commons.core.errors.exceptions.ReflectiveParamMappingException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Getter
@RequiredArgsConstructor
public enum ErrorDictionary {

  //system=00
  INVALID_FIELD("11.00.01", "Invalid field", BAD_REQUEST, InvalidFieldException.class),
  NO_SUCH_REST_CLIENT("11.00.02", "No such rest client", INTERNAL_SERVER_ERROR, NoSuchRestClientException.class),
  ERROR_READING_JSON("11.00.03", "Error reading JSON", INTERNAL_SERVER_ERROR, JsonReadException.class),
  ERROR_MAPPING_REFLECTIVE_PARAMS("11.00.04", "Error mapping reflective params", INTERNAL_SERVER_ERROR, ReflectiveParamMappingException.class),
  ERROR_ASSIGN_REFLECTIVE_PARAMS("11.00.05", "Error assign reflective params", INTERNAL_SERVER_ERROR, ReflectiveParamAssignmentException.class),
  EMPTY_BASE_URL("11.00.06", "Base URL is required", INTERNAL_SERVER_ERROR, EmptyBaseUrlException.class),

  //custom=01
  ERROR_COMPILING_RULES("11.01.01", "Error compiling rules", INTERNAL_SERVER_ERROR, RulesCompilationException.class),
  NO_SUCH_RULE_MAPPER("11.01.02", "No such rule mapper", INTERNAL_SERVER_ERROR, NoSuchRuleMapperException.class);

  private final String code;
  private final String message;
  private final HttpStatus httpStatus;
  private final Class<? extends GenericException> exceptionClass;

  public static ErrorDictionary parse(Class<? extends GenericException> exceptionClass) {
    return Arrays.stream(ErrorDictionary.values())
            .filter(errorDetail -> errorDetail.getExceptionClass().isAssignableFrom(exceptionClass))
            .findFirst()
            .orElseThrow(() -> new GenericException("No such exception"));
  }
}
