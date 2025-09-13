package co.com.pragma.usecase.report.adapters;

import co.com.pragma.model.report.Report;
import reactor.core.publisher.Mono;

public interface ReportControllerUserCase {

  Mono<Report> getReport();

}
