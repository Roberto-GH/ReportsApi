package co.com.pragma.model.report;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApprovedLoanTest {

    @Test
    void builderShouldCreateApprovedLoan() {
        String applicationLoanId = "app123";
        String email = "test@example.com";
        String subject = "Loan Approved";
        String message = "Your loan has been approved.";
        Integer status = 1;
        BigDecimal amount = new BigDecimal("1000.00");
        List<PaymentPlan> paymentPlan = Collections.emptyList();

        ApprovedLoan approvedLoan = ApprovedLoan.builder()
                .applicationLoanId(applicationLoanId)
                .email(email)
                .subject(subject)
                .message(message)
                .status(status)
                .amount(amount)
                .paymentPlan(paymentPlan)
                .build();

        assertNotNull(approvedLoan);
        assertEquals(applicationLoanId, approvedLoan.getApplicationLoanId());
        assertEquals(email, approvedLoan.getEmail());
        assertEquals(subject, approvedLoan.getSubject());
        assertEquals(message, approvedLoan.getMessage());
        assertEquals(status, approvedLoan.getStatus());
        assertEquals(amount, approvedLoan.getAmount());
        assertEquals(paymentPlan, approvedLoan.getPaymentPlan());
    }

    @Test
    void gettersShouldReturnCorrectValues() {
        ApprovedLoan approvedLoan = ApprovedLoan.builder()
                .applicationLoanId("app456")
                .email("another@example.com")
                .subject("Another Subject")
                .message("Another Message")
                .status(2)
                .amount(new BigDecimal("2000.00"))
                .paymentPlan(Collections.singletonList(PaymentPlan.builder().build()))
                .build();

        assertEquals("app456", approvedLoan.getApplicationLoanId());
        assertEquals("another@example.com", approvedLoan.getEmail());
        assertEquals("Another Subject", approvedLoan.getSubject());
        assertEquals("Another Message", approvedLoan.getMessage());
        assertEquals(2, approvedLoan.getStatus());
        assertEquals(new BigDecimal("2000.00"), approvedLoan.getAmount());
        assertFalse(approvedLoan.getPaymentPlan().isEmpty());
    }
}