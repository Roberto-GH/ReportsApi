package co.com.pragma.model.report;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PaymentPlanTest {

    @Test
    void builderShouldCreatePaymentPlan() {
        Integer month = 1;
        String principalForMonth = "100.00";
        BigDecimal principalForMonthNumber = new BigDecimal("100.00");
        String interestToPay = "10.00";
        String capitalPayment = "90.00";
        String obligationBalance = "900.00";

        PaymentPlan paymentPlan = PaymentPlan.builder()
                .month(month)
                .principalForMonth(principalForMonth)
                .principalForMonthNumber(principalForMonthNumber)
                .interestToPay(interestToPay)
                .capitalPayment(capitalPayment)
                .obligationBalance(obligationBalance)
                .build();

        assertNotNull(paymentPlan);
        assertEquals(month, paymentPlan.getMonth());
        assertEquals(principalForMonth, paymentPlan.getPrincipalForMonth());
        assertEquals(principalForMonthNumber, paymentPlan.getPrincipalForMonthNumber());
        assertEquals(interestToPay, paymentPlan.getInterestToPay());
        assertEquals(capitalPayment, paymentPlan.getCapitalPayment());
        assertEquals(obligationBalance, paymentPlan.getObligationBalance());
    }

    @Test
    void gettersShouldReturnCorrectValues() {
        PaymentPlan paymentPlan = PaymentPlan.builder()
                .month(2)
                .principalForMonth("200.00")
                .principalForMonthNumber(new BigDecimal("200.00"))
                .interestToPay("20.00")
                .capitalPayment("180.00")
                .obligationBalance("720.00")
                .build();

        assertEquals(2, paymentPlan.getMonth());
        assertEquals("200.00", paymentPlan.getPrincipalForMonth());
        assertEquals(new BigDecimal("200.00"), paymentPlan.getPrincipalForMonthNumber());
        assertEquals("20.00", paymentPlan.getInterestToPay());
        assertEquals("180.00", paymentPlan.getCapitalPayment());
        assertEquals("720.00", paymentPlan.getObligationBalance());
    }

    @Test
    void settersShouldSetCorrectValues() {
        PaymentPlan paymentPlan = new PaymentPlan.Builder().build(); // Use builder to create an instance

        Integer month = 3;
        String principalForMonth = "300.00";
        BigDecimal principalForMonthNumber = new BigDecimal("300.00");
        String interestToPay = "30.00";
        String capitalPayment = "270.00";
        String obligationBalance = "450.00";

        paymentPlan.setMonth(month);
        paymentPlan.setPrincipalForMonth(principalForMonth);
        paymentPlan.setPrincipalForMonthNumber(principalForMonthNumber);
        paymentPlan.setInterestToPay(interestToPay);
        paymentPlan.setCapitalPayment(capitalPayment);
        paymentPlan.setObligationBalance(obligationBalance);

        assertEquals(month, paymentPlan.getMonth());
        assertEquals(principalForMonth, paymentPlan.getPrincipalForMonth());
        assertEquals(principalForMonthNumber, paymentPlan.getPrincipalForMonthNumber());
        assertEquals(interestToPay, paymentPlan.getInterestToPay());
        assertEquals(capitalPayment, paymentPlan.getCapitalPayment());
        assertEquals(obligationBalance, paymentPlan.getObligationBalance());
    }
}