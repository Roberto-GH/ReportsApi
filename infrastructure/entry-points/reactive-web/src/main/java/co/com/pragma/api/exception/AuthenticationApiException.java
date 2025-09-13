package co.com.pragma.api.exception;

import co.com.pragma.model.report.exception.CustomException;
import co.com.pragma.model.report.exception.ErrorEnum;
import lombok.Getter;

@Getter
public class AuthenticationApiException extends CustomException {

  public AuthenticationApiException(ErrorEnum errorEnum) {
    super(errorEnum);
  }

  public AuthenticationApiException(ErrorEnum errorEnum, String customMessage) {
    super(errorEnum, customMessage);
  }

}
