package co.com.pragma.usecase.report;

import co.com.pragma.model.report.ApprovedLoan;
import co.com.pragma.model.report.gateways.ApprovedLoanRepository;
import co.com.pragma.usecase.report.adapters.ApprovedLoanControllerUseCase;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

public class ApprovedLoanUseCase implements ApprovedLoanControllerUseCase {

  private static final Logger LOG = Logger.getLogger(ApprovedLoanUseCase.class.getName());
  private final ApprovedLoanRepository approvedLoanRepository;

  public ApprovedLoanUseCase(ApprovedLoanRepository approvedLoanRepository) {
    this.approvedLoanRepository = approvedLoanRepository;
  }

  @Override
  public Mono<Void> saveApprovedLoan(ApprovedLoan approvedLoan) {
    LOG.info("Saving ApprovedLoan: " + approvedLoan.getApplicationLoanId());
    return approvedLoanRepository.saveApprovedLoan(approvedLoan);
  }

}
