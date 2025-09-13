package co.com.pragma.usecase.report;

import co.com.pragma.model.report.Report;
import co.com.pragma.model.report.gateways.ReportRepository;
import co.com.pragma.usecase.report.adapters.ReportControllerUserCase;
import reactor.core.publisher.Mono;

public class ReportUseCase implements ReportControllerUserCase {

  private final ReportRepository reportRepository;

  public ReportUseCase(ReportRepository reportRepository) {
    this.reportRepository = reportRepository;
  }

  @Override
  public Mono<Report> getReport() {
    return reportRepository.getReport();
  }

}
