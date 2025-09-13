package co.com.pragma.api.exception;


import co.com.pragma.model.report.exception.CustomException;
import co.com.pragma.model.report.exception.ErrorEnum;
import lombok.Getter;

@Getter
public class ReportApiException extends CustomException {

  public ReportApiException(ErrorEnum errorEnum) {
    super(errorEnum);
  }

  public ReportApiException(ErrorEnum errorEnum, String customMessage) {
    super(errorEnum, customMessage);
  }

}
