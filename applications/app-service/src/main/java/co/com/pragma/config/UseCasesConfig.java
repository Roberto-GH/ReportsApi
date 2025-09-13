package co.com.pragma.config;

import co.com.pragma.model.report.gateways.ApprovedLoanRepository;
import co.com.pragma.usecase.report.ApprovedLoanUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfig {

  @Bean
  public ApprovedLoanUseCase approvedLoanUseCase(ApprovedLoanRepository approvedLoanRepository) {
    return new ApprovedLoanUseCase(approvedLoanRepository);
  }

}
