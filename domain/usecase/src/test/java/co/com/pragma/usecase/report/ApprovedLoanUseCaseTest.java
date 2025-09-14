package co.com.pragma.usecase.report;

import co.com.pragma.model.report.ApprovedLoan;
import co.com.pragma.model.report.gateways.ApprovedLoanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

class ApprovedLoanUseCaseTest {

    @Mock
    private ApprovedLoanRepository approvedLoanRepository;

    @InjectMocks
    private ApprovedLoanUseCase approvedLoanUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveApprovedLoan() {
        ApprovedLoan approvedLoan = ApprovedLoan.builder().applicationLoanId("testId").build();

        when(approvedLoanRepository.saveApprovedLoan(approvedLoan)).thenReturn(Mono.empty());

        Mono<Void> result = approvedLoanUseCase.saveApprovedLoan(approvedLoan);

        StepVerifier.create(result)
                .verifyComplete();
    }
}