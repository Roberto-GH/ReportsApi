package co.com.pragma.model.report.gateways;

import co.com.pragma.model.report.ApprovedLoan;
import reactor.core.publisher.Mono;

public interface ApprovedLoanRepository {

  Mono<Void> saveApprovedLoan(ApprovedLoan approvedLoan);

}
