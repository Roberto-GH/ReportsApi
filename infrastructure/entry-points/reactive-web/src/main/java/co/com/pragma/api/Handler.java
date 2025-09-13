package co.com.pragma.api;

import co.com.pragma.api.exception.ReportApiException;
import co.com.pragma.api.mapper.ReportDtoMapper;
import co.com.pragma.model.report.exception.ErrorEnum;
import co.com.pragma.usecase.report.adapters.ReportControllerUserCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class Handler {

  private static final Logger LOG = LoggerFactory.getLogger(Handler.class);
  private final ReportControllerUserCase reportControllerUserCase;
  private final ReportDtoMapper reportDtoMapper;

  public Handler(ReportControllerUserCase reportControllerUserCase, ReportDtoMapper reportDtoMapper) {
    this.reportControllerUserCase = reportControllerUserCase;
    this.reportDtoMapper = reportDtoMapper;
  }

  @PreAuthorize("hasRole('ADMIN')")
  public Mono<ServerResponse> listenGETReport(ServerRequest serverRequest) {
    LOG.info("Received GET request{}", serverRequest.uri());
    return reportControllerUserCase
      .getReport()
      .switchIfEmpty(Mono.error(new ReportApiException(ErrorEnum.INTERNAL_CONFLIC_SERVER)))
      .doOnNext(result -> LOG.info("Report obtained => {}", result))
      .map(reportDtoMapper::toResponseDto)
      .flatMap(reportDto -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(reportDto));
  }

}
