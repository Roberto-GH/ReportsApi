package co.com.pragma.usecase.report;

import co.com.pragma.model.report.Report;
import co.com.pragma.model.report.gateways.ReportRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import java.math.BigDecimal;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

class ReportUseCaseTest {

    @Mock
    private ReportRepository reportRepository;

    @InjectMocks
    private ReportUseCase reportUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetReport() {
        Report report = new Report(1L, "2025-01-01", 10, BigDecimal.valueOf(100.00));

        when(reportRepository.getReport()).thenReturn(Mono.just(report));

        Mono<Report> result = reportUseCase.getReport();

        StepVerifier.create(result)
                .expectNext(report)
                .verifyComplete();

        verify(reportRepository).getReport();
    }
}