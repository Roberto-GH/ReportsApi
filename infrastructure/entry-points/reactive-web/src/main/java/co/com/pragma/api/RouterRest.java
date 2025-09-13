package co.com.pragma.api;

import co.com.pragma.api.config.ReportsPath;
import co.com.pragma.api.constants.ReportsWebKeys;
import co.com.pragma.api.dto.ReportResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterRest {

  private final ReportsPath reportsPath;

  public RouterRest(ReportsPath reportsPath) {
    this.reportsPath = reportsPath;
  }

  @RouterOperations({
    @RouterOperation(
      path = ReportsWebKeys.OPEN_API_REPORT_PATH,
      method = RequestMethod.GET,
      beanClass = Handler.class,
      beanMethod = ReportsWebKeys.OPEN_API_BEAN_METHOD_GET_REPORT,
      operation = @Operation(
        operationId = ReportsWebKeys.OPEN_API_OPERATION_GET_REPORT,
        summary = ReportsWebKeys.OPEN_API_SUMMARY_GET_REPORT,
        responses = {
          @ApiResponse(
            responseCode = ReportsWebKeys.OPEN_API_RESPONSE_CODE,
            description = ReportsWebKeys.OPEN_API_DESCRIPTION_SUCCESS,
            content = @Content(mediaType = ReportsWebKeys.OPEN_API_MEDIA_TYPE,
              schema = @Schema(implementation = ReportResponseDto.class)))
        }
      ))
  })
  @Bean
  public RouterFunction<ServerResponse> routerFunction(Handler handler) {
    return route(GET(reportsPath.getReports()), handler::listenGETReport);
  }

}
