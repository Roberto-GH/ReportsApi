package co.com.pragma.api.constants;

import lombok.Getter;

public class ReportsWebKeys {

  private ReportsWebKeys() throws InstantiationException {
    throw new InstantiationException("Instances are forbidden");
  }

  public static final String PATH_ROUTE_REPORT = "routes.report.paths";
  public static final String GET_METHOD = "GET";
  public static final String REGISTER_CORS_PATH = "/**";
  public static final String OPEN_API_TITLE = "Report API";
  public static final String OPEN_API_VERSION = "1.0.0";
  public static final String OPEN_API_DESCRIPTION = "API for reports management.";
  public static final String OPEN_API_SECURITY_NAME = "bearerAuth";
  public static final String OPEN_API_SCHEME = "bearer";
  public static final String OPEN_API_BEARER_FORMAT = "JWT";
  public static final String JWT_ERROR_BAD_TOKEN = "Bad token";
  public static final String JWT_ROLES = "roles";
  public static final String JWT_AUTHORITY = "authority";
  public static final String HEADER_AUTHORIZATION = "Authorization";
  public static final String STRING_BLANK = "";
  public static final String TOKEN = "token";
  public static final String STRING_AUTH = "auth";
  public static final String STRING_SWAGGER = "swagger";
  public static final String STRING_ACTUATOR = "actuator";
  public static final String STRING_DOCS = "v3/api-docs";
  public static final String STRING_WEBJARS = "webjars";
  public static final String NO_TOKEN = "No token was found";
  public static final String INVALID_TOKEN = "Invalid auth";
  public static final String SPRING = "spring";
  public static final String BEARER = "Bearer ";
  public static final String TOKEN_EXPIRED = "token expired";
  public static final String TOKEN_MALFORMED = "token malformed";
  public static final String BAD_SIGNATURE = "bad signature";
  public static final String ILLEGAL_ARGS = "illegal args";
  public static final String ERROR_ATTRIBUTE_MESSAGE = "message";
  public static final String ERROR_ATTRIBUTE_ERROR_CODE = "error_code";
  public static final String ERROR_ATTRIBUTE_ERROR = "error";
  public static final String ERROR_ATTRIBUTE_PATH = "path";
  public static final String WRITTING_JSON_ERROR = "{\"error\":\"Error writing JSON output\"}";
  public static final String OPEN_API_REPORT_PATH = "/api/v1/application";
  public static final String OPEN_API_BEAN_METHOD_GET_REPORT = "listenGetReport";
  public static final String OPEN_API_OPERATION_GET_REPORT = "getReport";
  public static final String OPEN_API_SUMMARY_GET_REPORT = "Get report";
  public static final String OPEN_API_RESPONSE_CODE = "200";
  public static final String OPEN_API_DESCRIPTION_SUCCESS = "Successful operation";
  public static final String OPEN_API_MEDIA_TYPE = "application/json";
  public static final String HEADER_MISSING = "header missing";

  public static final String[] ALLOWED_PATHS = new String[]{"/auth/**", "/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**", "/webjars/swagger-ui/**",
    "/actuator/prometheus/**", "/actuator/prometheus", "/actuator/**"};

  @Getter
  public enum HttpHeadersEnum {
    CSP_HEADER("Content-Security-Policy", "default-src 'self'; frame-ancestors 'self'; form-action 'self'"),
    STS_HEADER("Strict-Transport-Security", "max-age=31536000;"),
    XCTO_HEADER("X-Content-Type-Options", "nosniff"),
    SERVER_HEADER("Server", ""),
    CACHE_CONTROL_HEADER("Cache-Control", "no-store"),
    PRAGMA_HEADER("Pragma", "no-cache"),
    REFERRER_POLICY_HEADER("Referrer-Policy", "strict-origin-when-cross-origin");

    private final String key;
    private final String value;

    HttpHeadersEnum(String key, String value) {
      this.key = key;
      this.value = value;
    }

  }

}
