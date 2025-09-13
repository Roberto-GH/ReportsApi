package co.com.pragma.usecase.report.adapters;

import co.com.pragma.model.report.ApprovedLoan;
import reactor.core.publisher.Mono;

public interface ApprovedLoanControllerUseCase {

  Mono<Void> saveApprovedLoan(ApprovedLoan approvedLoan);

}
