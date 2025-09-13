package co.com.pragma.model.report.exception;

import co.com.pragma.model.report.constants.ReportModelKeys;

public enum ErrorEnum {

  UNAUTHORIZED_ACCESS(ReportModelKeys.CODE_ERROR_AUTH_001, ReportModelKeys.DEFAULT_MESSAGE_AUTH_001, ReportModelKeys.STATUS_401),
  INVALID_TOKEN(ReportModelKeys.CODE_ERROR_AUTH_002, ReportModelKeys.DEFAULT_MESSAGE_AUTH_002, ReportModelKeys.STATUS_403),
  FORBIDDEN_ACCESS(ReportModelKeys.CODE_ERROR_AUTH_003, ReportModelKeys.DEFAULT_MESSAGE_AUTH_003, ReportModelKeys.STATUS_403),
  INTERNAL_SERVER_ERROR(ReportModelKeys.CODE_ERROR_SYS_001, ReportModelKeys.DEFAULT_MESSAGE_SYS_001, ReportModelKeys.STATUS_500),
  INTERNAL_CONFLIC_SERVER(ReportModelKeys.CODE_ERROR_RC_001, ReportModelKeys.DEFAULT_MESSAGE_RC_001, ReportModelKeys.STATUS_409);

  private final String code;
  private final String defaultMessage;
  private final int status;

  ErrorEnum(String code, String defaultMessage, int status) {
    this.code = code;
    this.defaultMessage = defaultMessage;
    this.status = status;
  }

  public String getCode() {
    return code;
  }

  public String getDefaultMessage() {
    return defaultMessage;
  }

  public int getStatus() {
    return status;
  }

}
