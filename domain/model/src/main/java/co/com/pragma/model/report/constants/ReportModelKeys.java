package co.com.pragma.model.report.constants;

public class ReportModelKeys {

  private ReportModelKeys() throws InstantiationException {
    throw new InstantiationException("Instances are forbidden");
  }

  public static final String CODE_ERROR_AUTH_001 = "AUTH-001";
  public static final String CODE_ERROR_AUTH_002 = "AUTH-002";
  public static final String CODE_ERROR_AUTH_003 = "AUTH-003";
  public static final String CODE_ERROR_SYS_001 = "SYS-001";
  public static final String CODE_ERROR_RC_001 = "RC-001";

  public static final String DEFAULT_MESSAGE_AUTH_001 = "Unauthorized access.";
  public static final String DEFAULT_MESSAGE_AUTH_002 = "The provided token is invalid or has expired.";
  public static final String DEFAULT_MESSAGE_AUTH_003 = "Access denied.";
  public static final String DEFAULT_MESSAGE_SYS_001 = "Internal server error.";
  public static final String DEFAULT_MESSAGE_RC_001 = "Internal server conflic.";

  public static final int STATUS_400 = 400;
  public static final int STATUS_401 = 401;
  public static final int STATUS_403 = 403;
  public static final int STATUS_409 = 409;
  public static final int STATUS_500 = 500;

}
