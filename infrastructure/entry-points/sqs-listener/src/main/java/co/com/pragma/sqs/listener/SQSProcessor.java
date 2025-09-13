package co.com.pragma.sqs.listener;

import co.com.pragma.model.report.ApprovedLoan;
import co.com.pragma.usecase.report.adapters.ApprovedLoanControllerUseCase;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.services.sqs.model.Message;

import java.util.function.Function;

@Service
public class SQSProcessor implements Function<Message, Mono<Void>> {

  private static final Logger LOG = LoggerFactory.getLogger(SQSProcessor.class);
  private static final Gson gson = new Gson();

  private final ApprovedLoanControllerUseCase approvedLoanControllerUseCase;

  public SQSProcessor(ApprovedLoanControllerUseCase approvedLoanControllerUseCase) {
    this.approvedLoanControllerUseCase = approvedLoanControllerUseCase;
  }

  @Override
  public Mono<Void> apply(Message message) {
    ApprovedLoan approvedLoan = gson.fromJson(message.body(), ApprovedLoan.class);
    LOG.info("Approved loan received {}", gson.toJson(approvedLoan));
    return approvedLoanControllerUseCase.saveApprovedLoan(approvedLoan);
  }

}
