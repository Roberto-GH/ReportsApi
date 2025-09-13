package co.com.pragma.config;

import co.com.pragma.model.report.gateways.ApprovedLoanRepository;
import co.com.pragma.model.report.gateways.ReportRepository;
import co.com.pragma.usecase.report.ApprovedLoanUseCase;
import co.com.pragma.usecase.report.ReportUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfig {

  @Bean
  public ApprovedLoanUseCase approvedLoanUseCase(ApprovedLoanRepository approvedLoanRepository) {
    return new ApprovedLoanUseCase(approvedLoanRepository);
  }

  @Bean
  public ReportUseCase reportUseCase(ReportRepository reportRepository) {
    return new ReportUseCase(reportRepository);
  }

}
