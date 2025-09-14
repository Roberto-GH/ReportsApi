package co.com.pragma.model.report;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ReportTest {

    @Test
    void noArgsConstructorShouldCreateInstance() {
        Report report = new Report();
        assertNotNull(report);
    }

    @Test
    void allArgsConstructorShouldCreateInstanceWithValues() {
        Long reportId = 1L;
        String lastUpdated = "2025-01-01";
        Integer numberOfLoans = 10;
        BigDecimal totalAmount = new BigDecimal("1000.00");

        Report report = new Report(reportId, lastUpdated, numberOfLoans, totalAmount);

        assertNotNull(report);
        assertEquals(reportId, report.getReportId());
        assertEquals(lastUpdated, report.getLastUpdated());
        assertEquals(numberOfLoans, report.getNumberOfLoans());
        assertEquals(totalAmount, report.getTotalAmount());
    }

    @Test
    void gettersShouldReturnCorrectValues() {
        Report report = new Report(2L, "2025-01-02", 20, new BigDecimal("2000.00"));

        assertEquals(2L, report.getReportId());
        assertEquals("2025-01-02", report.getLastUpdated());
        assertEquals(20, report.getNumberOfLoans());
        assertEquals(new BigDecimal("2000.00"), report.getTotalAmount());
    }

    @Test
    void settersShouldSetCorrectValues() {
        Report report = new Report();

        Long reportId = 3L;
        String lastUpdated = "2025-01-03";
        Integer numberOfLoans = 30;
        BigDecimal totalAmount = new BigDecimal("3000.00");

        report.setReportId(reportId);
        report.setLastUpdated(lastUpdated);
        report.setNumberOfLoans(numberOfLoans);
        report.setTotalAmount(totalAmount);

        assertEquals(reportId, report.getReportId());
        assertEquals(lastUpdated, report.getLastUpdated());
        assertEquals(numberOfLoans, report.getNumberOfLoans());
        assertEquals(totalAmount, report.getTotalAmount());
    }
}